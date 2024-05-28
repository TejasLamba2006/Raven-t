package minimap.client.module.setting.impl;

import com.google.gson.JsonObject;

import minimap.client.clickgui.kv.KvComponent;
import minimap.client.clickgui.kv.components.KvTickComponent;
import minimap.client.clickgui.raven.Component;
import minimap.client.clickgui.raven.components.ButtonComponent;
import minimap.client.clickgui.raven.components.ModuleComponent;
import minimap.client.clickgui.raven.components.SettingComponent;
import minimap.client.module.setting.Setting;

public class ButtonSetting extends Setting {

    private final String name;

    public ButtonSetting(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void resetToDefaults() {

    }

    @Override
    public JsonObject getConfigAsJson() {
        JsonObject data = new JsonObject();
        data.addProperty("type", getSettingType());
        return data;
    }

    @Override
    public String getSettingType() {
        return "button";
    }

    @Override
    public void applyConfigFromJson(JsonObject data) {

    }

    @Override
    public Component createComponent(ModuleComponent moduleComponent) {
        return null;
    }

    @Override
    public Class<? extends SettingComponent> getRavenComponentType() {
        return ButtonComponent.class;
    }


    @Override
    public Class<? extends KvComponent> getComponentType() {
        return KvTickComponent.class;
    }

}
