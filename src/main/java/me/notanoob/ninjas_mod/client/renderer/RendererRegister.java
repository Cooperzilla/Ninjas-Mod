package me.notanoob.ninjas_mod.client.renderer;

import me.notanoob.ninjas_mod.Registies.EntityRegister;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

public class RendererRegister {
    public static void register() {
        EntityRendererRegistry.register(EntityRegister.ShurikenEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(EntityRegister.QuartzShurikenEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(EntityRegister.KunaiEntityType, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(EntityRegister.QuartzKunaiEntityType, FlyingItemEntityRenderer::new);
    }
}
