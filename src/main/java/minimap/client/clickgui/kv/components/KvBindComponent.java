package minimap.client.clickgui.kv.components;

import org.lwjgl.input.Keyboard;

import minimap.client.clickgui.kv.KvComponent;
import minimap.client.main.Raven;
import minimap.client.module.Module;
import minimap.client.module.modules.client.GuiModule;
import net.minecraft.client.Minecraft;

public class KvBindComponent extends KvComponent {

	private Module mod;
	private boolean isBinding;

	public KvBindComponent(Module mod) {
		this.mod = mod;
	}

	@Override
	public void draw(int mouseX, int mouseY) {
		Minecraft.getMinecraft().fontRendererObj.drawString(
				isBinding ? "Press a key" : "Bind: " + mod.getBindAsString(),
				(float) (x + KvModuleSection.padding),
				(float) (((y + (height/2)) - (Raven.mc.fontRendererObj.FONT_HEIGHT/2))),
				0xFEFFFFFF,
				false);
	}

	@Override
	public void clicked(int button, int x, int y) {
		if(button == 0)
			isBinding = true;
	}

    @Override
    public void keyTyped(char t, int k) {
    	if (isBinding) {
    		if ((k == Keyboard.KEY_0) || (k == Keyboard.KEY_ESCAPE)) {
    			if (mod instanceof GuiModule)
					mod.setbind(54);
				else
					mod.setbind(0);
    		} else
				mod.setbind(k);

    		this.isBinding = false;
    	}
    }
}
