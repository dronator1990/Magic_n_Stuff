package net.dronator.magicnstuff.datagen;

import net.dronator.magicnstuff.Magicnstuff;
import net.dronator.magicnstuff.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Magicnstuff.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.GREATER_SPELL_SLOT_UPGRADE.get());
    }
}