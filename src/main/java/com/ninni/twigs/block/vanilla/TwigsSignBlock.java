package com.ninni.twigs.block.vanilla;

import com.ninni.twigs.init.TwigsBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class TwigsSignBlock extends StandingSignBlock {

    public TwigsSignBlock(Properties properties, WoodType type) {
        super(properties, type);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return TwigsBlockEntities.TWIGS_SIGN.get().create(pos, state);
    }

}
