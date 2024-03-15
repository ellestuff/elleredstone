package ellestuff.elleredstone.sound;

import ellestuff.elleredstone.EllesRedstone;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

public class ERSounds {
    public static final SoundEvent BLOCK_COLOURED_BULB_TURN_ON = registerSoundEvent("block.coloured_bulb.turn_on");
    public static final SoundEvent BLOCK_COLOURED_BULB_TURN_OFF = registerSoundEvent("block.coloured_bulb.turn_off");

    /*public static final SoundEvent BLOCK_COLOURED_BULB_BREAK = registerSoundEvent("block.coloured_bulb.break");
    public static final SoundEvent BLOCK_COLOURED_BULB_STEP = registerSoundEvent("block.coloured_bulb.step");
    public static final SoundEvent BLOCK_COLOURED_BULB_PLACE = registerSoundEvent("block.coloured_bulb.place");
    public static final SoundEvent BLOCK_COLOURED_BULB_HIT = registerSoundEvent("block.coloured_bulb.hit");
    public static final SoundEvent BLOCK_COLOURED_BULB_FALL = registerSoundEvent("block.coloured_bulb.fall");

    public static final BlockSoundGroup BLOCK_COLOURED_BULB_SOUNDS = new BlockSoundGroup(1f,1f,
            ERSounds.BLOCK_COLOURED_BULB_BREAK,
            ERSounds.BLOCK_COLOURED_BULB_STEP,
            ERSounds.BLOCK_COLOURED_BULB_PLACE,
            ERSounds.BLOCK_COLOURED_BULB_HIT,
            ERSounds.BLOCK_COLOURED_BULB_FALL
    );*/

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(EllesRedstone.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerModSounds() {
        EllesRedstone.LOGGER.info("Registering Blocks for" + EllesRedstone.MOD_ID);
    }
}
