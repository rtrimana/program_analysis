import soot.*;
import soot.options.*;
import java.util.Map;

public class Adapter {
  public static void main(String[] args) {
    PackManager.v().getPack("jtp").add(new Transform("jtp.buster", new Buster()));
    Options.v().set_verbose(true);
    soot.Main.main(args);
  }
}
