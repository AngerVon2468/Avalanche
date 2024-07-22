package net.vault.avalanche.entity.model;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.*;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

import net.vault.avalanche.Avalanche;
import net.vault.avalanche.entity.custom.BloodClotEntity;

import org.jetbrains.annotations.NotNull;

public class BloodClotEntityModel<T extends BloodClotEntity> extends EntityModel<BloodClotEntity> {

    public static final EntityModelLayer LAYER_LOCATION = new EntityModelLayer(new Identifier(Avalanche.MOD_ID, "blood_clot"), "main");

    private final ModelPart main;

    public BloodClotEntityModel(@NotNull ModelPart root) {
        this.main = root.getChild("main");
    }

    public static @NotNull TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData main = modelPartData.addChild("main", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(1, -1).cuboid(0.0F, -0.5F, -1.0F, 0.0F, 3.0F, 7.0F, new Dilation(0.0F))
                .uv(3, 1).cuboid(0.0F, 0.0F, -1.75F, 0.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 16, 16);
    }

    @Override
    public void setAngles(BloodClotEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        main.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }
}