package net.dronator.magicnstuff.datagen;

import io.redspace.ironsspellbooks.registries.ItemRegistry;
import net.dronator.magicnstuff.Config;
import net.dronator.magicnstuff.item.ModCurioItems;
import net.dronator.magicnstuff.item.ModUpgradeItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModUpgradeItems.GREATER_SPELL_SLOT_UPGRADE)
                .pattern("DCD")
                .pattern("DLD")
                .pattern("DCD")
                .define('D', ItemRegistry.DRAGONSKIN.get())
                .define('C', ItemRegistry.MAGIC_CLOTH.get())
                .define('L', ItemRegistry.LESSER_SPELL_SLOT_UPGRADE.get())
                .unlockedBy("has_magic_cloth", has(ItemRegistry.MAGIC_CLOTH.get()))
                .save(recipeOutput);

        SmithingTransformRecipeBuilder.smithing(
                Ingredient.of(ItemRegistry.BLANK_RUNE.get()),
                Ingredient.of(ItemRegistry.MANA_RING.get()),
                Ingredient.of(ItemRegistry.MITHRIL_INGOT.get()),
                RecipeCategory.MISC, ModCurioItems.GREATER_MANA_RING.get())
                .unlocks("has_mithril_ingot", has(ItemRegistry.MITHRIL_INGOT.get()))
                .save(recipeOutput, "greater_mana_ring_smithing");

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.BLANK_RUNE.get()),
                        Ingredient.of(ModCurioItems.GREATER_MANA_RING.get()),
                        Ingredient.of(ItemRegistry.DIVINE_SOULSHARD.get()),
                        RecipeCategory.MISC, ModCurioItems.SUPERIOR_MANA_RING.get())
                .unlocks("has_divine_soulshard", has(ItemRegistry.DIVINE_SOULSHARD.get()))
                .save(recipeOutput, "superior_mana_ring_smithing");
    }
}

