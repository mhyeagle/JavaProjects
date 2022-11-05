public class DoubleTest {
    public static void main(String[] args) {
        double money = 1000.123456789;

        System.out.println(storePrecision(money));

        Long num = Long.parseLong("1,2");
        System.out.println(num);

    }


    public static double storePrecision(double num) {
        return (double)Math.round(num * 10000) / 10000;
    }
}
