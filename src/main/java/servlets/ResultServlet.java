package servlets;

import app.Fibonacci;
import freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@WebServlet(urlPatterns = "/result")
public class ResultServlet extends HttpServlet {

    private static final String TEMPLATE_NAME = "result";

    @Inject
    TemplateProvider templateProvider;

    @Inject
    Fibonacci fibonacci;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.addHeader("Content-Type", "text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();
        Map<String, Object> model = new HashMap<>();
        Map<String, Object> errorsMap = new HashMap<>();
        Template template = templateProvider.getTemplate(
                getServletContext(),
                TEMPLATE_NAME);

        Integer n;

        try {
            n = Integer.valueOf(req.getParameter("fibonacci"));
            try {
                List<Long> elementList = fibonacci.Fibonacci(n);
                Long result = elementList.get(n);

                model.put("list", elementList);
                model.put("result", result);
                model.put("n", n);
            } catch (Exception e) {
                errorsMap.put("error", "Wpisana wartość jest ujemna");
            }
        } catch (Exception e) {
            errorsMap.put("error", "Podana wartość nie jest liczbą całkowitą");
        }


        if (!errorsMap.isEmpty()) {
            model.put("errorsMap", errorsMap);
        }

        try {
            template.process(model, out);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}

