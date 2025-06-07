package rs.onako2.iwie.sound;

import com.jcraft.jorbis.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import rs.onako2.iwie.Init;

public class ModSounds {

    public static final SoundEvent ENTITY_CREAKING_AMBIENT = registerSoundEvent("creaking_ambient");
    public static final SoundEvent ENTITY_CREAKING_ACTIVATE = registerSoundEvent("creaking_activate");
    public static final SoundEvent ENTITY_CREAKING_DEACTIVATE = registerSoundEvent("creaking_deactivate");
    public static final SoundEvent ENTITY_CREAKING_ATTACK = registerSoundEvent("creaking_attack");
    public static final SoundEvent ENTITY_CREAKING_DEATH = registerSoundEvent("creaking_death");
    public static final SoundEvent ENTITY_CREAKING_STEP = registerSoundEvent("creaking_step"); //done
    public static final SoundEvent ENTITY_CREAKING_FREEZE = registerSoundEvent("creaking_freeze");
    public static final SoundEvent ENTITY_CREAKING_UNFREEZE = registerSoundEvent("creaking_unfreeze");
    public static final SoundEvent ENTITY_CREAKING_SPAWN = registerSoundEvent("creaking_spawn");
    public static final SoundEvent ENTITY_CREAKING_SWAY = registerSoundEvent("creaking_sway");
    public static final SoundEvent ENTITY_CREAKING_TWITCH = registerSoundEvent("creaking_twitch");

    //
    public static final SoundEvent BLOCK_CREAKING_HEART_BREAK = registerSoundEvent("creaking_heart_break");
    public static final SoundEvent BLOCK_CREAKING_HEART_FALL = registerSoundEvent("creaking_heart_fall");
    public static final SoundEvent BLOCK_CREAKING_HEART_HIT = registerSoundEvent("creaking_heart_hit");
    public static final SoundEvent BLOCK_CREAKING_HEART_HURT = registerSoundEvent("creaking_heart_hurt");
    public static final SoundEvent BLOCK_CREAKING_HEART_PLACE = registerSoundEvent("creaking_heart_place");
    public static final SoundEvent BLOCK_CREAKING_HEART_STEP = registerSoundEvent("creaking_heart_step");
    public static final SoundEvent BLOCK_CREAKING_HEART_IDLE = registerSoundEvent("creaking_heart_idle");
    public static final SoundEvent BLOCK_CREAKING_HEART_SPAWN = registerSoundEvent("creaking_heart_spawn");

    public static final BlockSoundGroup CREAKING_SOUNDS = new BlockSoundGroup(1f, 1f,
            BLOCK_CREAKING_HEART_BREAK, BLOCK_CREAKING_HEART_STEP, BLOCK_CREAKING_HEART_PLACE, BLOCK_CREAKING_HEART_HIT, BLOCK_CREAKING_HEART_FALL);

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(Init.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }


    public static void registerSounds() {
        Init.LOGGER.info("Registering Sounds for IWIE");
    }
}
