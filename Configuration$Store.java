/*    */ package pro.mikey.xray;
/*    */ 
/*    */ import net.minecraftforge.common.ForgeConfigSpec;
/*    */ 
/*    */ public class Store {
/*    */   public final ForgeConfigSpec.IntValue radius;
/*    */   
/*    */   public final ForgeConfigSpec.BooleanValue lavaActive;
/*    */   
/*    */   Store() {
/* 41 */     Configuration.BUILDER.comment("DO NOT TOUCH!").push("store");
/* 43 */     this
/*    */       
/* 45 */       .radius = Configuration.BUILDER.comment(new String[] { "DO NOT TOUCH!", "This is not for you." }).defineInRange("radius", 2, 0, 5);
/* 47 */     this
/*    */       
/* 49 */       .lavaActive = Configuration.BUILDER.comment("Memory value for if you're currently wanting Lava to be rendered into the mix").define("lavaActive", false);
/* 51 */     Configuration.BUILDER.pop();
/*    */   }
/*    */ }


/* Location:              C:\Users\Artem\Downloads\advanced-xray-forge-1.20.1-2.18.1-build.22.jar!\pro\mikey\xray\Configuration$Store.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */