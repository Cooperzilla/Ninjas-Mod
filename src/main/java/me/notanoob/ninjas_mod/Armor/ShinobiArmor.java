package me.notanoob.ninjas_mod.Armor;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import me.notanoob.ninjas_mod.ArmorMaterials.ShinobiArmorMaterial;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public class ShinobiArmor extends ArmorItem {
    public ShinobiArmor(Type type) {
        super(new ShinobiArmorMaterial(), type, new Item.Settings());
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
                                2,
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
                                1.1,
                                EntityAttributeModifier.Operation.MULTIPLY_TOTAL
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
                                0.2,
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
                                2,
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
}
