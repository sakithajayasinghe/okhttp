import org.junit.runner.*;
// Runs each argument (fully.qualified.Class#method) as its own JUnitCore run, in the given order, in one JVM.
public class Seq4 {
  public static void main(String[] args) throws Exception {
    JUnitCore core = new JUnitCore(); int failed = 0;
    for (String a : args) {
      String[] p = a.split("#");
      Result r = core.run(Request.method(Class.forName(p[0]), p[1]));
      System.out.printf("RESULT %s run=%d failed=%d ms=%d%n", a, r.getRunCount(), r.getFailureCount(), r.getRunTime());
      failed += r.getFailureCount();
    }
    System.exit(failed == 0 ? 0 : 1);
  }
}
