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

import static me.notanoob.ninjas_mod.Registies.EntityRegister.NetheriteKunaiEntityType;
import static me.notanoob.ninjas_mod.Registies.EntityRegister.NetheriteShurikenEntityType;

public class NetheriteKunaiEntity extends ThrownItemEntity {
    public NetheriteKunaiEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public NetheriteKunaiEntity(World world, LivingEntity owner) {
        super(NetheriteKunaiEntityType, owner, world);
    }

    public NetheriteKunaiEntity(World world, double x, double y, double z) {
        super(NetheriteKunaiEntityType, x, y, z, world);
    }

    @Override
    protected Item getDefaultItem() {
        return ItemRegister.NetheriteKunai;
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