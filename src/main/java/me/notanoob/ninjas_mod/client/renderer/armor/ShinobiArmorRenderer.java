package me.notanoob.ninjas_mod.client.renderer.armor;

import me.notanoob.ninjas_mod.Armor.ShinobiArmor;
import me.notanoob.ninjas_mod.client.Models.armor.ShinobiArmorModel;
import mod.azure.azurelibarmor.renderer.GeoArmorRenderer;

public class ShinobiArmorRenderer extends GeoArmorRenderer<ShinobiArmor> {
    public ShinobiArmorRenderer() {
        super(new ShinobiArmorModel());
    }
}