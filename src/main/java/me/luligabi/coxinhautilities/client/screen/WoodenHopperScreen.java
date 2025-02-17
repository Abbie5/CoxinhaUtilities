package me.luligabi.coxinhautilities.client.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import me.luligabi.coxinhautilities.common.CoxinhaUtilities;
import me.luligabi.coxinhautilities.mixin.HandledScreenAccessor;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

public class WoodenHopperScreen extends HandledScreen<ScreenHandler> {

    private static final Identifier TEXTURE = new Identifier(CoxinhaUtilities.MOD_ID, "textures/gui/wooden_hopper.png");

    public WoodenHopperScreen(ScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title.copyContentOnly().formatted(Formatting.WHITE));
        this.backgroundHeight = 133;

        ((HandledScreenAccessor) this).setPlayerInventoryTitle(playerInventoryTitle.copyContentOnly().formatted(Formatting.WHITE));
        this.playerInventoryTitleY = this.backgroundHeight - 94;
    }

    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        drawTexture(matrices, x, y, 0, 0, backgroundWidth, backgroundHeight);
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
        drawMouseoverTooltip(matrices, mouseX, mouseY);
    }
}