package me.notanoob.ninjas_mod.client.renderer;

import me.notanoob.ninjas_mod.Armor.NinjaArmor;
import me.notanoob.ninjas_mod.client.Models.ShinobiArmorModel;
import mod.azure.azurelibarmor.renderer.GeoArmorRenderer;

public class ShinobiArmorRenderer extends GeoArmorRenderer<NinjaArmor> {
    public ShinobiArmorRenderer() {
        super(new ShinobiArmorModel());
    }
}