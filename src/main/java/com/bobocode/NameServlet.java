package com.bobocode;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/name")
public class NameServlet extends HttpServlet {

    private final String SPRING_CONTEXT_ATTRIBUTE = "SPRING_APP_CONTEXT";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        AnnotationConfigApplicationContext context = (AnnotationConfigApplicationContext) req.getServletContext()
                .getAttribute(SPRING_CONTEXT_ATTRIBUTE);
        NameProvider nameProvider = context.getBean(NameProvider.class);
        PrintWriter writer = resp.getWriter();
        writer.println(nameProvider.getName());
    }

    @Override
    public void init(ServletConfig config) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.bobocode");
        config.getServletContext().setAttribute(SPRING_CONTEXT_ATTRIBUTE, context);
    }

}
