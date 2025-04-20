package skilltissue.effectpinger;

import eu.midnightdust.lib.config.MidnightConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.entity.effect.StatusEffectInstance;
import skilltissue.effectpinger.config.config;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;

import java.util.Set;
import java.util.HashSet;

import static skilltissue.effectpinger.config.config.*;

public class effectpinger implements ClientModInitializer {
	public static final String MOD_ID = "effectpinger";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	private static final SoundEvent WARNING_SOUND = SoundEvents.BLOCK_NOTE_BLOCK_PLING.value();

	private final Set<StatusEffectInstance> notifiedEffects = new HashSet<>();

	@Override
	public void onInitializeClient() {
		MidnightConfig.init(effectpinger.MOD_ID, config.class);
		LOGGER.info("_Skilltissue says hi");
		ClientTickEvents.END_CLIENT_TICK.register(this::checkEffects);
	}
	private void checkEffects(MinecraftClient client) {
		if (client.player == null) return;
		client.player.getActiveStatusEffects().forEach((effectType, effect) -> {
			if (effect.getDuration() == (activation * 20)+10) {
				if (!notifiedEffects.contains(effect)) {
					client.player.playSound(WARNING_SOUND, volume, pitch);
				}
			} else {notifiedEffects.remove(effect);}
		});
	}
}