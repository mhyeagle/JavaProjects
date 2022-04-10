package ES.Lucene.SimpleProject.webProj.service;

import ES.Lucene.SimpleProject.webProj.http.HttpHandler;
import org.eclipse.jetty.server.Server;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        applicationContext.start();

        Server server = new Server(8080);
        server.setHandler(new HttpHandler(applicationContext));
        server.start();
    }
}
