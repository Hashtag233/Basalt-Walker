
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package basaltwalker.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import java.util.List;
import java.util.ArrayList;

import basaltwalker.block.entity.SoftBasaltBlockEntity;
import basaltwalker.block.entity.MeltingSoftBasalt3BlockEntity;
import basaltwalker.block.entity.MeltingSoftBasalt2BlockEntity;
import basaltwalker.block.entity.MeltingSoftBasalt1BlockEntity;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BasaltWalkerModBlockEntities {
	private static final List<BlockEntityType<?>> REGISTRY = new ArrayList<>();
	public static final BlockEntityType<?> SOFT_BASALT = register("basalt_walker:soft_basalt", BasaltWalkerModBlocks.SOFT_BASALT,
			SoftBasaltBlockEntity::new);
	public static final BlockEntityType<?> MELTING_SOFT_BASALT_1 = register("basalt_walker:melting_soft_basalt_1",
			BasaltWalkerModBlocks.MELTING_SOFT_BASALT_1, MeltingSoftBasalt1BlockEntity::new);
	public static final BlockEntityType<?> MELTING_SOFT_BASALT_2 = register("basalt_walker:melting_soft_basalt_2",
			BasaltWalkerModBlocks.MELTING_SOFT_BASALT_2, MeltingSoftBasalt2BlockEntity::new);
	public static final BlockEntityType<?> MELTING_SOFT_BASALT_3 = register("basalt_walker:melting_soft_basalt_3",
			BasaltWalkerModBlocks.MELTING_SOFT_BASALT_3, MeltingSoftBasalt3BlockEntity::new);

	private static BlockEntityType<?> register(String registryname, Block block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		BlockEntityType<?> blockEntityType = BlockEntityType.Builder.of(supplier, block).build(null).setRegistryName(registryname);
		REGISTRY.add(blockEntityType);
		return blockEntityType;
	}

	@SubscribeEvent
	public static void registerTileEntity(RegistryEvent.Register<BlockEntityType<?>> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new BlockEntityType[0]));
	}
}
