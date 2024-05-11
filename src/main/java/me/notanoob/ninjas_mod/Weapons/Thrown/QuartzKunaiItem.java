package me.notanoob.ninjas_mod.Weapons.Thrown;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
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
import java.util.UUID;

public class QuartzKunaiItem extends SwordItem {
    public QuartzKunaiItem() {
        super(ToolMaterials.DIAMOND, 1, -2f, new Settings());
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 1F);

        if (! world.isClient) {
            EntityAttributeInstance attr = user.getAttributeInstance(Registries.ATTRIBUTE.get(new Identifier("ranged_weapon:damage")));

            assert attr != null;
            EntityAttributeModifier modifier;

            attr.addTemporaryModifier(
                    modifier = new EntityAttributeModifier(
                            UUID.fromString("ab6a0660-a01c-4e25-98f4-c2d1e8b40acf"),
                            "damage",
                            7,
                            EntityAttributeModifier.Operation.ADDITION
                    )
            );

            QuartzKunaiEntity entity = new QuartzKunaiEntity(world, user, (float) attr.getValue());
            entity.setItem(itemStack);
            entity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 2.5F, 0F);
            world.spawnEntity(entity);

            attr.removeModifier(modifier);
        }

        user.incrementStat(Stats.USED.getOrCreateStat(this));

        if (! user.getAbilities().creativeMode) {
            itemStack.damage(1, user, (p) -> p.sendToolBreakStatus(hand));
        }

        user.getItemCooldownManager().set(this, (int) Math.floor((16 * 100) / user.getAttributeValue(Registries.ATTRIBUTE.get(new Identifier("ranged_weapon:haste")))));

        return TypedActionResult.success(itemStack, world.isClient());

    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        tooltip.add(Text.translatable("item.ninjas.quartz_kunai.tooltip").formatted(Formatting.DARK_GREEN));
    }
}
