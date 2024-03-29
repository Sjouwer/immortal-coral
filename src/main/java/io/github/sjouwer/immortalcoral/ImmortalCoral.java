package io.github.sjouwer.immortalcoral;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.server.MinecraftServer;
import net.minecraft.text.MutableText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.world.BlockView;
import net.minecraft.world.ChunkRegion;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;

import java.util.HashMap;

import static io.github.sjouwer.immortalcoral.mixin.GameRulesAccessor.invokeRegister;
import static io.github.sjouwer.immortalcoral.mixin.BooleanRuleAccessor.invokeCreate;

public class ImmortalCoral implements ModInitializer {
    public static final GameRules.Key<GameRules.BooleanRule> ImmortalCoralRule = invokeRegister("immortalCoral", GameRules.Category.MISC, invokeCreate(false));
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

    public static boolean isCoralImmortal(BlockView world) {
        if (world instanceof World clientWorld) {
            return clientWorld.getGameRules().getBoolean(ImmortalCoral.ImmortalCoralRule);
        }
        else if (world.getClass() == ChunkRegion.class) {
            MinecraftServer server = ((ChunkRegion)world).getServer();
            return server != null && server.getGameRules().getBoolean(ImmortalCoral.ImmortalCoralRule);
        }

        return false;
    }

    public static MutableText getNewNameIfDeadCoral(ItemStack itemStack) {
        String id = Registries.ITEM.getId(itemStack.getItem()).toString();
        if (smokedNamesMap.containsKey(id)) {
            MutableText newName = Text.translatable(smokedNamesMap.get(id));
            newName.setStyle(Style.EMPTY.withItalic(false));
            return newName;
        }
        return null;
    }
}
