package io.github.sjouwer.immortalcoral.mixin;

import io.github.sjouwer.immortalcoral.ImmortalCoral;
import net.minecraft.block.BlockState;
import net.minecraft.block.CoralParentBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CoralParentBlock.class)
public class MixinCoralParentBlock {
    @Inject(method = "isInWater", at = @At("HEAD"), cancellable = true)
    private static void isInWater(BlockState state, BlockView world, BlockPos pos, CallbackInfoReturnable<Boolean> info) {
        if (((World)world).getGameRules().getBoolean(ImmortalCoral.isCoralImmortal)) {
            info.setReturnValue(true);
        }
    }
}
