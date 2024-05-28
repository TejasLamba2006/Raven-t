package minimap.client.module.modules.movement;

import com.google.common.eventbus.Subscribe;
import minimap.client.event.impl.TickEvent;
import minimap.client.module.Module;
import minimap.client.module.setting.impl.TickSetting;
import minimap.client.utils.Utils;
import net.minecraft.client.settings.KeyBinding;

public class Sprint extends Module {
    public static TickSetting multiDir, ignoreBlindness;

    public Sprint() {
        super("Sprint", ModuleCategory.movement);
        this.registerSetting(multiDir = new TickSetting("All Directions", false));
        this.registerSetting(ignoreBlindness = new TickSetting("Ignore Blindness", false));
    }

    @Subscribe
    public void p(TickEvent e) {
        if (Utils.Player.isPlayerInGame() && mc.inGameHasFocus) {
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
        }
    }

}
