package skilltissue.effectpinger.config;

import eu.midnightdust.lib.config.MidnightConfig;
//import net.minecraft.sound.SoundEvents; (to be added)

public class config extends MidnightConfig {
    public static final String EFFECT = "effect";

    //@Entry(category = EFFECT, name = "Sound ID") public static String soundID = SoundEvents.BLOCK_NOTE_BLOCK_PLING.getIdAsString();  (to be added)
    @Entry(category = EFFECT, name = "Sound pitch", isSlider = true, min = 0.5f, max = 5, precision = 10) public static float pitch = 1;
    @Entry(category = EFFECT, name = "Sound Volume", isSlider = true, min = 0f, max = 2f, precision = 10) public static float volume = 1;
    @Entry(category = EFFECT, name = "Activation time", isSlider = true, min = 1F, max = 30) public static int activation = 15;
}