package me.notanoob.ninjas_mod.client.Models;

import me.notanoob.ninjas_mod.Armor.NinjaArmor;
import mod.azure.azurelibarmor.model.GeoModel;
import net.minecraft.util.Identifier;

public class NinjaArmorModel extends GeoModel<NinjaArmor> {
    @Override
    public Identifier getModelResource(NinjaArmor ninjaArmor) {
        return new Identifier("ninjas", "geo/ninja_armor.geo.json");
    }

    @Override
    public Identifier getTextureResource(NinjaArmor ninjaArmor) {
        return new Identifier("ninjas", "textures/armor/ninja_armor.png");
    }

    @Override
    public Identifier getAnimationResource(NinjaArmor ninjaArmor) {
        return null;
    }
}
