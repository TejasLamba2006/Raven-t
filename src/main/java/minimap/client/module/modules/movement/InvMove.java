package minimap.client.module.modules.movement;

import com.google.common.eventbus.Subscribe;
import minimap.client.clickgui.raven.ClickGui;
import minimap.client.event.impl.TickEvent;
import minimap.client.module.Module;
import minimap.client.module.setting.impl.DescriptionSetting;
import minimap.client.module.setting.impl.TickSetting;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.EnumChatFormatting;
import org.lwjgl.input.Keyboard;

public class InvMove extends Module {

    private final DescriptionSetting ds;
    private final DescriptionSetting ds2;
    private final TickSetting undetectable;

    public InvMove() {
        super("InvMove", ModuleCategory.movement);
        registerSetting(ds = new DescriptionSetting("Does NOT work on Hypixel!"));
        registerSetting(undetectable = new TickSetting("Only ClickGui", true));
        registerSetting(ds2 = new DescriptionSetting(EnumChatFormatting.GRAY + "Only ClickGui is fully undetectable!"));
    }

    @Subscribe
    public void onTick(TickEvent e) {
        if (mc.currentScreen != null) {
            if (mc.currentScreen instanceof GuiChat) {
                return;
            }

            if (undetectable.isToggled() && !(mc.currentScreen instanceof ClickGui))
                return;

            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(),
                    Keyboard.isKeyDown(mc.gameSettings.keyBindForward.getKeyCode()));
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(),
                    Keyboard.isKeyDown(mc.gameSettings.keyBindBack.getKeyCode()));
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(),
                    Keyboard.isKeyDown(mc.gameSettings.keyBindRight.getKeyCode()));
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(),
                    Keyboard.isKeyDown(mc.gameSettings.keyBindLeft.getKeyCode()));
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(),
                    Keyboard.isKeyDown(mc.gameSettings.keyBindJump.getKeyCode()));
            EntityPlayerSP var1;
            if (Keyboard.isKeyDown(208) && mc.thePlayer.rotationPitch < 90.0F) {
                var1 = mc.thePlayer;
                var1.rotationPitch += 6.0F;
            }

            if (Keyboard.isKeyDown(200) && mc.thePlayer.rotationPitch > -90.0F) {
                var1 = mc.thePlayer;
                var1.rotationPitch -= 6.0F;
            }

            if (Keyboard.isKeyDown(205)) {
                var1 = mc.thePlayer;
                var1.rotationYaw += 6.0F;
            }

            if (Keyboard.isKeyDown(203)) {
                var1 = mc.thePlayer;
                var1.rotationYaw -= 6.0F;
            }
        }

    }
}
