package io.github.sjouwer.immortalcoral;

import net.fabricmc.api.ModInitializer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.BlockView;
import net.minecraft.world.GameRules;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.World;

import static io.github.sjouwer.immortalcoral.mixin.GameRulesAccessor.invokeRegister;
import static io.github.sjouwer.immortalcoral.mixin.BooleanRuleAccessor.invokeCreate;

public class ImmortalCoral implements ModInitializer {
    public static final GameRules.Key<GameRules.BooleanRule> ImmortalCoralRule = invokeRegister("immortalCoral", GameRules.Category.MISC, invokeCreate(false));

    @Override
    public void onInitialize() {
    }

    public static boolean isCoralImmortal(BlockView world) {
        if (world instanceof World) {
            return ((World)world).getGameRules().getBoolean(ImmortalCoral.ImmortalCoralRule);
        }
        else if (world instanceof StructureWorldAccess) {
            ServerWorld server = ((StructureWorldAccess)world).toServerWorld();
            return server != null && server.getGameRules().getBoolean(ImmortalCoral.ImmortalCoralRule);
        }

        return false;
    }
}
