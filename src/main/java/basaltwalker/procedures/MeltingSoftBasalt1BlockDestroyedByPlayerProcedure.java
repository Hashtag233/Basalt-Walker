package basaltwalker.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.block.Blocks;

import java.util.Map;

import basaltwalker.BasaltWalkerModElements;

import basaltwalker.BasaltWalkerMod;

@BasaltWalkerModElements.ModElement.Tag
public class MeltingSoftBasalt1BlockDestroyedByPlayerProcedure extends BasaltWalkerModElements.ModElement {
	public MeltingSoftBasalt1BlockDestroyedByPlayerProcedure(BasaltWalkerModElements instance) {
		super(instance, 16);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BasaltWalkerMod.LOGGER.warn("Failed to load dependency entity for procedure MeltingSoftBasalt1BlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BasaltWalkerMod.LOGGER.warn("Failed to load dependency x for procedure MeltingSoftBasalt1BlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BasaltWalkerMod.LOGGER.warn("Failed to load dependency y for procedure MeltingSoftBasalt1BlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BasaltWalkerMod.LOGGER.warn("Failed to load dependency z for procedure MeltingSoftBasalt1BlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BasaltWalkerMod.LOGGER.warn("Failed to load dependency world for procedure MeltingSoftBasalt1BlockDestroyedByPlayer!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
		if ((!((EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH,
				((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)) != 0)))) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.LAVA.getDefaultState(), 3);
		}
	}
}
