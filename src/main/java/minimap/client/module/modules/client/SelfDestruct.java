package minimap.client.module.modules.client;

import minimap.client.main.Raven;
import minimap.client.module.Module;
import minimap.client.notifications.NotificationRenderer;
import net.minecraftforge.common.MinecraftForge;

public class SelfDestruct extends Module {
    
    public static boolean selfDestructed;
    
    public SelfDestruct() {
        super("Self Destruct", ModuleCategory.client);
    }

    public void onEnable() {
        this.disable();
        selfDestructed = true;
        mc.displayGuiScreen(null);

        for (Module module : Raven.moduleManager.getModules()) {
            module.unRegister();
        }
        for(Object obj : Raven.registered) {
            MinecraftForge.EVENT_BUS.unregister(obj);
        }

        /*
         * that just fully unload the event system so we don't need to care anymore
         * about the state of the mod... if it has been self-destructed events won't be
         * called including if they're still registered
         */

        Raven.eventBus.unregister(NotificationRenderer.notificationRenderer);
        // TODO: throw forge events out the window
    }
}
