
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Mps {

	public static void main(String[] args) {
	    ScriptEngineManager factory = new ScriptEngineManager();
	    // Create a AppleScript engine.
	    ScriptEngine engine = factory.getEngineByName("AppleScript");
 	    try {
    		FileReader rdr = new FileReader("mps.as");
    		ArrayList<ArrayList<?>> procs = (ArrayList<ArrayList<?>>)engine.eval(rdr);
    		for (ArrayList<?> proc : procs) {
    			String pid = proc.get(0).toString();
    			String name = proc.get(1).toString();
    			String path = proc.get(2).toString();
    			String creator = proc.get(3).toString();
    			String bundleid = proc.get(4).toString();
    			if (name.length() > 10) 
    				System.out.println(pid + "\t" + name + "\t" + bundleid + "\t" + creator + "\t" + path);
    			else 
    				System.out.println(pid + "\t" + name + "\t\t" + bundleid + "\t" + creator + "\t" + path);
    		}
    	}
    	catch (IOException ioex) {
    		ioex.printStackTrace();
    	}
    	catch (ScriptException exception) {
    		exception.printStackTrace();
    	}
	}
}
