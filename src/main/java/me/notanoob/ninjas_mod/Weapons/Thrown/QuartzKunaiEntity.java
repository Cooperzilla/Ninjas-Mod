package me.notanoob.ninjas_mod.Weapons.Thrown;

import me.notanoob.ninjas_mod.Registies.ItemRegister;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

import static me.notanoob.ninjas_mod.Registies.EntityRegister.QuartzKunaiEntityType;

public class QuartzKunaiEntity extends ThrownItemEntity {
    private float dmg;

    public QuartzKunaiEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public QuartzKunaiEntity(World world, LivingEntity owner, float dmg) {
        super(QuartzKunaiEntityType, owner, world);
        this.dmg = dmg;
    }

    @Override
    protected Item getDefaultItem() {
        return ItemRegister.QuartzKunai;
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
            entity.damage(this.getWorld().getDamageSources().thrown(this, player), dmg);
        }
    }
}