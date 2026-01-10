package io.github.sjouwer.immortalcoral;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleBuilder;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.world.BlockView;
import net.minecraft.world.rule.GameRule;
import net.minecraft.world.rule.GameRuleCategory;

public class ImmortalCoral implements ModInitializer {
    private static final Identifier GAMERULE_IDENTIFIER = Identifier.of("immortalcoral","immortal_coral");
    public  static final GameRule<Boolean> IMMORTAL_CORAL_GAMERULE = GameRuleBuilder
            .forBoolean(false)
            .category(GameRuleCategory.MISC)
            .buildAndRegister(GAMERULE_IDENTIFIER);

    @Override
    public void onInitialize() {
    }

    public static boolean isCoralImmortal(BlockView blockView) {
        if (blockView instanceof ServerWorld serverWorld) {
            return serverWorld.getGameRules().getValue(ImmortalCoral.IMMORTAL_CORAL_GAMERULE);
        }

        return false;
    }
}
