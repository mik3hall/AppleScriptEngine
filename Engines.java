
import javax.script.*;
import java.util.List;

/**
 * @author mjh
 * Copied from
 *     Scripting for the Java Platform
 *     http://java.sun.com/developer/technicalArticles/J2SE/Desktop/scripting/
 */
public class Engines {
	private static final String script = "set cd to (random number 100000) mod 52 + 1 \r return cd";
	public static void main(String[] args) {
//	  System.out.println("engines loader used " + Thread.currentThread().getClass().getClassLoader());
//	  ScriptEngineManager mgr = new ScriptEngineManager(Thread.currentThread().getClass().getClassLoader());
	  ScriptEngineManager mgr = new ScriptEngineManager();
	  // Create a JavaScript engine.
	  List<ScriptEngineFactory> factories = 
	      mgr.getEngineFactories();
	  for (ScriptEngineFactory factory: factories) {
	    System.out.println("ScriptEngineFactory Info");
	    System.out.println("\tFactory class:" + factory.getClass());
	    String engName = factory.getEngineName();
	    String engVersion = factory.getEngineVersion();
	    String langName = factory.getLanguageName();
	    String langVersion = factory.getLanguageVersion();
	    System.out.printf("\tScript Engine: %s (%s)\n", 
	        engName, engVersion);
	    List<String> engNames = factory.getNames();
	    for(String name: engNames) {
	      System.out.printf("\tEngine Alias: %s\n", name);
	    }
	    System.out.printf("\tLanguage: %s (%s)\n", 
	        langName, langVersion);	    
	  }
	  ScriptEngine engine = mgr.getEngineByName("AppleScript");
	  try {
	  	Long result = (Long)engine.eval(script);
	  	System.out.println("Pick a card script result: " + result);
	  }
	  catch (ScriptException scex) { scex.printStackTrace(); }
	}
}
