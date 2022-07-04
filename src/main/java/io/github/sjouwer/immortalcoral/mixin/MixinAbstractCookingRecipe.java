package io.github.sjouwer.immortalcoral.mixin;

import io.github.sjouwer.immortalcoral.ImmortalCoral;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeType;
import net.minecraft.text.MutableText;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractCookingRecipe.class)
public class MixinAbstractCookingRecipe {
    @Shadow @Mutable @Final
    ItemStack output;

    @Inject(method = "<init>(Lnet/minecraft/recipe/RecipeType;Lnet/minecraft/util/Identifier;Ljava/lang/String;Lnet/minecraft/recipe/Ingredient;Lnet/minecraft/item/ItemStack;FI)V", at = @At("TAIL"))
    public void init(RecipeType<?> type, Identifier id, String group, Ingredient input, ItemStack output, float experience, int cookTime, CallbackInfo info) {
        if (type == RecipeType.SMOKING){
            MutableText outputName = ImmortalCoral.getNewNameIfDeadCoral(output);
            if (outputName != null) {
                output.setCustomName(outputName);
                this.output = output;
            }
        }
    }
}