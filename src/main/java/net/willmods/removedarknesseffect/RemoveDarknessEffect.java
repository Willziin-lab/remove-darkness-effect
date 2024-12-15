package net.willmods.removedarknesseffect;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.effect.MobEffects;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;


@Mod("removedarknesseffect")
@EventBusSubscriber({Dist.CLIENT})
public class RemoveDarknessEffect {

    @SubscribeEvent
    public static void onClientTick(PlayerTickEvent.Post event) {
        LocalPlayer player = Minecraft.getInstance().player;
        if (player != null) {
            boolean hasDarkness = player.getEffect(MobEffects.DARKNESS) != null;
            if (hasDarkness) {
                player.removeEffect(MobEffects.DARKNESS);
            }
        }
    }
}
