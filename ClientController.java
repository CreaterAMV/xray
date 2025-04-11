/*    */ package pro.mikey.xray;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import net.minecraft.ChatFormatting;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.resources.language.I18n;
/*    */ import net.minecraft.network.chat.Component;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraftforge.common.MinecraftForge;
/*    */ import net.minecraftforge.event.entity.EntityJoinLevelEvent;
/*    */ import net.minecraftforge.eventbus.api.IEventBus;
/*    */ import net.minecraftforge.fml.ModLoadingContext;
/*    */ import net.minecraftforge.fml.config.IConfigSpec;
/*    */ import net.minecraftforge.fml.config.ModConfig;
/*    */ import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
/*    */ import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
/*    */ import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
/*    */ import pro.mikey.xray.keybinding.KeyBindings;
/*    */ import pro.mikey.xray.store.BlockStore;
/*    */ import pro.mikey.xray.store.DiscoveryStorage;
/*    */ import pro.mikey.xray.store.GameBlockStore;
/*    */ import pro.mikey.xray.utils.BlockData;
/*    */ import pro.mikey.xray.xray.Controller;
/*    */ import pro.mikey.xray.xray.Events;
/*    */ 
/*    */ public class ClientController {
/* 30 */   public static GameBlockStore gameBlockStore = new GameBlockStore();
/*    */   
/* 31 */   public static DiscoveryStorage blockStore = new DiscoveryStorage();
/*    */   
/*    */   public static void setup() {
/* 34 */     IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
/* 36 */     eventBus.addListener(ClientController::onSetup);
/* 37 */     eventBus.addListener(ClientController::onLoadComplete);
/* 38 */     eventBus.addListener(KeyBindings::registerKeyBinding);
/* 39 */     ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, (IConfigSpec)Configuration.SPEC);
/* 42 */     MinecraftForge.EVENT_BUS.register(KeyBindings.class);
/* 43 */     MinecraftForge.EVENT_BUS.addListener(ClientController::onGameJoin);
/* 45 */     MinecraftForge.EVENT_BUS.addListener(Events::tickEnd);
/* 46 */     MinecraftForge.EVENT_BUS.addListener(Events::onWorldRenderLast);
/*    */   }
/*    */   
/*    */   private static void onSetup(FMLCommonSetupEvent event) {
/* 51 */     XRay.logger.debug(I18n.m_118938_("xray.debug.init", new Object[0]));
/* 53 */     KeyBindings.setup();
/* 54 */     List<BlockData.SerializableBlockData> data = blockStore.read();
/* 55 */     if (data.isEmpty())
/*    */       return; 
/* 58 */     ArrayList<BlockData> map = BlockStore.getFromSimpleBlockList(data);
/* 59 */     Controller.getBlockStore().setStore(map);
/*    */   }
/*    */   
/*    */   private static void onGameJoin(EntityJoinLevelEvent event) {
/*    */     Player player;
/* 63 */     if (!((Boolean)Configuration.firstRun.get()).booleanValue())
/*    */       return; 
/* 67 */     if (event.getLevel().m_5776_()) {
/* 67 */       Entity entity = event.getEntity();
/* 67 */       if (entity instanceof Player) {
/* 67 */         player = (Player)entity;
/*    */       } else {
/*    */         return;
/*    */       } 
/*    */     } else {
/*    */       return;
/*    */     } 
/* 71 */     if (player != (Minecraft.m_91087_()).f_91074_)
/*    */       return; 
/* 75 */     player.m_5661_((Component)Component.m_237110_("xray.chat.first-time", new Object[] { KeyBindings.toggleGui.getKey().m_84875_().m_6881_().m_130940_(ChatFormatting.GREEN), KeyBindings.toggleXRay.getKey().m_84875_().m_6881_().m_130940_(ChatFormatting.GREEN) }), false);
/* 76 */     player.m_5661_((Component)Component.m_237115_("xray.chat.first-time-line-2"), false);
/* 77 */     Configuration.firstRun.set(Boolean.valueOf(false));
/* 78 */     Configuration.firstRun.save();
/*    */   }
/*    */   
/*    */   private static void onLoadComplete(FMLLoadCompleteEvent event) {
/* 82 */     gameBlockStore.populate();
/*    */   }
/*    */ }


/* Location:              C:\Users\Artem\Downloads\advanced-xray-forge-1.20.1-2.18.1-build.22.jar!\pro\mikey\xray\ClientController.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */