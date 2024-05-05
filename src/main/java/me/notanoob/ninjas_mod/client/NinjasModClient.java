package me.notanoob.ninjas_mod.client;

import me.notanoob.ninjas_mod.client.renderer.RendererRegister;
import net.fabricmc.api.ClientModInitializer;

public class NinjasModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        RendererRegister.register();
    }
}
