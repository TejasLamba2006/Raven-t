package minimap.client.module.modules.movement;

import com.google.common.eventbus.Subscribe;
import minimap.client.clickgui.raven.ClickGui;
import minimap.client.event.impl.TickEvent;
import minimap.client.module.Module;
import minimap.client.module.setting.impl.SliderSetting;
import minimap.client.module.setting.impl.TickSetting;
import minimap.client.utils.Utils;

public class Timer extends Module {
    public static SliderSetting a;
    public static TickSetting b;

    public Timer() {
        super("Timer", ModuleCategory.movement);
        a = new SliderSetting("Speed", 1.0D, 0.5D, 2.5D, 0.01D);
        b = new TickSetting("Strafe only", false);
        this.registerSetting(a);
        this.registerSetting(b);
    }

    @Subscribe
    public void onTick(TickEvent e) {
        if (!(mc.currentScreen instanceof ClickGui)) {
            if (b.isToggled() && mc.thePlayer.moveStrafing == 0.0F) {
                Utils.Client.resetTimer();
                return;
            }

            Utils.Client.getTimer().timerSpeed = (float) a.getInput();
        } else {
            Utils.Client.resetTimer();
        }

    }

    public void onDisable() {
        Utils.Client.resetTimer();
    }
}
