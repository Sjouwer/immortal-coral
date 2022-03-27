package io.github.sjouwer.immortalcoral;

import net.fabricmc.api.ModInitializer;
import net.minecraft.world.GameRules;

import static io.github.sjouwer.immortalcoral.mixin.GameRulesAccessor.invokeRegister;
import static io.github.sjouwer.immortalcoral.mixin.BooleanRuleAccessor.invokeCreate;

public class ImmortalCoral implements ModInitializer {
    public static GameRules.Key<GameRules.BooleanRule> isCoralImmortal;

    @Override
    public void onInitialize() {
        isCoralImmortal = invokeRegister("immortalCoral", GameRules.Category.MISC, invokeCreate(false));
    }
}
