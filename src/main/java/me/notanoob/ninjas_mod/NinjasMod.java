package me.notanoob.ninjas_mod;

import me.notanoob.ninjas_mod.Registies.CreativeTab;
import me.notanoob.ninjas_mod.Registies.EntityRegister;
import me.notanoob.ninjas_mod.Registies.ItemRegister;
import net.fabricmc.api.ModInitializer;

public class NinjasMod implements ModInitializer {
    @Override
    public void onInitialize() {
        ItemRegister.register();
        CreativeTab.register();
        EntityRegister.register();
    }
}
