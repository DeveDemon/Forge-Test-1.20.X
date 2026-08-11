package net.devedemon.testmod_forge;

import com.mojang.logging.LogUtils;
import net.devedemon.testmod_forge.block.ModBlocks;
import net.devedemon.testmod_forge.item.ModCreativeModTabs;
import net.devedemon.testmod_forge.item.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TestForgeMod.MOD_ID)
public class TestForgeMod {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "testmod_forge";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public TestForgeMod(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        ModCreativeModTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.SAPPHIRE);
            event.accept(ModItems.RAW_SAPPHIRE);
            event.accept(ModItems.PINE_CONE);
        }
        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.SAPPHIRE_BLOCK);
            event.accept(ModBlocks.RAW_SAPPHIRE_BLOCK);
            event.accept(ModBlocks.SAPPHIRE_STAIRS);
            event.accept(ModBlocks.SAPPHIRE_SLAB);
            event.accept(ModBlocks.SAPPHIRE_FENCE);
            event.accept(ModBlocks.SAPPHIRE_FENCE_GATE);
            event.accept(ModBlocks.SAPPHIRE_WALL);
            event.accept(ModBlocks.SAPPHIRE_DOOR);
            event.accept(ModBlocks.SAPPHIRE_TRAPDOOR);
        }
        if(event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(ModBlocks.SAPPHIRE_ORE);
            event.accept(ModBlocks.DEEPSLATE_SAPPHIRE_ORE);
        }
        if(event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.METAL_DETECTOR);
            event.accept(ModItems.SAPPHIRE_STAFF);
            event.accept(ModItems.SAPPHIRE_PICKAXE);
            event.accept(ModItems.SAPPHIRE_AXE);
            event.accept(ModItems.SAPPHIRE_SHOVEL);
            event.accept(ModItems.SAPPHIRE_HOE);
        }
        if(event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(ModItems.STRAWBERRY);
        }
        if(event.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS) {
            event.accept(ModBlocks.SAPPHIRE_BUTTON);
            event.accept(ModBlocks.SAPPHIRE_PRESSURE_PLATE);
        }
        if(event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            event.accept(ModBlocks.SOUND_BLOCK);
        }
        if(event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(ModItems.SAPPHIRE_SWORD);
            event.accept(ModItems.SAPPHIRE_AXE);
        }


    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
