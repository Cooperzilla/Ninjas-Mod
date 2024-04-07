package me.notanoob.ninjas_mod.Registies;

import me.notanoob.ninjas_mod.Armor.NinjaArmor;
import me.notanoob.ninjas_mod.Armor.ShinobiArmor;
import me.notanoob.ninjas_mod.Weapons.Katana;
import me.notanoob.ninjas_mod.Weapons.Sai;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ItemRegister {

    public static Item NinjaHelmet = new NinjaArmor(ArmorItem.Type.HELMET);
    public static Item NinjaChestplate = new NinjaArmor(ArmorItem.Type.CHESTPLATE);
    public static Item NinjaLeggings = new NinjaArmor(ArmorItem.Type.LEGGINGS);
    public static Item NinjaBoots = new NinjaArmor(ArmorItem.Type.BOOTS);
    public static Item ShinobiHelmet = new ShinobiArmor(ArmorItem.Type.HELMET);
    public static Item ShinobiChestplate = new ShinobiArmor(ArmorItem.Type.CHESTPLATE);
    public static Item ShinobiLeggings = new ShinobiArmor(ArmorItem.Type.LEGGINGS);
    public static Item ShinobiBoots = new ShinobiArmor(ArmorItem.Type.BOOTS);
    public static Item IronKatana = new Katana(ToolMaterials.IRON);
    public static Item DiamondKatana = new Katana(ToolMaterials.DIAMOND);
    public static Item NetheriteKatana = new Katana(ToolMaterials.NETHERITE);
    public static Item IronSai = new Sai(ToolMaterials.IRON);
    public static Item DiamondSai = new Sai(ToolMaterials.DIAMOND);
    public static Item NetheriteSai = new Sai(ToolMaterials.NETHERITE);
    public static void register() {
        Registry.register(Registries.ITEM, new Identifier("ninjas", "ninja_helmet"), NinjaHelmet);
        Registry.register(Registries.ITEM, new Identifier("ninjas", "ninja_chestplate"), NinjaChestplate);
        Registry.register(Registries.ITEM, new Identifier("ninjas", "ninja_leggings"), NinjaLeggings);
        Registry.register(Registries.ITEM, new Identifier("ninjas", "ninja_boots"), NinjaBoots);
        Registry.register(Registries.ITEM, new Identifier("ninjas", "shinobi_helmet"), ShinobiHelmet);
        Registry.register(Registries.ITEM, new Identifier("ninjas", "shinobi_chestplate"), ShinobiChestplate);
        Registry.register(Registries.ITEM, new Identifier("ninjas", "shinobi_leggings"), ShinobiLeggings);
        Registry.register(Registries.ITEM, new Identifier("ninjas", "shinobi_boots"), ShinobiBoots);
        Registry.register(Registries.ITEM, new Identifier("ninjas", "iron_katana"), IronKatana);
        Registry.register(Registries.ITEM, new Identifier("ninjas", "diamond_katana"), DiamondKatana);
        Registry.register(Registries.ITEM, new Identifier("ninjas", "netherite_katana"), NetheriteKatana);
        Registry.register(Registries.ITEM, new Identifier("ninjas", "iron_sai"), IronSai);
        Registry.register(Registries.ITEM, new Identifier("ninjas", "diamond_sai"), DiamondSai);
        Registry.register(Registries.ITEM, new Identifier("ninjas", "netherite_sai"), NetheriteSai);
    }
}
