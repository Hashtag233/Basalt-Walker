
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package basaltwalker.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import basaltwalker.block.entity.SoftBasaltBlockEntity;
import basaltwalker.block.entity.MeltingSoftBasalt3BlockEntity;
import basaltwalker.block.entity.MeltingSoftBasalt2BlockEntity;
import basaltwalker.block.entity.MeltingSoftBasalt1BlockEntity;

import basaltwalker.BasaltWalkerMod;

public class BasaltWalkerModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES,
			BasaltWalkerMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> SOFT_BASALT = register("soft_basalt", BasaltWalkerModBlocks.SOFT_BASALT,
			SoftBasaltBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> MELTING_SOFT_BASALT_1 = register("melting_soft_basalt_1",
			BasaltWalkerModBlocks.MELTING_SOFT_BASALT_1, MeltingSoftBasalt1BlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> MELTING_SOFT_BASALT_2 = register("melting_soft_basalt_2",
			BasaltWalkerModBlocks.MELTING_SOFT_BASALT_2, MeltingSoftBasalt2BlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> MELTING_SOFT_BASALT_3 = register("melting_soft_basalt_3",
			BasaltWalkerModBlocks.MELTING_SOFT_BASALT_3, MeltingSoftBasalt3BlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block,
			BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
