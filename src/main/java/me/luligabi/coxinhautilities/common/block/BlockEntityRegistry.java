package me.luligabi.coxinhautilities.common.block;

import me.luligabi.coxinhautilities.client.renderer.blockentity.DryingRackBlockEntityRenderer;
import me.luligabi.coxinhautilities.client.renderer.blockentity.GrannysSinkBlockEntityRenderer;
import me.luligabi.coxinhautilities.client.renderer.blockentity.PortableTankBlockEntityRenderer;
import me.luligabi.coxinhautilities.common.CoxinhaUtilities;
import me.luligabi.coxinhautilities.common.block.cardboardbox.CardboardBoxBlockEntity;
import me.luligabi.coxinhautilities.common.block.dryingrack.DryingRackBlockEntity;
import me.luligabi.coxinhautilities.common.block.sink.GrannysSinkBlockEntity;
import me.luligabi.coxinhautilities.common.block.tank.PortableTankBlockEntity;
import me.luligabi.coxinhautilities.common.block.trashcan.energy.EnergyTrashCanBlockEntity;
import me.luligabi.coxinhautilities.common.block.trashcan.fluid.FluidTrashCanBlockEntity;
import me.luligabi.coxinhautilities.common.block.woodenhopper.WoodenHopperBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class BlockEntityRegistry {

    public static void init() {
        WOODEN_HOPPER_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(CoxinhaUtilities.MOD_ID, "wooden_hopper"), FabricBlockEntityTypeBuilder.create(WoodenHopperBlockEntity::new, BlockRegistry.WOODEN_HOPPER).build(null));

        PORTABLE_TANK_MK1_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(CoxinhaUtilities.MOD_ID, "portable_tank_mk1"), FabricBlockEntityTypeBuilder.create(PortableTankBlockEntity::new, BlockRegistry.PORTABLE_TANK_MK1).build(null));
        PORTABLE_TANK_MK2_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(CoxinhaUtilities.MOD_ID, "portable_tank_mk2"), FabricBlockEntityTypeBuilder.create(PortableTankBlockEntity::new, BlockRegistry.PORTABLE_TANK_MK2).build(null));
        PORTABLE_TANK_MK3_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(CoxinhaUtilities.MOD_ID, "portable_tank_mk3"), FabricBlockEntityTypeBuilder.create(PortableTankBlockEntity::new, BlockRegistry.PORTABLE_TANK_MK3).build(null));
        PORTABLE_TANK_MK4_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(CoxinhaUtilities.MOD_ID, "portable_tank_mk4"), FabricBlockEntityTypeBuilder.create(PortableTankBlockEntity::new, BlockRegistry.PORTABLE_TANK_MK4).build(null));
        PORTABLE_TANK_MK5_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(CoxinhaUtilities.MOD_ID, "portable_tank_mk5"), FabricBlockEntityTypeBuilder.create(PortableTankBlockEntity::new, BlockRegistry.PORTABLE_TANK_MK5).build(null));

        GRANNYS_SINK_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(CoxinhaUtilities.MOD_ID, "grannys_sink"), FabricBlockEntityTypeBuilder.create(GrannysSinkBlockEntity::new, BlockRegistry.GRANNYS_SINK).build(null));

        FLUID_TRASH_CAN_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(CoxinhaUtilities.MOD_ID, "fluid_trash_can"), FabricBlockEntityTypeBuilder.create(FluidTrashCanBlockEntity::new, BlockRegistry.FLUID_TRASH_CAN).build(null));
        ENERGY_TRASH_CAN_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(CoxinhaUtilities.MOD_ID, "energy_trash_can"), FabricBlockEntityTypeBuilder.create(EnergyTrashCanBlockEntity::new, BlockRegistry.ENERGY_TRASH_CAN).build(null));


        DRYING_RACK_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(CoxinhaUtilities.MOD_ID, "drying_rack"), FabricBlockEntityTypeBuilder.create(DryingRackBlockEntity::new, BlockRegistry.DRYING_RACK).build(null));

        CARDBOARD_BOX_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(CoxinhaUtilities.MOD_ID, "cardboard_box"), FabricBlockEntityTypeBuilder.create(CardboardBoxBlockEntity::new, BlockRegistry.CARDBOARD_BOX).build(null));
    }

    public static void clientInit() {
        BlockEntityRendererFactories.register(BlockEntityRegistry.PORTABLE_TANK_MK1_BLOCK_ENTITY, PortableTankBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(BlockEntityRegistry.PORTABLE_TANK_MK2_BLOCK_ENTITY, PortableTankBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(BlockEntityRegistry.PORTABLE_TANK_MK3_BLOCK_ENTITY, PortableTankBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(BlockEntityRegistry.PORTABLE_TANK_MK4_BLOCK_ENTITY, PortableTankBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(BlockEntityRegistry.PORTABLE_TANK_MK5_BLOCK_ENTITY, PortableTankBlockEntityRenderer::new);

        BlockEntityRendererFactories.register(BlockEntityRegistry.GRANNYS_SINK_BLOCK_ENTITY, GrannysSinkBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(BlockEntityRegistry.DRYING_RACK_BLOCK_ENTITY, DryingRackBlockEntityRenderer::new);
    }

    public static BlockEntityType<WoodenHopperBlockEntity> WOODEN_HOPPER_ENTITY;

    public static BlockEntityType<PortableTankBlockEntity> PORTABLE_TANK_MK1_BLOCK_ENTITY; // TODO: Change this to use only one BlockEntityType when #1699 is merged.
    public static BlockEntityType<PortableTankBlockEntity> PORTABLE_TANK_MK2_BLOCK_ENTITY;
    public static BlockEntityType<PortableTankBlockEntity> PORTABLE_TANK_MK3_BLOCK_ENTITY;
    public static BlockEntityType<PortableTankBlockEntity> PORTABLE_TANK_MK4_BLOCK_ENTITY;
    public static BlockEntityType<PortableTankBlockEntity> PORTABLE_TANK_MK5_BLOCK_ENTITY;

    public static BlockEntityType<GrannysSinkBlockEntity> GRANNYS_SINK_BLOCK_ENTITY;

    public static BlockEntityType<FluidTrashCanBlockEntity> FLUID_TRASH_CAN_BLOCK_ENTITY;
    public static BlockEntityType<EnergyTrashCanBlockEntity> ENERGY_TRASH_CAN_BLOCK_ENTITY;

    public static BlockEntityType<DryingRackBlockEntity> DRYING_RACK_BLOCK_ENTITY;

    public static BlockEntityType<CardboardBoxBlockEntity> CARDBOARD_BOX_BLOCK_ENTITY;
}