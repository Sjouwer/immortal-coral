package io.github.sjouwer.immortalcoral.mixin;

import net.minecraft.world.GameRules.RuleType;
import net.minecraft.world.GameRules.BooleanRule;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(BooleanRule.class)
public interface BooleanRuleAccessor {
    @Invoker
    static RuleType<BooleanRule> invokeCreate(boolean defaultValue) {
        throw new AssertionError();
    }
}
