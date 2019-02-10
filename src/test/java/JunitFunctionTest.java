import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

public class JunitFunctionTest extends BaseServiceTest {
    @Autowired
    private JunitFunction junitFunction;

    @Test
    public void testAdd() {
        double num = junitFunction.add();
        System.out.println(num);
        Assert.assertEquals(3.0, num, 1.0);
    }
}
