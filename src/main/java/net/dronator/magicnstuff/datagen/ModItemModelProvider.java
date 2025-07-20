package net.dronator.magicnstuff.datagen;

import net.dronator.magicnstuff.Config;
import net.dronator.magicnstuff.Magicnstuff;
import net.dronator.magicnstuff.item.ModCurioItems;
import net.dronator.magicnstuff.item.ModUpgradeItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Magicnstuff.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModUpgradeItems.GREATER_SPELL_SLOT_UPGRADE.get());

        basicItem(ModCurioItems.GREATER_MANA_RING.get());
        basicItem(ModCurioItems.SUPERIOR_MANA_RING.get());
    }
}