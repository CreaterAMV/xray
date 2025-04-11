/*    */ package pro.mikey.xray;
/*    */ 
/*    */ import java.lang.invoke.SerializedLambda;
/*    */ import net.minecraftforge.api.distmarker.Dist;
/*    */ import net.minecraftforge.fml.DistExecutor;
/*    */ import net.minecraftforge.fml.IExtensionPoint;
/*    */ import net.minecraftforge.fml.ModLoadingContext;
/*    */ import net.minecraftforge.fml.common.Mod;
/*    */ import org.apache.logging.log4j.LogManager;
/*    */ import org.apache.logging.log4j.Logger;
/*    */ 
/*    */ @Mod("xray")
/*    */ public class XRay {
/*    */   public static final String MOD_ID = "xray";
/*    */   
/* 14 */   public static final String PREFIX_GUI = String.format("%s:textures/gui/", new Object[] { "xray" });
/*    */   
/* 16 */   public static Logger logger = LogManager.getLogger();
/*    */   
/*    */   public XRay() {
/* 19 */     ModLoadingContext.get().registerExtensionPoint(IExtensionPoint.DisplayTest.class, () -> new IExtensionPoint.DisplayTest((), ()));
/* 20 */     DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> ClientController::setup);
/*    */   }
/*    */ }


/* Location:              C:\Users\Artem\Downloads\advanced-xray-forge-1.20.1-2.18.1-build.22.jar!\pro\mikey\xray\XRay.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */