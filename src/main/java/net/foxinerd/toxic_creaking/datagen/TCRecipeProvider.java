package net.foxinerd.toxic_creaking.datagen;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import net.minecraft.advancements.Advancement;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.*;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.ShieldDecorationRecipe;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditions;
import net.foxinerd.toxic_creaking.ToxicCreaking;
import net.foxinerd.toxic_creaking.item.TCPotions;




public  class TCRecipeProvider extends FabricRecipeProvider {
    public TCRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected  RecipeProvider createRecipeProvider(HolderLookup.Provider provider, BootstrapContext<Recipe<?>> recipes, BootstrapContext<Advancement> advancements) {
        return new RecipeProvider(recipes, advancements) {
            @Override
            public void buildRecipes() {
                BrewingProvider brewingProvider = new BrewingProvider(output) {
                    @Override
                    protected void addContainers() {
                        addContainer(Items.LINGERING_POTION);
                        addContainer(Items.POTION);
                        addContainer(Items.SPLASH_POTION);
                    }

                    @Override
                    protected void addContainerTransformations() {
                        addContainerTransformation(Items.POTION, Items.GUNPOWDER, Items.SPLASH_POTION);
                        addContainerTransformation(Items.SPLASH_POTION, Items.DRAGON_BREATH, Items.LINGERING_POTION);
                    }

                    @Override
                    protected void buildMixes() {
                        buildMix(
                                // Input potion.
                                Potions.AWKWARD,
                                // Ingredient
                                Items.RESIN_CLUMP,
                                // Output potion.
                                TCPotions.RESIN_POTION
                        );

                        buildMix(
                                // Input potion.
                                TCPotions.RESIN_POTION,
                                // Ingredient
                                Items.GLOWSTONE_DUST,
                                // Output potion.
                                TCPotions.RESIN_POTION_STRONG
                        );

                        buildMix(
                                // Input potion.
                                TCPotions.RESIN_POTION,
                                // Ingredient
                                Items.REDSTONE,
                                // Output potion.
                                TCPotions.RESIN_POTION_LONG
                        );

                        buildMix(
                                // Input potion.
                                TCPotions.RESIN_POTION,
                                // Ingredient
                                Items.FERMENTED_SPIDER_EYE,
                                // Output potion.
                                TCPotions.VITALITY_POTION
                        );
                        buildMix(
                                // Input potion.
                                TCPotions.VITALITY_POTION,
                                // Ingredient
                                Items.GLOWSTONE_DUST,
                                // Output potion.
                                TCPotions.VITALITY_POTION_STRONG
                        );

                        buildMix(
                                // Input potion.
                                TCPotions.VITALITY_POTION,
                                // Ingredient
                                Items.REDSTONE,
                                // Output potion.
                                TCPotions.VITALITY_POTION_LONG
                        );
                    }
                };
                brewingProvider.buildRecipes();
            }
        };
    }
}
