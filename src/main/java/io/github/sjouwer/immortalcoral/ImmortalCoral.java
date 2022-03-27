package io.github.sjouwer.immortalcoral;

import io.github.sjouwer.immortalcoral.mixin.BooleanRuleAccessor;
import net.fabricmc.api.ModInitializer;
import net.minecraft.world.GameRules;

import static io.github.sjouwer.immortalcoral.mixin.MixinGameRules.invokeRegister;

public class ImmortalCoral implements ModInitializer {
    public static GameRules.Key<GameRules.BooleanRule> isCoralImmortal;

    @Override
    public void onInitialize() {
        isCoralImmortal = invokeRegister("immortalCoral", GameRules.Category.MISC, BooleanRuleAccessor.invokeCreate(false));
    }
}
