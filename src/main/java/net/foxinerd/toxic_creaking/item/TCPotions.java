package net.foxinerd.toxic_creaking.item;
import net.fabricmc.fabric.api.registry.FabricPotionBrewingBuilder;
import net.foxinerd.toxic_creaking.TCConstants;
import net.foxinerd.toxic_creaking.mobeffect.TCMobEffects;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.Potions;
public class TCPotions {
    public static final Holder<Potion> RESIN_POTION =
            Registry.registerForHolder(
                    BuiltInRegistries.POTION,
                    TCConstants.id("resin_poisoning"),
                    new Potion("resin_poisoning",
                            new MobEffectInstance(
                                    TCMobEffects.RESIN,
                                    1800,
                                    1)));

    public static final Holder<Potion> RESIN_POTION_LONG =
            Registry.registerForHolder(
                    BuiltInRegistries.POTION,
                    TCConstants.id("resin_poisoning_long"),
                    new Potion("resin_poisoning",
                            new MobEffectInstance(
                                    TCMobEffects.RESIN,
                                    3600,
                                    1)));


    public static final Holder<Potion> RESIN_POTION_STRONG =
            Registry.registerForHolder(
                    BuiltInRegistries.POTION,
                    TCConstants.id("resin_poisoning_strong"),
                    new Potion("resin_poisoning",
                            new MobEffectInstance(
                                    TCMobEffects.RESIN,
                                    900,
                                    2)));
    public static final Holder<Potion> VITALITY_POTION =
            Registry.registerForHolder(
                    BuiltInRegistries.POTION,
                    TCConstants.id("vitality"),
                    new Potion("vitality",
                            new MobEffectInstance(MobEffects.HEALTH_BOOST, 3600, 1),
                            new MobEffectInstance(MobEffects.REGENERATION, 8, 5)
                    ));

    public static final Holder<Potion> VITALITY_POTION_LONG =
            Registry.registerForHolder(
                    BuiltInRegistries.POTION,
                    TCConstants.id("vitality_long"),
                    new Potion("vitality",
                            new MobEffectInstance(MobEffects.HEALTH_BOOST, 9600, 1),
                            new MobEffectInstance(MobEffects.REGENERATION, 8, 5)
                    ));
    public static final Holder<Potion> VITALITY_POTION_STRONG =
            Registry.registerForHolder(
                    BuiltInRegistries.POTION,
                    TCConstants.id("vitality_strong"),
                    new Potion("vitality",
                            new MobEffectInstance(MobEffects.HEALTH_BOOST, 1800, 2),
                            new MobEffectInstance(MobEffects.REGENERATION, 12, 5)
                    ));


    public static void initialize() {
        FabricPotionBrewingBuilder.BUILD.register(builder -> {
            builder.addMix(
                    // Input potion.
                    Potions.AWKWARD,
                    // Ingredient
                    Items.RESIN_CLUMP,
                    // Output potion.
                    RESIN_POTION
            );

            builder.addMix(
                    // Input potion.
                    TCPotions.RESIN_POTION,
                    // Ingredient
                    Items.GLOWSTONE_DUST,
                    // Output potion.
                    RESIN_POTION_STRONG
            );

            builder.addMix(
                    // Input potion.
                    TCPotions.RESIN_POTION,
                    // Ingredient
                    Items.REDSTONE,
                    // Output potion.
                    RESIN_POTION_LONG
            );

            builder.addMix(
                    // Input potion.
                    TCPotions.RESIN_POTION,
                    // Ingredient
                    Items.FERMENTED_SPIDER_EYE,
                    // Output potion.
                    VITALITY_POTION
            );
            builder.addMix(
                    // Input potion.
                    TCPotions.VITALITY_POTION,
                    // Ingredient
                    Items.GLOWSTONE_DUST,
                    // Output potion.
                    VITALITY_POTION_STRONG
            );

            builder.addMix(
                    // Input potion.
                    TCPotions.VITALITY_POTION,
                    // Ingredient
                    Items.REDSTONE,
                    // Output potion.
                    VITALITY_POTION_LONG
            );
        });
    }
}
