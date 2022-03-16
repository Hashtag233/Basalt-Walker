package basaltwalker.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
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

import javax.annotation.Nullable;

import basaltwalker.init.BasaltWalkerModEnchantments;
import basaltwalker.init.BasaltWalkerModBlocks;

@Mod.EventBusSubscriber
public class BasaltWalkerCreateSoftBasaltProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level, event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double sx = 0;
		double sz = 0;
		double radium = 0;
		if (EnchantmentHelper.getItemEnchantmentLevel(BasaltWalkerModEnchantments.BASALT_WALKER.get(),
				(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY)) >= 1) {
			radium = EnchantmentHelper.getItemEnchantmentLevel(BasaltWalkerModEnchantments.BASALT_WALKER.get(),
					(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY)) + 2;
			sx = 0 - radium;
			for (int index0 = 0; index0 < (int) (radium * 2 + 1); index0++) {
				sz = 0 - radium;
				for (int index1 = 0; index1 < (int) (radium * 2 + 1); index1++) {
					if (sx * sx + sz * sz <= radium * radium) {
						if (((world.getBlockState(new BlockPos((int) (x - 0.5 + sx), (int) (y - 1), (int) (z - 0.5 + sz)))).getBlock() == Blocks.LAVA
								&& (world.getBlockState(new BlockPos((int) (x - 0.5 + sx), (int) (y - 1), (int) (z - 0.5 + sz)))).getFluidState()
										.isSource()
								|| (world.getBlockState(new BlockPos((int) (x - 0.5 + sx), (int) (y - 1), (int) (z - 0.5 + sz))))
										.getBlock() == BasaltWalkerModBlocks.MELTING_SOFT_BASALT_3.get() && new Object() {
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
									BasaltWalkerModBlocks.SOFT_BASALT.get().defaultBlockState(), 3);
						}
					}
					sz = sz + 1;
				}
				sx = sx + 1;
			}
		}
	}
}
