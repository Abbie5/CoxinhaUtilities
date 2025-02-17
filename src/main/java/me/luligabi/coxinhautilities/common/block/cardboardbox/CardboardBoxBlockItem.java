package me.luligabi.coxinhautilities.common.block.cardboardbox;

import me.luligabi.coxinhautilities.common.CoxinhaUtilities;
import me.luligabi.coxinhautilities.common.block.BlockRegistry;
import me.luligabi.coxinhautilities.common.misc.TagRegistry;
import me.luligabi.coxinhautilities.mixin.LootableContainerBlockEntityAccessor;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtHelper;
import net.minecraft.nbt.NbtList;
import net.minecraft.registry.Registries;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Clearable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CardboardBoxBlockItem extends BlockItem {

    public CardboardBoxBlockItem() {
        super(BlockRegistry.CARDBOARD_BOX, new FabricItemSettings());
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if(!world.isClient()) {
            if(context.getPlayer().isSneaking() && blockEntity != null) {
                BlockState blockState = world.getBlockState(pos);
                if(blockState.getBlock().getHardness() >= 0.01F && isNbtBlockAir(context.getStack()) &&
                        !blockState.isIn(TagRegistry.UNBOXABLE) && !isOnCarrierBlackList(blockState) && !hasLootTable(blockEntity)) {

                    NbtList nbtList = new NbtList();
                    NbtCompound nbtCopy = blockEntity.createNbtWithId();
                    nbtCopy.remove("id");
                    nbtCopy.remove("x");
                    nbtCopy.remove("y");
                    nbtCopy.remove("z");
                    nbtList.add(nbtCopy);

                    // Desperate attempt to cover every edge case :)
                    Clearable.clear(blockEntity);
                    world.removeBlockEntity(pos);

                    world.setBlockState(pos, BlockRegistry.CARDBOARD_BOX.getPlacementState(new ItemPlacementContext(context)), 32);
                    world.playSound(null, pos, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, SoundCategory.BLOCKS, 1F, 1F);
                    blockEntity = world.getBlockEntity(pos); // refresh block entity
                    if (blockEntity instanceof CardboardBoxBlockEntity) {
                        ((CardboardBoxBlockEntity) blockEntity).blockState = blockState;
                        ((CardboardBoxBlockEntity) blockEntity).nbtCopy = nbtList;
                        blockEntity.markDirty();
                    }
                    context.getStack().decrement(1);
                    return ActionResult.PASS;
                }
            }
        }
        return super.useOnBlock(context);
    }

    private boolean isOnCarrierBlackList(BlockState blockState) {
        if(!CoxinhaUtilities.CONFIG.useCarrierBlacklist) return false;
        return blockState.isIn(TagRegistry.CARRIER_BLACKLIST);
    }

    private boolean hasLootTable(BlockEntity blockEntity) {
        if(blockEntity instanceof LootableContainerBlockEntity) {
            return ((LootableContainerBlockEntityAccessor) blockEntity).getLootTableId() != null;
        }
        return false;
    }

    private boolean isNbtBlockAir(ItemStack stack) {
        return NbtHelper.toBlockState(Registries.BLOCK.getReadOnlyWrapper(), stack.getOrCreateNbt().getCompound("BlockEntityTag").getCompound("BlockState")).isAir();
    }

}