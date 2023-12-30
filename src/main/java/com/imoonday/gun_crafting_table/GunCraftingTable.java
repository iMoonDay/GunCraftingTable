package com.imoonday.gun_crafting_table;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod(GunCraftingTable.MOD_ID)
public class GunCraftingTable {

    public static final String MOD_ID = "gun_crafting_table";
    public static final Block BLOCK = new GunCraftingTableBlock(AbstractBlock.Properties.copy(Blocks.CRAFTING_TABLE)).setRegistryName(MOD_ID, MOD_ID);

    public GunCraftingTable() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            blockRegistryEvent.getRegistry().register(BLOCK);
        }

        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> itemRegistryEvent) {
            itemRegistryEvent.getRegistry().register(new BlockItem(BLOCK, new Item.Properties().tab(ItemGroup.TAB_MISC)).setRegistryName(MOD_ID, MOD_ID));
        }

    }

    public static class GunCraftingTableBlock extends Block {

        public static final String COMMAND = "/menu open weapontable";

        public GunCraftingTableBlock(Properties properties) {
            super(properties);
        }

        @Override
        public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult result) {
            if (world.isClientSide) {
                ((ClientPlayerEntity) player).chat(COMMAND);
            }
            return ActionResultType.sidedSuccess(world.isClientSide);
        }
    }
}
