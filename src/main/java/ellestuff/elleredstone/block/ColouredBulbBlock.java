package ellestuff.elleredstone.block;

import com.mojang.serialization.MapCodec;
import ellestuff.elleredstone.sound.ERSounds;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.OxidizableBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import static net.minecraft.util.StringIdentifiable.createCodec;

public class ColouredBulbBlock extends Block {
    public static final BooleanProperty POWERED = Properties.POWERED;
    public static final BooleanProperty LIT = Properties.LIT;

    public ColouredBulbBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)((BlockState)this.getDefaultState().with(LIT, false)).with(POWERED, false));
    }

    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        if (oldState.getBlock() != state.getBlock() && world instanceof ServerWorld serverWorld) {
            this.update(state, serverWorld, pos);
        }

    }

    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        if (world instanceof ServerWorld serverWorld) {
            this.update(state, serverWorld, pos);
        }

    }

    public void update(BlockState state, ServerWorld world, BlockPos pos) {
        boolean bl = world.isReceivingRedstonePower(pos);
        if (bl != (Boolean)state.get(POWERED)) {
            BlockState blockState = state;
            if (!(Boolean)state.get(POWERED)) {
                blockState = (BlockState)state.cycle(LIT);
                world.playSound((PlayerEntity)null, pos, (Boolean)blockState.get(LIT) ? ERSounds.BLOCK_COLOURED_BULB_TURN_ON : ERSounds.BLOCK_COLOURED_BULB_TURN_OFF, SoundCategory.BLOCKS);
            }

            world.setBlockState(pos, (BlockState)blockState.with(POWERED, bl), 3);
        }
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{LIT, POWERED});
    }

    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return (Boolean)world.getBlockState(pos).get(LIT) ? 15 : 0;
    }
}

