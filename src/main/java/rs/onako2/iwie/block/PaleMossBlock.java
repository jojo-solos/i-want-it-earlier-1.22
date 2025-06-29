package rs.onako2.iwie.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockState;
import net.minecraft.block.MossBlock;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import rs.onako2.iwie.Init;

public class PaleMossBlock extends MossBlock {
    public static final MapCodec<MossBlock> CODEC = createCodec(PaleMossBlock::new);
    
    @Override
    public MapCodec<MossBlock> getCodec() {
        return CODEC;
    }
    
    public PaleMossBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        world.getRegistryManager().getOptional(RegistryKeys.CONFIGURED_FEATURE).flatMap((key) -> key.getEntry(Init.PALE_MOSS_PATCH_BONEMEAL_FEATURE_ID)).ifPresent((entry) -> entry.value().generate(world, world.getChunkManager().getChunkGenerator(), random, pos.up()));
    }
}
