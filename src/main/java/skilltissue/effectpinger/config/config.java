package skilltissue.effectpinger.config;

import com.google.common.collect.Lists;
import eu.midnightdust.lib.config.MidnightConfig;

import java.util.List;

public class config extends MidnightConfig {
    public static final String EFFECT = "effect";

    @Entry(category = EFFECT, name = "Sound ID")
    public static String soundID = "minecraft:block.note_block.pling";
    @Entry(category = EFFECT, name = "Sound pitch", min = 0.5f, max = 5)
    public static float pitch = 1;
    @Entry(category = EFFECT, name = "Sound Volume", min = 0f, max = 2f)
    public static float volume = 1;
    @Entry(category = EFFECT, name = "Activation time (seconds)", isSlider = true, min = 1F, max = 30)
    public static int activation = 10;
    @Entry(category = EFFECT, name = "Effects to notify about")
    public static List<String> effects = Lists.newArrayList(
            "minecraft:strength",
            "minecraft:speed",
            "minecraft:fire_resistance",
            "minecraft:invisibility"
    );
}