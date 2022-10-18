package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PrivateTest {
    private Integer num;

    public PrivateTest(Integer num) {
        this.num = num;
    }

    private void output() {
        System.out.println(this.num);
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException {
        PrivateTest privateTest = new PrivateTest(100);
//        Class cls = Class.forName("reflect.PriveteTest");
        Class cls = PrivateTest.class;
        Method privateMeth = cls.getDeclaredMethod("output");
        privateMeth.setAccessible(true);
        privateMeth.invoke(privateTest);
    }
}
