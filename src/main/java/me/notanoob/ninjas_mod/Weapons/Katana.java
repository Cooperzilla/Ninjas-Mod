package me.notanoob.ninjas_mod.Weapons;

import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class Katana extends SwordItem {

    public Katana(ToolMaterial toolMaterial) {
        super(toolMaterial, 4, -2.8f, new Item.Settings());
    }
}
