package net.foxinerd.toxic_creaking.mobeffect;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class ResinEffect extends MobEffect {
    protected ResinEffect(){
        super(MobEffectCategory.HARMFUL, 0xf97a2f);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        // In our case, we just make it return true so that it applies the effect every tick
        return true;
    }

    @Override
    public boolean applyEffectTick(ServerLevel world, LivingEntity entity, int amplifier) {
        return super.applyEffectTick(world, entity, amplifier);
    }
}
