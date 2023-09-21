package io.github.sjouwer.immortalcoral.mixin;

import io.github.sjouwer.immortalcoral.ImmortalCoral;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.book.CookingRecipeCategory;
import net.minecraft.text.MutableText;
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
    protected
    ItemStack result;

    @Inject(method = "<init>(Lnet/minecraft/recipe/RecipeType;Ljava/lang/String;Lnet/minecraft/recipe/book/CookingRecipeCategory;Lnet/minecraft/recipe/Ingredient;Lnet/minecraft/item/ItemStack;FI)V", at = @At("TAIL"))
    public void init(RecipeType<?> type, String group, CookingRecipeCategory category, Ingredient ingredient, ItemStack result, float experience, int cookingTime, CallbackInfo ci) {
        if (type == RecipeType.SMOKING){
            MutableText outputName = ImmortalCoral.getNewNameIfDeadCoral(result);
            if (outputName != null) {
                result.setCustomName(outputName);
                this.result = result;
            }
        }
    }
}