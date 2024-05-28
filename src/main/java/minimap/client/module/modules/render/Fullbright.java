package minimap.client.module.modules.render;

import minimap.client.module.Module;
import minimap.client.module.setting.Setting;
import minimap.client.module.setting.impl.ComboSetting;
import minimap.client.module.setting.impl.DescriptionSetting;
import minimap.client.utils.Utils;

public class Fullbright extends Module {

    private float originalGamma;
    private ComboSetting mode;
    public static boolean nightVision;

    public Fullbright() {
        super("Fullbright", ModuleCategory.render);
        this.registerSetting(mode = new ComboSetting("Mode", Mode.GAMMA));
        this.registerSetting(new DescriptionSetting("No more darkness!"));
    }

    @Override
    public void postApplyConfig() {
        onEnable();
    }

    @Override
    public void onEnable() {
        switch ((Mode) mode.getMode()) {
        case GAMMA:
            originalGamma = mc.gameSettings.gammaSetting;
            mc.gameSettings.gammaSetting = 100;
            break;
        case NIGHTVISION:
            nightVision = true;
            break;
        }
    }

    @Override
    public void onDisable() {
        revertChanges((Mode) mode.getMode());
    }

    public void revertChanges(Mode mode) {
        switch (mode) {
        case GAMMA:
            mc.gameSettings.gammaSetting = originalGamma > 10 ? 1 : originalGamma;
            Utils.Player.sendMessageToSelf("" + mc.gameSettings.gammaSetting);
            break;
        case NIGHTVISION:
            nightVision = false;
            break;
        }
    }

    @Override
    public void guiButtonToggled(Setting b) {
        if (b == mode) {
            revertChanges((Mode) mode.getPrevMode());
            onEnable();
        }
    }


    public enum Mode {
        GAMMA, NIGHTVISION
    }
}
