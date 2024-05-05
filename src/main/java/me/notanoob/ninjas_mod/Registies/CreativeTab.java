package me.notanoob.ninjas_mod.Registies;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static me.notanoob.ninjas_mod.Registies.ItemRegister.*;

public class CreativeTab {
    private static final ItemGroup ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(NinjaHelmet))
            .displayName(Text.translatable("itemGroup.ninjas.tab"))
            .entries((context, entries) -> {
                entries.add(NinjaHelmet);
                entries.add(NinjaChestplate);
                entries.add(NinjaLeggings);
                entries.add(NinjaBoots);
                entries.add(ShinobiHelmet);
                entries.add(ShinobiChestplate);
                entries.add(ShinobiLeggings);
                entries.add(ShinobiBoots);
                entries.add(IronKatana);
                entries.add(DiamondKatana);
                entries.add(NetheriteKatana);
                entries.add(IronSai);
                entries.add(DiamondSai);
                entries.add(NetheriteSai);
                entries.add(Shuriken);
                entries.add(NetheriteShuriken);
                entries.add(Kunai);
                entries.add(NetheriteKunai);
            })
            .build();
    public static void register() {
        Registry.register(Registries.ITEM_GROUP, new Identifier("ninjas", "tab"), ITEM_GROUP);
    }
}
