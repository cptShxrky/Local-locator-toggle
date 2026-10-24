package io.github.locatortoggle.client;

import com.mojang.blaze3d.platform.InputConstants;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.network.chat.Component;
import org.lwjgl.glfw.GLFW;

public class LocatorToggleClient implements ClientModInitializer {

	public static volatile boolean locatorEnabled = true;

	private static KeyMapping toggleKey;

	@Override
	public void onInitializeClient() {
		toggleKey = KeyBindingHelper.registerKeyBinding(new KeyMapping(
				"key.locatortoggle.toggle",
				InputConstants.Type.KEYSYM,
				GLFW.GLFW_KEY_K,
				KeyMapping.Category.MISC
		));

		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			while (toggleKey.consumeClick()) {
				locatorEnabled = !locatorEnabled;
				if (client.player != null) {
					client.player.displayClientMessage(
							Component.translatable(locatorEnabled
									? "message.locatortoggle.on"
									: "message.locatortoggle.off"),
							true);
				}
			}
		});
	}
}
