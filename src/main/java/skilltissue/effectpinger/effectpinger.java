package skilltissue.effectpinger;

import eu.midnightdust.lib.config.MidnightConfig;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.sound.SoundEvent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.util.Identifier;
import skilltissue.effectpinger.config.config;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;

import java.util.Set;
import java.util.HashSet;

import static skilltissue.effectpinger.config.config.*;

public class effectpinger implements ClientModInitializer {
	public static final String MOD_ID = "effectpinger";

	private final Set<StatusEffectInstance> notifyEffects = new HashSet<>();

	@Override
	public void onInitializeClient() {
		MidnightConfig.init(effectpinger.MOD_ID, config.class);
		ClientTickEvents.END_CLIENT_TICK.register(this::checkEffects);
	}

	private void checkEffects(MinecraftClient client) {
		if (client.player == null) return;
		client.player.getActiveStatusEffects().forEach((effectEntry, effect) -> {
			StatusEffect effectType = effectEntry.value();
			if (config.effects.contains(Registries.STATUS_EFFECT.getId(effectType).toString()))
				if (effect.getDuration() == (activation * 20)+10) {
					if (!notifyEffects.contains(effect)) {
						client.player.playSound(SoundEvent.of(Identifier.of(soundID)), volume, pitch);
					}
				} else {notifyEffects.remove(effect);}
		});
	}
}