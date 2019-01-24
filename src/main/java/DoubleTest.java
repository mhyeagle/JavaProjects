public class DoubleTest {
    public static void main(String[] args) {
        double money = 1000.123456789;

        System.out.println(storePrecision(money));
    }


    public static double storePrecision(double num) {
        return (double)Math.round(num * 10000) / 10000;
    }
}
