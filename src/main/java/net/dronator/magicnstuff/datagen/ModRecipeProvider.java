package net.dronator.magicnstuff.datagen;

import io.redspace.ironsspellbooks.registries.ItemRegistry;
import net.dronator.magicnstuff.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GREATER_SPELL_SLOT_UPGRADE)
                .pattern("DCD")
                .pattern("DLD")
                .pattern("DCD")
                .define('D', ItemRegistry.DRAGONSKIN.get())
                .define('C', ItemRegistry.MAGIC_CLOTH.get())
                .define('L', ItemRegistry.LESSER_SPELL_SLOT_UPGRADE.get())
                .unlockedBy("has_magic_cloth", has(ItemRegistry.MAGIC_CLOTH.get()))
                .save(recipeOutput);
    }
}

