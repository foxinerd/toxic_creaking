package net.foxinerd.toxic_creaking.mixin;
import net.foxinerd.toxic_creaking.mobeffect.TCMobEffects;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.creaking.Creaking;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Creaking.class)
public abstract class CreakingResinPoison extends Monster {
    //Modify Creaking doHurtTarget method

    protected CreakingResinPoison(EntityType<? extends Creaking> entityType, Level level) {super(entityType, level);}

    @Inject(method = "doHurtTarget", at = @At("TAIL"))
    public void doHurtTarget(ServerLevel serverLevel, Entity entity, CallbackInfoReturnable<Boolean> cir){
        if ((entity instanceof LivingEntity)) {
            MobEffectInstance currentResinPoisoning = ((LivingEntity) entity).getEffect(TCMobEffects.RESIN);
            MobEffectInstance hasAbsorption = ((LivingEntity) entity).getEffect(MobEffects.ABSORPTION);
            if(hasAbsorption ==  null){
                if (currentResinPoisoning != null){
                    int amp = currentResinPoisoning.getAmplifier();
                    ((LivingEntity) entity).addEffect(new MobEffectInstance(TCMobEffects.RESIN, 120 * 20, amp+1), this);
                }else {
                    ((LivingEntity) entity).addEffect(new MobEffectInstance(TCMobEffects.RESIN, 120 * 20, 0), this);
                }
            }
        }
    }

    //Check if Target has Resin Poisoning effect and get its amplifier
    // If yes, then apply Resin Poisoning of +1 Amplifier
    //Otherwise, apply Resin Poisoning of amp 0
}
