package me.notanoob.ninjas_mod.Armor;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import me.notanoob.ninjas_mod.ArmorMaterials.ShinobiArmorMaterial;
import me.notanoob.ninjas_mod.client.renderer.armor.ShinobiArmorRenderer;
import mod.azure.azurelibarmor.animatable.GeoItem;
import mod.azure.azurelibarmor.animatable.client.RenderProvider;
import mod.azure.azurelibarmor.core.animatable.instance.AnimatableInstanceCache;
import mod.azure.azurelibarmor.core.animation.AnimatableManager;
import mod.azure.azurelibarmor.util.AzureLibUtil;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ShinobiArmor extends ArmorItem implements GeoItem {
    public ShinobiArmor(Type type) {
        super(new ShinobiArmorMaterial(), type, new Item.Settings());
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(ItemStack stack, EquipmentSlot slot) {
        Multimap<EntityAttribute, EntityAttributeModifier> hash = HashMultimap.create();

        hash.putAll(super.getAttributeModifiers(type.getEquipmentSlot()));

        switch (type) {
            case HELMET -> hash.put(
                    Registries.ATTRIBUTE.get(new Identifier("combatroll:count")),
                    new EntityAttributeModifier(
                            "rolls",
                            2,
                            EntityAttributeModifier.Operation.ADDITION
                    )
            );
            case CHESTPLATE -> hash.put(
                    Registries.ATTRIBUTE.get(new Identifier("combatroll:recharge")),
                    new EntityAttributeModifier(
                            "recharge",
                            1.1,
                            EntityAttributeModifier.Operation.MULTIPLY_TOTAL
                    )
            );
            case LEGGINGS -> hash.put(
                    Registries.ATTRIBUTE.get(new Identifier("combatroll:recharge")),
                    new EntityAttributeModifier(
                            "recharge",
                            0.2,
                            EntityAttributeModifier.Operation.ADDITION
                    )
            );
            case BOOTS -> hash.put(
                    Registries.ATTRIBUTE.get(new Identifier("combatroll:distance")),
                    new EntityAttributeModifier(
                            "distance",
                            2,
                            EntityAttributeModifier.Operation.ADDITION
                    )
            );
        }

        if (slot == type.getEquipmentSlot()) {
            return hash;
        }
        return super.getAttributeModifiers(slot);
    }

    private final AnimatableInstanceCache cache = AzureLibUtil.createInstanceCache(this);
    private final Supplier<Object> renderProvider = GeoItem.makeRenderer(this);

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {}

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public void createRenderer(Consumer<Object> consumer) {
        consumer.accept(new RenderProvider() {
            // Your render made above
            private ShinobiArmorRenderer renderer;

            @Override
            public @NotNull BipedEntityModel<LivingEntity> getHumanoidArmorModel(
                    LivingEntity livingEntity,
                    ItemStack itemStack,
                    EquipmentSlot equipmentSlot,
                    BipedEntityModel<LivingEntity> original
            ) {
                if (renderer == null) {
                    this.renderer = new ShinobiArmorRenderer();
                }
                this.renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);
                //noinspection unchecked
                return this.renderer;
            }
        });
    }

    @Override
    public Supplier<Object> getRenderProvider() {
        return renderProvider;
    }
}
