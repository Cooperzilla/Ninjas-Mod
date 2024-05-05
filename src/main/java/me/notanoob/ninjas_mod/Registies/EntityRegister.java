package me.notanoob.ninjas_mod.Registies;

import me.notanoob.ninjas_mod.Weapons.Thrown.KunaiEntity;
import me.notanoob.ninjas_mod.Weapons.Thrown.QuartzKunaiEntity;
import me.notanoob.ninjas_mod.Weapons.Thrown.QuartzShurikenEntity;
import me.notanoob.ninjas_mod.Weapons.Thrown.ShurikenEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class EntityRegister {
    public static EntityType<ShurikenEntity> ShurikenEntityType;
    public static EntityType<QuartzShurikenEntity> QuartzShurikenEntityType;
    public static EntityType<KunaiEntity> KunaiEntityType;
    public static EntityType<QuartzKunaiEntity> QuartzKunaiEntityType;
    public static void register() {
        ShurikenEntityType = Registry.register(
                Registries.ENTITY_TYPE,
                new Identifier("ninjas", "shuriken"),
                FabricEntityTypeBuilder.<ShurikenEntity>create(SpawnGroup.MISC, ShurikenEntity::new)
                        .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                        .trackRangeBlocks(4).trackedUpdateRate(10)
                        .build()
        );
        QuartzShurikenEntityType = Registry.register(
                Registries.ENTITY_TYPE,
                new Identifier("ninjas", "quartz_shuriken"),
                FabricEntityTypeBuilder.<QuartzShurikenEntity>create(SpawnGroup.MISC, QuartzShurikenEntity::new)
                        .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                        .trackRangeBlocks(4).trackedUpdateRate(10)
                        .build()
        );
        KunaiEntityType = Registry.register(
                Registries.ENTITY_TYPE,
                new Identifier("ninjas", "kunai"),
                FabricEntityTypeBuilder.<KunaiEntity>create(SpawnGroup.MISC, KunaiEntity::new)
                        .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                        .trackRangeBlocks(4).trackedUpdateRate(10)
                        .build()
        );
        QuartzKunaiEntityType = Registry.register(
                Registries.ENTITY_TYPE,
                new Identifier("ninjas", "quartz_kunai"),
                FabricEntityTypeBuilder.<QuartzKunaiEntity>create(SpawnGroup.MISC, QuartzKunaiEntity::new)
                        .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                        .trackRangeBlocks(4).trackedUpdateRate(10)
                        .build()
        );
    }
}
