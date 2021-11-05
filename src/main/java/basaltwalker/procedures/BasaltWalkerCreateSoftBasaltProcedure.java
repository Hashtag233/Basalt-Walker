package basaltwalker.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import java.util.Map;
import java.util.HashMap;

import basaltwalker.init.BasaltWalkerModEnchantments;
import basaltwalker.init.BasaltWalkerModBlocks;

import basaltwalker.BasaltWalkerMod;

@Mod.EventBusSubscriber
public class BasaltWalkerCreateSoftBasaltProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			Entity entity = event.player;
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", entity.getX());
			dependencies.put("y", entity.getY());
			dependencies.put("z", entity.getZ());
			dependencies.put("world", entity.level);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			execute(dependencies);
		}
	}

	public static void execute(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BasaltWalkerMod.LOGGER.warn("Failed to load dependency entity for procedure BasaltWalkerCreateSoftBasalt!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BasaltWalkerMod.LOGGER.warn("Failed to load dependency x for procedure BasaltWalkerCreateSoftBasalt!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BasaltWalkerMod.LOGGER.warn("Failed to load dependency y for procedure BasaltWalkerCreateSoftBasalt!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BasaltWalkerMod.LOGGER.warn("Failed to load dependency z for procedure BasaltWalkerCreateSoftBasalt!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BasaltWalkerMod.LOGGER.warn("Failed to load dependency world for procedure BasaltWalkerCreateSoftBasalt!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		LevelAccessor world = (LevelAccessor) dependencies.get("world");
		double sx = 0;
		double sz = 0;
		double radium = 0;
		if (EnchantmentHelper.getItemEnchantmentLevel(BasaltWalkerModEnchantments.BASALT_WALKER,
				(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY)) >= 1) {
			radium = (double) (EnchantmentHelper.getItemEnchantmentLevel(BasaltWalkerModEnchantments.BASALT_WALKER,
					(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY)) + 2);
			sx = (double) (0 - radium);
			for (int index0 = 0; index0 < (int) (radium * 2 + 1); index0++) {
				sz = (double) (0 - radium);
				for (int index1 = 0; index1 < (int) (radium * 2 + 1); index1++) {
					if (sx * sx + sz * sz <= radium * radium) {
						if (((world.getBlockState(new BlockPos((int) (x - 0.5 + sx), (int) (y - 1), (int) (z - 0.5 + sz)))).getBlock() == Blocks.LAVA
								&& (world.getBlockState(new BlockPos((int) (x - 0.5 + sx), (int) (y - 1), (int) (z - 0.5 + sz)))).getFluidState()
										.isSource()
								|| (world.getBlockState(new BlockPos((int) (x - 0.5 + sx), (int) (y - 1), (int) (z - 0.5 + sz))))
										.getBlock() == BasaltWalkerModBlocks.MELTING_SOFT_BASALT_3 && new Object() {
											public double getValue(LevelAccessor world, BlockPos pos, String tag) {
												BlockEntity blockEntity = world.getBlockEntity(pos);
												if (blockEntity != null)
													return blockEntity.getTileData().getDouble(tag);
												return -1;
											}
										}.getValue(world, new BlockPos((int) (x - 0.5 + sx), (int) (y - 1), (int) (z - 0.5 + sz)),
												"softBasaltMeltTime") >= 9)
								&& (world.getBlockState(new BlockPos((int) (x - 0.5 + sx), (int) y, (int) (z - 0.5 + sz))))
										.getBlock() == Blocks.AIR) {
							world.setBlock(new BlockPos((int) (x - 0.5 + sx), (int) (y - 1), (int) (z - 0.5 + sz)),
									BasaltWalkerModBlocks.SOFT_BASALT.defaultBlockState(), 3);
						}
					}
					sz = (double) (sz + 1);
				}
				sx = (double) (sx + 1);
			}
		}
	}
}
