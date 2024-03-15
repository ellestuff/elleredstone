package ellestuff.elleredstone.items;

import ellestuff.elleredstone.EllesRedstone;
import ellestuff.elleredstone.block.ERBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ERItems {
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(EllesRedstone.MOD_ID, name), item);
    }

    public static void registerModItems() {
        // Redstone Group
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(content -> {
            content.addAfter(Items.REDSTONE_LAMP, ERBlocks.COLOURED_LAMP);
        });
    }
}
