package io.github.crazysmc.xpseedzero.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity
{
  protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world)
  {
    super(entityType, world);
  }

  @Inject(at = @At("HEAD"), method = "getEnchantmentTableSeed", cancellable = true)
  private void onGetEnchantmentTableSeed(CallbackInfoReturnable<Integer> cir)
  {
    cir.setReturnValue(0);
  }
}