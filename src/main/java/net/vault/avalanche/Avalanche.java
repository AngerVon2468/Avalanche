package net.vault.avalanche;

import net.fabricmc.api.ModInitializer;

import net.vault.avalanche.block.ModBlocks;
import net.vault.avalanche.entity.ModEntities;
import net.vault.avalanche.item.*;

import org.slf4j.*;;

public class Avalanche implements ModInitializer {

	public static final String MOD_ID = "avalanche";

    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		Avalanche.LOGGER.info("Avalanche has started up");

		ModItemGroup.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModEntities.registerModEntities();
	}
}