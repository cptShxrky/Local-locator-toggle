package io.github.locatortoggle.client.mixin;

import io.github.locatortoggle.client.LocatorToggleClient;
import net.minecraft.client.gui.Gui;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Ersetzt die Locator Bar durch die normale XP-Leiste, solange sie per Hotkey ausgeschaltet ist.
 * Hohe Priorität, damit wir nach anderen Mods (z. B. Local Locator) das letzte Wort haben.
 *
 * Der Rückgabetyp (Gui.ContextualInfo) ist privat, daher wird er hier generisch über Enum
 * angesprochen.
 */
@Mixin(value = Gui.class, priority = 1500)
public abstract class GuiMixin {

	@SuppressWarnings({"unchecked", "rawtypes"})
	@Inject(method = "nextContextualInfoState", at = @At("RETURN"), cancellable = true)
	private void locatortoggle$hideLocatorBar(CallbackInfoReturnable<Enum<?>> cir) {
		if (LocatorToggleClient.locatorEnabled) {
			return;
		}
		Enum<?> current = cir.getReturnValue();
		if (current != null && "LOCATOR".equals(current.name())) {
			cir.setReturnValue(Enum.valueOf((Class) current.getDeclaringClass(), "EXPERIENCE"));
		}
	}
}
