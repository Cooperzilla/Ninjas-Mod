package me.notanoob.ninjas_mod.client.renderer.armor;

import me.notanoob.ninjas_mod.Armor.NinjaArmor;
import me.notanoob.ninjas_mod.client.Models.armor.NinjaArmorModel;
import mod.azure.azurelibarmor.renderer.GeoArmorRenderer;

public class NinjaArmorRenderer extends GeoArmorRenderer<NinjaArmor> {
    public NinjaArmorRenderer() {
        super(new NinjaArmorModel());
    }
}