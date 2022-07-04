package io.github.sjouwer.immortalcoral;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Style;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.GameRules;

import java.util.HashMap;

import static io.github.sjouwer.immortalcoral.mixin.GameRulesAccessor.invokeRegister;
import static io.github.sjouwer.immortalcoral.mixin.BooleanRuleAccessor.invokeCreate;

public class ImmortalCoral implements ModInitializer {
    public static final GameRules.Key<GameRules.BooleanRule> isCoralImmortal = invokeRegister("immortalCoral", GameRules.Category.MISC, invokeCreate(false));
    private static final HashMap<String, String> smokedNamesMap = new HashMap<>();

    @Override
    public void onInitialize() {
        smokedNamesMap.put("minecraft:dead_tube_coral", "minecraft:smoked_tube_coral");
        smokedNamesMap.put("minecraft:dead_tube_coral_block", "minecraft:smoked_tube_coral_block");
        smokedNamesMap.put("minecraft:dead_tube_coral_fan", "minecraft:smoked_tube_coral_fan");
        smokedNamesMap.put("minecraft:dead_brain_coral", "minecraft:smoked_brain_coral");
        smokedNamesMap.put("minecraft:dead_brain_coral_block", "minecraft:smoked_brain_coral_block");
        smokedNamesMap.put("minecraft:dead_brain_coral_fan", "minecraft:smoked_brain_coral_fan");
        smokedNamesMap.put("minecraft:dead_bubble_coral", "minecraft:smoked_bubble_coral");
        smokedNamesMap.put("minecraft:dead_bubble_coral_block", "minecraft:smoked_bubble_coral_block");
        smokedNamesMap.put("minecraft:dead_bubble_coral_fan", "minecraft:smoked_bubble_coral_fan");
        smokedNamesMap.put("minecraft:dead_fire_coral", "minecraft:smoked_fire_coral");
        smokedNamesMap.put("minecraft:dead_fire_coral_block", "minecraft:smoked_fire_coral_block");
        smokedNamesMap.put("minecraft:dead_fire_coral_fan", "minecraft:smoked_fire_coral_fan");
        smokedNamesMap.put("minecraft:dead_horn_coral", "minecraft:smoked_horn_coral");
        smokedNamesMap.put("minecraft:dead_horn_coral_block", "minecraft:smoked_horn_coral_block");
        smokedNamesMap.put("minecraft:dead_horn_coral_fan", "minecraft:smoked_horn_coral_fan");
    }

    public static TranslatableText getNewNameIfDeadCoral(ItemStack itemStack) {
        String id = Registry.ITEM.getId(itemStack.getItem()).toString();
        if (smokedNamesMap.containsKey(id)) {
            TranslatableText newName = new TranslatableText(smokedNamesMap.get(id));
            newName.setStyle(Style.EMPTY.withItalic(false));
            return newName;
        }
        return null;
    }
}
