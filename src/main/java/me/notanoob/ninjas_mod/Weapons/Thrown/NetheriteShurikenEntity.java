package me.notanoob.ninjas_mod.Weapons.Thrown;

import me.notanoob.ninjas_mod.Registies.ItemRegister;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

import static me.notanoob.ninjas_mod.Registies.EntityRegister.NetheriteShurikenEntityType;

public class NetheriteShurikenEntity extends ThrownItemEntity {
    public NetheriteShurikenEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public NetheriteShurikenEntity(World world, LivingEntity owner) {
        super(NetheriteShurikenEntityType, owner, world);
    }

    public NetheriteShurikenEntity(World world, double x, double y, double z) {
        super(NetheriteShurikenEntityType, x, y, z, world);
    }

    @Override
    protected Item getDefaultItem() {
        return ItemRegister.NetheriteShuriken;
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
            entity.damage(
                    this.getWorld().getDamageSources().thrown(this, player),
                    (float) player.getAttributeValue(Registries.ATTRIBUTE.get(new Identifier("ranged_weapon:damage")))
            );
        }
    }
}