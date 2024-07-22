package net.vault.avalanche.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;

import net.minecraft.entity.*;
import net.minecraft.registry.*;
import net.minecraft.util.Identifier;

import net.vault.avalanche.Avalanche;
import net.vault.avalanche.entity.custom.BloodClotEntity;

public class ModEntities {

    public static final EntityType<BloodClotEntity> BLOOD_CLOT = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(Avalanche.MOD_ID, "blood_clot"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, BloodClotEntity::new)
                    .dimensions(EntityDimensions.fixed(1f,1f))
                    .fireImmune()
                    .trackRangeBlocks(5000)
                    .spawnableFarFromPlayer()
                    .build()
    );

    public static void registerModEntities() {
        Avalanche.LOGGER.info("Avalanche has registered its entities.");
    }
}