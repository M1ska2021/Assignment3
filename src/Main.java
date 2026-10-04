import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        if (args.length > 0 && "--demo".equals(args[0])) {
            runDemo();
        } else {
            System.out.println("Usage: java -cp out Main --demo");
        }
    }

    private static void runDemo() {
        int passed = 0;
        int total = 7;

        Circle c1 = new Circle("C-01", 2, new VectorRenderer());
        String res1 = c1.execute();
        String exp1 = "VECTOR circle radius=2";
        if (Objects.equals(res1, exp1)) {
            System.out.println("T1 PASS | Circle + VectorRenderer | result=" + res1);
            passed++;
        } else {
            System.out.println("T1 FAIL | Circle + VectorRenderer | expected=" + exp1 + " | actual=" + res1);
        }

        Circle c2 = new Circle("C-02", 2, new RasterRenderer());
        String res2 = c2.execute();
        String exp2 = "RASTER circle radius=2";
        if (Objects.equals(res2, exp2)) {
            System.out.println("T2 PASS | Circle + RasterRenderer | result=" + res2);
            passed++;
        } else {
            System.out.println("T2 FAIL | Circle + RasterRenderer | expected=" + exp2 + " | actual=" + res2);
        }

        Square s1 = new Square("S-01", 3, new VectorRenderer());
        String res3 = s1.execute();
        String exp3 = "VECTOR square side=3";
        if (Objects.equals(res3, exp3)) {
            System.out.println("T3 PASS | Square + VectorRenderer | result=" + res3);
            passed++;
        } else {
            System.out.println("T3 FAIL | Square + VectorRenderer | expected=" + exp3 + " | actual=" + res3);
        }

        Square s2 = new Square("S-02", 3, new RasterRenderer());
        String res4 = s2.execute();
        String exp4 = "RASTER square side=3";
        if (Objects.equals(res4, exp4)) {
            System.out.println("T4 PASS | Square + RasterRenderer | result=" + res4);
            passed++;
        } else {
            System.out.println("T4 FAIL | Square + RasterRenderer | expected=" + exp4 + " | actual=" + res4);
        }

        Circle c5 = new Circle("C-05", 2, new VectorRenderer());
        Circle refBefore = c5;
        String idBefore = c5.getId();
        double dataBefore = c5.getRadius();
        String beforeResult = c5.execute();

        c5.setImplementation(new RasterRenderer());
        Circle refAfter = c5;
        String idAfter = c5.getId();
        double dataAfter = c5.getRadius();
        String afterResult = c5.execute();

        boolean sameObject = (refBefore == refAfter);
        boolean stateUnchanged = Objects.equals(idBefore, idAfter) && (dataBefore == dataAfter);
        boolean beforeMatch = "VECTOR circle radius=2".equals(beforeResult);
        boolean afterMatch = "RASTER circle radius=2".equals(afterResult);

        if (sameObject && stateUnchanged && beforeMatch && afterMatch) {
            System.out.println("T5 PASS | sameObject=" + sameObject + " | stateUnchanged=" + stateUnchanged);
            System.out.println(" before=" + beforeResult + " | after=" + afterResult);
            passed++;
        } else {
            System.out.println("T5 FAIL | sameObject=" + sameObject + " | stateUnchanged=" + stateUnchanged);
            System.out.println(" before=" + beforeResult + " | after=" + afterResult);
        }

        Circle c6 = new Circle("C-06", 2, new AsciiRenderer());
        String res6 = c6.execute();
        String exp6 = "ASCII circle radius=2";
        if (Objects.equals(res6, exp6)) {
            System.out.println("T6 PASS | Circle + AsciiRenderer | result=" + res6);
            passed++;
        } else {
            System.out.println("T6 FAIL | Circle + AsciiRenderer | expected=" + exp6 + " | actual=" + res6);
        }

        Square s7 = new Square("S-07", 3, new AsciiRenderer());
        String res7 = s7.execute();
        String exp7 = "ASCII square side=3";
        if (Objects.equals(res7, exp7)) {
            System.out.println("T7 PASS | Square + AsciiRenderer | result=" + res7);
            passed++;
        } else {
            System.out.println("T7 FAIL | Square + AsciiRenderer | expected=" + exp7 + " | actual=" + res7);
        }

        System.out.println("SUMMARY: " + passed + "/" + total + " PASS");
    }
}
