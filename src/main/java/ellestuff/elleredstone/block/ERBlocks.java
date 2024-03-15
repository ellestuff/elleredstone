package ellestuff.elleredstone.block;

import ellestuff.elleredstone.EllesRedstone;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ERBlocks {
    public static final Block COLOURED_LAMP = registerBlock("coloured_lamp",
            new ColouredLampBlock(FabricBlockSettings.create().luminance(ColouredLampBlock.STATE_TO_LUMINANCE).strength(0.3F).sounds(BlockSoundGroup.GLASS).allowsSpawning(Blocks::always)));

    public static final Block COLOURED_BULB = registerBlock("coloured_bulb",
            new ColouredBulbBlock(FabricBlockSettings.create().luminance(ColouredLampBlock.STATE_TO_LUMINANCE).strength(0.3F).sounds(BlockSoundGroup.COPPER).allowsSpawning(Blocks::always)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(EllesRedstone.MOD_ID, name), block);
    }

    public static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(EllesRedstone.MOD_ID, name),
            new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        EllesRedstone.LOGGER.info("Registering Blocks for" + EllesRedstone.MOD_ID);
    }
}
