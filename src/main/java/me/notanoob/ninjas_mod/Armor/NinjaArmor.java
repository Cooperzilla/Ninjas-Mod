package me.notanoob.ninjas_mod.Armor;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import me.notanoob.ninjas_mod.ArmorMaterials.NinjaArmorMaterial;
import me.notanoob.ninjas_mod.client.renderer.NinjaArmorRenderer;
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

public class NinjaArmor extends ArmorItem implements GeoItem {

    private final AnimatableInstanceCache cache = AzureLibUtil.createInstanceCache(this);
    private final Supplier<Object> renderProvider = GeoItem.makeRenderer(this);
    public NinjaArmor(Type type) {
        super(new NinjaArmorMaterial(), type, new Item.Settings());
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(ItemStack stack, EquipmentSlot slot) {
        if (!(stack.getItem() instanceof ArmorItem)) { return super.getAttributeModifiers(slot); }

        Multimap<EntityAttribute, EntityAttributeModifier> hash = HashMultimap.create();

        if (((ArmorItem) stack.getItem()).getSlotType() == EquipmentSlot.HEAD) {
            if (slot == EquipmentSlot.HEAD) {
                hash.put(
                        Registries.ATTRIBUTE.get(new Identifier("combatroll:count")),
                        new EntityAttributeModifier(
                                "rolls",
                                1,
                                EntityAttributeModifier.Operation.ADDITION
                        )
                );
                hash.put(
                        Registries.ATTRIBUTE.get(new Identifier("minecraft:generic.armor")),
                        new EntityAttributeModifier(
                                "armor",
                                2,
                                EntityAttributeModifier.Operation.ADDITION
                        )
                );
                return hash;
            }
        } else if (((ArmorItem) stack.getItem()).getSlotType() == EquipmentSlot.CHEST) {
            if (slot == EquipmentSlot.CHEST) {
                hash.put(
                        Registries.ATTRIBUTE.get(new Identifier("combatroll:recharge")),
                        new EntityAttributeModifier(
                                "recharge",
                                0.1,
                                EntityAttributeModifier.Operation.ADDITION
                        )
                );
                hash.put(
                        Registries.ATTRIBUTE.get(new Identifier("minecraft:generic.armor")),
                        new EntityAttributeModifier(
                                "armor",
                                3,
                                EntityAttributeModifier.Operation.ADDITION
                        )
                );
                return hash;
            }
        } else if (((ArmorItem) stack.getItem()).getSlotType() == EquipmentSlot.LEGS) {
            if (slot == EquipmentSlot.LEGS) {
                hash.put(
                        Registries.ATTRIBUTE.get(new Identifier("combatroll:recharge")),
                        new EntityAttributeModifier(
                                "recharge",
                                0.1,
                                EntityAttributeModifier.Operation.ADDITION
                        )
                );
                hash.put(
                        Registries.ATTRIBUTE.get(new Identifier("minecraft:generic.armor")),
                        new EntityAttributeModifier(
                                "armor",
                                3,
                                EntityAttributeModifier.Operation.ADDITION
                        )
                );
                return hash;
            }
        } else if (((ArmorItem) stack.getItem()).getSlotType() == EquipmentSlot.FEET) {
            if (slot == EquipmentSlot.FEET) {
                hash.put(
                        Registries.ATTRIBUTE.get(new Identifier("combatroll:distance")),
                        new EntityAttributeModifier(
                                "distance",
                                1,
                                EntityAttributeModifier.Operation.ADDITION
                        )
                );
                hash.put(
                        Registries.ATTRIBUTE.get(new Identifier("minecraft:generic.armor")),
                        new EntityAttributeModifier(
                                "armor",
                                2,
                                EntityAttributeModifier.Operation.ADDITION
                        )
                );
                return hash;
            }
        }

        return super.getAttributeModifiers(slot);
    }

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
                return this.renderer;
            }
        });
    }

    @Override
    public Supplier<Object> getRenderProvider() {
        return renderProvider;
    }
}
