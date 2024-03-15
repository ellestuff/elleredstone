package ellestuff.elleredstone;

import ellestuff.elleredstone.block.ERBlocks;
import ellestuff.elleredstone.items.ERItems;
import ellestuff.elleredstone.sound.ERSounds;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EllesRedstone implements ModInitializer {
	public static final String MOD_ID = "elleredstone";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	@Override
	public void onInitialize() {
		LOGGER.info("Initializing mod...");

		ERBlocks.registerModBlocks();
		ERItems.registerModItems();
		ERSounds.registerModSounds();
	}
}