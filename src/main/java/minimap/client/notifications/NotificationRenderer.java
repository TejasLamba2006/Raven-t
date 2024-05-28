package minimap.client.notifications;

import com.google.common.eventbus.Subscribe;

import minimap.client.config.ConfigManager;
import minimap.client.event.impl.Render2DEvent;
import minimap.client.main.ClientConfig;
import minimap.client.module.Module;
import minimap.client.module.modules.client.GuiModule;
import minimap.client.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;

public class NotificationRenderer {
    public static final NotificationRenderer notificationRenderer = new NotificationRenderer();
    private static Minecraft mc = Minecraft.getMinecraft();

    @Subscribe
    public void onRender(Render2DEvent e) {
        if (GuiModule.notifications())
            NotificationManager.render();
    }

    public static void moduleStateChanged(Module m) {
        if (!GuiModule.notifications() || mc.currentScreen != null || ConfigManager.applyingConfig
                || ClientConfig.applyingConfig)
            return;

        if (!m.getClass().equals(Gui.class)) {
            String s = m.isEnabled() ? "enabled" : "disabled";
            NotificationManager
                    .show(new Notification(NotificationType.INFO, "Module " + s, m.getName() + " has been " + s, 1));
        }
    }
}