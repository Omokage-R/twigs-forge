package net.moddingplayground.twigs.block;

import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

@SuppressWarnings("deprecation")
public class AmethystWallBlock extends WallBlock {

    public AmethystWallBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void onProjectileHit(Level world, BlockState state, BlockHitResult hit, Projectile projectile) {
        Blocks.AMETHYST_BLOCK.onProjectileHit(world, state, hit, projectile);
    }
}
