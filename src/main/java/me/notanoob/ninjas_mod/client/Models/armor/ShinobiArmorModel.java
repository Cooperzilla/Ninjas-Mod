package me.notanoob.ninjas_mod.client.Models.armor;

import me.notanoob.ninjas_mod.Armor.ShinobiArmor;
import mod.azure.azurelibarmor.model.GeoModel;
import net.minecraft.util.Identifier;

public class ShinobiArmorModel extends GeoModel<ShinobiArmor> {
    @Override
    public Identifier getModelResource(ShinobiArmor ninjaArmor) {
        return new Identifier("ninjas", "geo/ninja_armor.geo.json");
    }

    @Override
    public Identifier getTextureResource(ShinobiArmor ninjaArmor) {
        return new Identifier("ninjas", "textures/armor/shinobi_armor.png");
    }

    @Override
    public Identifier getAnimationResource(ShinobiArmor ninjaArmor) {
        return null;
    }
}
