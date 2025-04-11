/*    */ package pro.mikey.xray;
/*    */ 
/*    */ import net.minecraftforge.common.ForgeConfigSpec;
/*    */ 
/*    */ public class Configuration {
/*  7 */   private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
/*    */   
/*  9 */   public static final General general = new General();
/*    */   
/* 10 */   public static final Store store = new Store();
/*    */   
/* 12 */   public static final ForgeConfigSpec.BooleanValue firstRun = BUILDER
/* 13 */     .comment(new String[] { "DO NOT TOUCH!", "This is not for you.", "This is used to check if it's the first time the mod has been run" }).define("firstRun", true);
/*    */   
/*    */   public static class General {
/*    */     public final ForgeConfigSpec.BooleanValue showOverlay;
/*    */     
/*    */     public final ForgeConfigSpec.DoubleValue outlineThickness;
/*    */     
/*    */     General() {
/* 21 */       Configuration.BUILDER.push("general");
/* 23 */       this
/*    */         
/* 25 */         .showOverlay = Configuration.BUILDER.comment("This allows you hide or show the overlay in the top right of the screen when XRay is enabled").define("showOverlay", true);
/* 27 */       this
/*    */         
/* 30 */         .outlineThickness = Configuration.BUILDER.comment(new String[] { "This allows you to set your own outline thickness, I find that 1.0 is perfect but others my", "think differently. The max is 5.0" }).defineInRange("outlineThickness", 1.0D, 1.0D, 5.0D);
/* 32 */       Configuration.BUILDER.pop();
/*    */     }
/*    */   }
/*    */   
/*    */   public static class Store {
/*    */     public final ForgeConfigSpec.IntValue radius;
/*    */     
/*    */     public final ForgeConfigSpec.BooleanValue lavaActive;
/*    */     
/*    */     Store() {
/* 41 */       Configuration.BUILDER.comment("DO NOT TOUCH!").push("store");
/* 43 */       this
/*    */         
/* 45 */         .radius = Configuration.BUILDER.comment(new String[] { "DO NOT TOUCH!", "This is not for you." }).defineInRange("radius", 2, 0, 5);
/* 47 */       this
/*    */         
/* 49 */         .lavaActive = Configuration.BUILDER.comment("Memory value for if you're currently wanting Lava to be rendered into the mix").define("lavaActive", false);
/* 51 */       Configuration.BUILDER.pop();
/*    */     }
/*    */   }
/*    */   
/* 55 */   public static final ForgeConfigSpec SPEC = BUILDER.build();
/*    */ }


/* Location:              C:\Users\Artem\Downloads\advanced-xray-forge-1.20.1-2.18.1-build.22.jar!\pro\mikey\xray\Configuration.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */