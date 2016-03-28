package com.hiper2d.server;

import com.google.web.bindery.requestfactory.server.RequestFactoryServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@SpringBootApplication
public class SpringBootApp extends SpringBootServletInitializer {

    final static Logger log = LoggerFactory.getLogger(SpringBootApp.class);

    public static void main(final String[] args) {
        SpringApplication.run(SpringBootApp.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringBootApp.class);
    }

    @Override
    public void onStartup(ServletContext container) throws ServletException {
        log.debug("Initialize RequestFactoryServlet");
        container.addServlet("/gwtRequest", RequestFactoryServlet.class);
        super.onStartup(container);
        //AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        //context.register(SpringBootApp.class);
    }
}
