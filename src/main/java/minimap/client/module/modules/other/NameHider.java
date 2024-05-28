package minimap.client.module.modules.other;

import minimap.client.module.Module;
import minimap.client.module.setting.impl.DescriptionSetting;
import minimap.client.utils.Utils;

public class NameHider extends Module {
    public static DescriptionSetting a;
    public static String n = "ravenb++";
    public static String playerNick = "";

    public NameHider() {
        super("Name Hider", ModuleCategory.other);
        this.registerSetting(a = new DescriptionSetting(Utils.Java.capitalizeWord("command") + ": cname [name]"));
    }

    public static String format(String s) {
        if (mc.thePlayer != null) {
            s = playerNick.isEmpty() ? s.replace(mc.thePlayer.getName(), n) : s.replace(playerNick, n);
        }

        return s;
    }
}
