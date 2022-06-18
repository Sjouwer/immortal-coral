package io.github.sjouwer.immortalcoral;

import net.fabricmc.api.ModInitializer;
import net.minecraft.world.GameRules;

import static io.github.sjouwer.immortalcoral.mixin.GameRulesAccessor.invokeRegister;
import static io.github.sjouwer.immortalcoral.mixin.BooleanRuleAccessor.invokeCreate;

public class ImmortalCoral implements ModInitializer {
    public static final GameRules.Key<GameRules.BooleanRule> isCoralImmortal = invokeRegister("immortalCoral", GameRules.Category.MISC, invokeCreate(false));

    @Override
    public void onInitialize() {
    }
}
