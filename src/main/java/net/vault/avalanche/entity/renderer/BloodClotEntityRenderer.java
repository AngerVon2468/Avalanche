package net.vault.avalanche.entity.renderer;

import net.fabricmc.api.*;

import net.minecraft.client.render.*;
import net.minecraft.client.render.entity.*;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;

import net.vault.avalanche.Avalanche;
import net.vault.avalanche.entity.custom.BloodClotEntity;
import net.vault.avalanche.entity.model.BloodClotEntityModel;

import org.jetbrains.annotations.NotNull;

@Environment(EnvType.CLIENT)
public class BloodClotEntityRenderer extends EntityRenderer<BloodClotEntity> {

    private final BloodClotEntityModel<BloodClotEntity> entityModel;

    public BloodClotEntityRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
        this.entityModel = new BloodClotEntityModel<>(ctx.getPart(BloodClotEntityModel.LAYER_LOCATION));
    }

    @Override
    public void render(@NotNull BloodClotEntity bloodClot, float yaw, float tickDelta, @NotNull MatrixStack matrices, @NotNull VertexConsumerProvider vertexConsumers, int light) {
        super.render(bloodClot, yaw, tickDelta, matrices, vertexConsumers, light);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(bloodClot.getYaw()));
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-bloodClot.getPitch()));
        VertexConsumer vertexConsumer = vertexConsumers.getBuffer(this.entityModel.getLayer(getTexture(bloodClot)));
        this.entityModel.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV, 1.0f, 1.0f, 1.0f, 1.0f);
    }

    @Override
    public Identifier getTexture(BloodClotEntity bloodClot) {
        return new Identifier(Avalanche.MOD_ID, "textures/entity/blood_clot.png");
    }
}