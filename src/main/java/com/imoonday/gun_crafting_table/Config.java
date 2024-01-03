package com.imoonday.gun_crafting_table;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod.EventBusSubscriber(modid = GunCraftingTable.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    private static final ForgeConfigSpec.ConfigValue<String> COMMAND = BUILDER
            .comment("指令")
            .define("command", GunCraftingTable.GunCraftingTableBlock.COMMAND);
    static final ForgeConfigSpec SPEC = BUILDER.build();

    public static String command;

    @SubscribeEvent
    static void onLoad(final ModConfig.Loading event) {
        command = COMMAND.get();
    }

    @SubscribeEvent
    static void onReload(final ModConfig.Reloading event) {
        command = COMMAND.get();
    }
}
