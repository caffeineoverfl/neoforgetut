package io.github.caffeineoverfl.neoforgetut.item;

import io.github.caffeineoverfl.neoforgetut.TutorialMod;
import io.github.caffeineoverfl.neoforgetut.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);

    public static Supplier<CreativeModeTab> BLACK_OPAL_ITEMS_TAB = CREATIVE_MODE_TABS.register("black_opal_items_tab",() -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.neoforgetut.black_opal_items_tab"))
            .icon(() -> new ItemStack(ModItems.BLACK_OPAL.get()))
            .displayItems((pParameters, pOutput) -> {
                pOutput.accept(ModItems.BLACK_OPAL);
                pOutput.accept(ModItems.RAW_BLACK_OPAL);
            }).build());


    public static Supplier<CreativeModeTab> BLACK_OPAL_BLOCKS_TAB = CREATIVE_MODE_TABS.register("black_opal_blocks_tab",() -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.neoforgetut.black_opal_blocks_tab"))
            .icon(() -> new ItemStack(ModBlocks.BLACK_OPAL_BLOCK.get()))
            .withTabsBefore(ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "black_opal_items_tab"))
            .displayItems((pParameters, pOutput) -> {
                pOutput.accept(ModBlocks.BLACK_OPAL_BLOCK);
                pOutput.accept(ModBlocks.RAW_BLACK_OPAL_BLOCK);
            }).build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
