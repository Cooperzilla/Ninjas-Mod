package me.notanoob.ninjas_mod.Weapons.Thrown.Item;

import me.notanoob.ninjas_mod.Weapons.Thrown.Entity.ShurikenEntity;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ShurikenItem extends Item {
    public ShurikenItem() {
        super(new Settings().maxDamage(250));
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 1F);

        if (! world.isClient) {
            ShurikenEntity entity = new ShurikenEntity(world, user);
            entity.setItem(itemStack);
            entity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 0F);
            world.spawnEntity(entity);
        }

        user.incrementStat(Stats.USED.getOrCreateStat(this));

        if (! user.getAbilities().creativeMode) {
            itemStack.damage(1, user, (p) -> p.sendToolBreakStatus(hand));
        }

        user.getItemCooldownManager().set(this, (int) Math.floor((14 * 100) / user.getAttributeValue(Registries.ATTRIBUTE.get(new Identifier("ranged_weapon:haste")))));

        return TypedActionResult.success(itemStack, world.isClient());

    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        tooltip.add(Text.translatable("item.ninjas.shuiken.tooltip").formatted(Formatting.DARK_GREEN));
    }
}
