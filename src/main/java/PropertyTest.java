import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Service;

@ImportResource(locations = {"classpath:applicationContext.xml"})
public class PropertyTest {
    @Value("${name}")
    private String name;

    private static String NAME;

    @Value("${name}")
    public void setNameStatic(String name) {
        NAME = name;
    }

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(PropertyTest.class);
        application.run();
        String tName = PropertyTest.NAME;
        System.out.println(tName);
    }
}
