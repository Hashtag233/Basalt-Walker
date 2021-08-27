package basaltwalker.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.block.Blocks;

import java.util.Map;
import java.util.HashMap;

import basaltwalker.enchantment.BasaltWalkerEnchantment;

import basaltwalker.block.SoftBasaltBlock;

import basaltwalker.BasaltWalkerMod;

public class BasaltWalkerCreateSoftBasaltProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
			if (event.phase == TickEvent.Phase.END) {
				Entity entity = event.player;
				World world = entity.world;
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", i);
				dependencies.put("y", j);
				dependencies.put("z", k);
				dependencies.put("world", world);
				dependencies.put("entity", entity);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}
	}
	public static void executeProcedure(Map<String, Object> dependencies) {
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
		IWorld world = (IWorld) dependencies.get("world");
		double sx = 0;
		double sz = 0;
		double radium = 0;
		if (((EnchantmentHelper.getEnchantmentLevel(BasaltWalkerEnchantment.enchantment,
				((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 0))
						: ItemStack.EMPTY))) >= 1)) {
			radium = (double) ((EnchantmentHelper.getEnchantmentLevel(BasaltWalkerEnchantment.enchantment,
					((entity instanceof LivingEntity)
							? ((LivingEntity) entity)
									.getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 0))
							: ItemStack.EMPTY)))
					+ 2);
			sx = (double) (0 - radium);
			for (int index0 = 0; index0 < (int) (((radium * 2) + 1)); index0++) {
				sz = (double) (0 - radium);
				for (int index1 = 0; index1 < (int) (((radium * 2) + 1)); index1++) {
					if ((((sx * sx) + (sz * sz)) <= (radium * radium))) {
						if (((((world.getBlockState(new BlockPos((int) ((x - 0.5) + sx), (int) (y - 1), (int) ((z - 0.5) + sz))))
								.getBlock() == Blocks.LAVA)
								&& ((world.getBlockState(new BlockPos((int) ((x - 0.5) + sx), (int) (y - 1), (int) ((z - 0.5) + sz)))).getFluidState()
										.isSource()))
								&& ((world.getBlockState(new BlockPos((int) ((x - 0.5) + sx), (int) y, (int) ((z - 0.5) + sz))))
										.getBlock() == Blocks.AIR))) {
							world.setBlockState(new BlockPos((int) ((x - 0.5) + sx), (int) (y - 1), (int) ((z - 0.5) + sz)),
									SoftBasaltBlock.block.getDefaultState(), 3);
						}
					}
					sz = (double) (sz + 1);
				}
				sx = (double) (sx + 1);
			}
		}
	}
}
