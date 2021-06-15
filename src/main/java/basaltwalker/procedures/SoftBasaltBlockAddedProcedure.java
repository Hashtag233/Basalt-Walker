package basaltwalker.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.block.BlockState;

import java.util.Map;

import basaltwalker.BasaltWalkerModElements;

import basaltwalker.BasaltWalkerMod;

@BasaltWalkerModElements.ModElement.Tag
public class SoftBasaltBlockAddedProcedure extends BasaltWalkerModElements.ModElement {
	public SoftBasaltBlockAddedProcedure(BasaltWalkerModElements instance) {
		super(instance, 11);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BasaltWalkerMod.LOGGER.warn("Failed to load dependency x for procedure SoftBasaltBlockAdded!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BasaltWalkerMod.LOGGER.warn("Failed to load dependency y for procedure SoftBasaltBlockAdded!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BasaltWalkerMod.LOGGER.warn("Failed to load dependency z for procedure SoftBasaltBlockAdded!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BasaltWalkerMod.LOGGER.warn("Failed to load dependency world for procedure SoftBasaltBlockAdded!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (!world.isRemote()) {
			BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
			TileEntity _tileEntity = world.getTileEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_tileEntity != null)
				_tileEntity.getTileData().putDouble("SoftBasaltMeltTime", 0);
			if (world instanceof World)
				((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
		}
	}
}
