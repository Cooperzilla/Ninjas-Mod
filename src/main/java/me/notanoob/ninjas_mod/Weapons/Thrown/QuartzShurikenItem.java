package me.notanoob.ninjas_mod.Weapons.Thrown;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.UUID;

public class QuartzShurikenItem extends Item {
    public QuartzShurikenItem() {
        super(new Settings().fireproof());
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        if (slot == EquipmentSlot.MAINHAND) {

            Multimap<EntityAttribute, EntityAttributeModifier> hash = ArrayListMultimap.create();

            hash.put(
                    Registries.ATTRIBUTE.get(new Identifier("ranged_weapon:damage")),
                    new EntityAttributeModifier(
                            UUID.fromString("ab6a0660-a01c-4e25-98f4-c2d1e8b40acf"),
                            "damage",
                            8,
                            EntityAttributeModifier.Operation.ADDITION
                    )
            );

            return hash;
        }
        return super.getAttributeModifiers(slot);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 1F);

        if (! world.isClient) {
            QuartzShurikenEntity quartzShuriken = new QuartzShurikenEntity(world, user);
            quartzShuriken.setItem(itemStack);
            quartzShuriken.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 0F);
            world.spawnEntity(quartzShuriken);
        }

        user.incrementStat(Stats.USED.getOrCreateStat(this));

        if (! user.getAbilities().creativeMode) {
            itemStack.decrement(1); // decrements itemStack if user is not in creative mode
        }

        user.getItemCooldownManager().set(this, (int) Math.floor((16 * 100) / user.getAttributeValue(Registries.ATTRIBUTE.get(new Identifier("ranged_weapon:haste")))));

        return TypedActionResult.success(itemStack, world.isClient());

    }
}
