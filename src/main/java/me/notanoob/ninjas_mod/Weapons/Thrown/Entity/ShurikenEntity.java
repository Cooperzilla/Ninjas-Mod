package me.notanoob.ninjas_mod.Weapons.Thrown.Entity;

import me.notanoob.ninjas_mod.Registies.ItemRegister;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

import java.util.UUID;

import static me.notanoob.ninjas_mod.Registies.EntityRegister.QuartzShurikenEntityType;

public class ShurikenEntity extends ThrownItemEntity {

    public ShurikenEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public ShurikenEntity(World world, LivingEntity owner) {
        super(QuartzShurikenEntityType, owner, world);
    }

    @Override
    protected Item getDefaultItem() {
        return ItemRegister.QuartzShuriken;
    }

    @Override
    protected void onBlockCollision(BlockState state) {
        super.onBlockCollision(state);
        if (!(this.getWorld().isClient) && !(state.isReplaceable())) {
            this.kill();
        }
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        if (entityHitResult.getEntity() instanceof LivingEntity entity && this.getOwner() instanceof PlayerEntity player) {
            EntityAttributeInstance attr = player.getAttributeInstance(Registries.ATTRIBUTE.get(new Identifier("extra_classes:thrown_damage")));

            assert attr != null;
            EntityAttributeModifier modifier;

            attr.addTemporaryModifier(
                    modifier = new EntityAttributeModifier(
                            UUID.fromString("bb6a0660-a01c-4e25-98f4-c2d1e8b40acf"),
                            "damage",
                            5,
                            EntityAttributeModifier.Operation.ADDITION
                    )
            );

            entity.damage(this.getWorld().getDamageSources().thrown(this, player), (float) attr.getValue());
            attr.removeModifier(modifier);
        }
    }
}