import org.springframework.stereotype.Component;

@Component
public class JunitFunction {
    private int num1;
    private double num2;

    public JunitFunction() {
        num1 = 1;
        num2 = 2.0;
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public double add() {
        return num1 + num2;
    }
}
