package net.foxinerd.toxic_creaking.mobeffect;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
public class TCMobEffects {
    public static final Holder<MobEffect> RESIN =
            Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, Identifier.fromNamespaceAndPath("toxic_creaking", "resin_poisoning"), new ResinEffect().addAttributeModifier(Attributes.MAX_HEALTH, Identifier.fromNamespaceAndPath("toxic_creaking", "resin_poisoning"), (double)-2.0F, AttributeModifier.Operation.ADD_VALUE));
    public static void initialize() {
        // ...
    }

}

