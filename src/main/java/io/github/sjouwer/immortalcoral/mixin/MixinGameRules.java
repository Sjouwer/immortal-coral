package io.github.sjouwer.immortalcoral.mixin;

import net.minecraft.world.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(GameRules.class)
public class MixinGameRules {
    @Shadow
    private static <T extends GameRules.Rule<T>> GameRules.RuleKey<T> register(String key, GameRules.RuleType<T> type) {
        throw new AssertionError();
    }

    static{
        register("immortalCoral", BooleanRuleAccessor.invokeCreate(false));
    }
}
