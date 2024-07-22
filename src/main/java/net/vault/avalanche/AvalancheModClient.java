package net.vault.avalanche;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.*;

import net.vault.avalanche.entity.ModEntities;
import net.vault.avalanche.entity.model.BloodClotEntityModel;
import net.vault.avalanche.entity.renderer.BloodClotEntityRenderer;

public class AvalancheModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        EntityModelLayerRegistry.registerModelLayer(BloodClotEntityModel.LAYER_LOCATION, BloodClotEntityModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.BLOOD_CLOT, BloodClotEntityRenderer::new);
    }
}
