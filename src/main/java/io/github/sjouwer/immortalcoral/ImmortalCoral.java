package io.github.sjouwer.immortalcoral;

import net.fabricmc.api.ModInitializer;
import net.minecraft.world.BlockView;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.GameRules;

public class ImmortalCoral implements ModInitializer {
    public static final GameRules.RuleKey<GameRules.BooleanRule> ImmortalCoralRule = new GameRules.RuleKey<>("immortalCoral");

    public void onInitialize() {
    }

    public static boolean isCoralImmortal(BlockView world) {
        if (world instanceof World) {
            return ((World)world).getGameRules().getBoolean(ImmortalCoral.ImmortalCoralRule);
        }
        else if (world instanceof IWorld) {
            return ((IWorld)world).getWorld().getGameRules().getBoolean(ImmortalCoral.ImmortalCoralRule);
        }

        return false;
    }
}
