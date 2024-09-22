import java.io.File;
import java.io.IOException;

public class WSSolver {
  public static void main(String[] args) throws IOException{
    String fname;
    if (args.length == 0 || args.length > 1)
    {
      System.err.println("USAGE: java WSSolver [filename (.txt)]");
      return;
    } else 
      fname = args[0];
    SoupSolver solver = new SoupSolver(new File(fname));
    solver.solve();
    solver.writeOutputFile(fname);    
  }
}
