package me.notanoob.ninjas_mod.Armor;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import me.notanoob.ninjas_mod.ArmorMaterials.NinjaArmorMaterial;
import me.notanoob.ninjas_mod.client.renderer.armor.NinjaArmorRenderer;
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

import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class NinjaArmor extends ArmorItem implements GeoItem {


    public NinjaArmor(Type type) {
        super(new NinjaArmorMaterial(), type, new Item.Settings());
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        Multimap<EntityAttribute, EntityAttributeModifier> hash = ArrayListMultimap.create();

        hash.putAll(super.getAttributeModifiers(type.getEquipmentSlot()));

        switch (type) {
            case HELMET -> hash.put(
                    Registries.ATTRIBUTE.get(new Identifier("combatroll:count")),
                    new EntityAttributeModifier(
                            UUID.fromString("ca60d7d3-6006-4cd9-9d93-eebdc3e1781a"),
                            "rolls",
                            1,
                            EntityAttributeModifier.Operation.ADDITION
                    )
            );
            case CHESTPLATE -> hash.put(
                    Registries.ATTRIBUTE.get(new Identifier("combatroll:recharge")),
                    new EntityAttributeModifier(
                            UUID.fromString("6d8278df-996a-4fe2-b7fb-f1549d02de5a"),
                            "recharge",
                            2,
                            EntityAttributeModifier.Operation.ADDITION
                    )
            );
            case LEGGINGS -> hash.put(
                    Registries.ATTRIBUTE.get(new Identifier("combatroll:recharge")),
                    new EntityAttributeModifier(
                            UUID.fromString("b591bb43-7f41-4410-a09e-5d40c9154379"),
                            "recharge",
                            2,
                            EntityAttributeModifier.Operation.ADDITION
                    )
            );
            case BOOTS -> hash.put(
                    Registries.ATTRIBUTE.get(new Identifier("combatroll:distance")),
                    new EntityAttributeModifier(
                            UUID.fromString("5223c44f-8e60-48a6-995a-f2fc5c5d1aa9"),
                            "distance",
                            1,
                            EntityAttributeModifier.Operation.ADDITION
                                        )
            );

        }

        if (slot == type.getEquipmentSlot()) {
            return hash;
        }
        return super.getAttributeModifiers(slot);
    }

    // custom model

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
            private NinjaArmorRenderer renderer;

            @Override
            public @NotNull BipedEntityModel<LivingEntity> getHumanoidArmorModel(
                    LivingEntity livingEntity,
                    ItemStack itemStack,
                    EquipmentSlot equipmentSlot,
                    BipedEntityModel<LivingEntity> original
            ) {
                if (renderer == null) {
                    this.renderer = new NinjaArmorRenderer();
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
