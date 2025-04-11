/*    */ package pro.mikey.xray;
/*    */ 
/*    */ import net.minecraftforge.common.ForgeConfigSpec;
/*    */ 
/*    */ public class General {
/*    */   public final ForgeConfigSpec.BooleanValue showOverlay;
/*    */   
/*    */   public final ForgeConfigSpec.DoubleValue outlineThickness;
/*    */   
/*    */   General() {
/* 21 */     Configuration.BUILDER.push("general");
/* 23 */     this
/*    */       
/* 25 */       .showOverlay = Configuration.BUILDER.comment("This allows you hide or show the overlay in the top right of the screen when XRay is enabled").define("showOverlay", true);
/* 27 */     this
/*    */       
/* 30 */       .outlineThickness = Configuration.BUILDER.comment(new String[] { "This allows you to set your own outline thickness, I find that 1.0 is perfect but others my", "think differently. The max is 5.0" }).defineInRange("outlineThickness", 1.0D, 1.0D, 5.0D);
/* 32 */     Configuration.BUILDER.pop();
/*    */   }
/*    */ }


/* Location:              C:\Users\Artem\Downloads\advanced-xray-forge-1.20.1-2.18.1-build.22.jar!\pro\mikey\xray\Configuration$General.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */