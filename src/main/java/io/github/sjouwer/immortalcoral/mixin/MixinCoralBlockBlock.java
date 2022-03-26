package io.github.sjouwer.immortalcoral.mixin;

import net.minecraft.block.CoralBlockBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CoralBlockBlock.class)
public class MixinCoralBlockBlock {
    private static final GameRules.RuleKey<GameRules.BooleanRule> isCoralImmortal = new GameRules.RuleKey<>("immortalCoral");

    @Inject(method = "isInWater", at = @At("HEAD"), cancellable = true)
    private void isInWater(BlockView world, BlockPos pos, CallbackInfoReturnable<Boolean> info) {
        if (((World)world).getGameRules().getBoolean(isCoralImmortal)) {
            info.setReturnValue(true);
        }
    }
}
