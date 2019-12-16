package ES.Lucene.SimpleProject.webProj.http;

import com.alibaba.fastjson.JSONObject;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class HttpHandler extends AbstractHandler {
    private ApplicationContext applicationContext;

    public HttpHandler(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void handle(String s, Request request, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json; charset=utf-8");
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        request.setHandled(true);

        processIndex(s, httpServletRequest, httpServletResponse);
    }

    private void processIndex(String target, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (!target.equals("/index")) {
            Map<String, String> result = new HashMap<>();
            result.put("key", "valueIndex");

            PrintWriter writer = response.getWriter();
            writer.println(JSONObject.toJSONString(result));
        }
    }
}
