package com.ninni.twigs.block;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RedstoneTorchBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;


public class LampBlock extends Block {
    public static final BooleanProperty LIT = RedstoneTorchBlock.LIT;

    public LampBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(LIT, true));
    }

    @SuppressWarnings("deprecation")
    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        final boolean wasLit = state.getValue(LIT);

        world.setBlockAndUpdate(pos, state.setValue(LIT, !wasLit));
        playSound(player, !wasLit);

        return InteractionResult.SUCCESS;
    }

    private void playSound(Player player, boolean isLit) {
        if (!player.level.isClientSide()) {
            player.playNotifySound(
                    isLit ? SoundEvents.FLINTANDSTEEL_USE : SoundEvents.STONE_BUTTON_CLICK_OFF,
                    SoundSource.BLOCKS,
                    0.3f,
                    isLit ? 0.6f : 0.5f
            );
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(LIT);
    }
}
