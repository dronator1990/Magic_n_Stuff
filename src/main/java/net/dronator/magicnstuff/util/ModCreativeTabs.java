package net.dronator.magicnstuff.util;

import net.dronator.magicnstuff.item.ModCurioItems;
import net.dronator.magicnstuff.item.ModUpgradeItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static net.dronator.magicnstuff.Magicnstuff.MODID;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MNS_TAB = CREATIVE_MODE_TABS.register("example_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup."+MODID))
            .icon(() -> ModUpgradeItems.GREATER_SPELL_SLOT_UPGRADE.get().getDefaultInstance())
            .displayItems((parameters, output) -> {

                output.accept(ModUpgradeItems.GREATER_SPELL_SLOT_UPGRADE);

                output.accept(ModCurioItems.GREATER_MANA_RING.get());
                output.accept(ModCurioItems.SUPERIOR_MANA_RING.get());

            }).build());
}
