package com.hiper2d.server.locator;

import com.google.web.bindery.requestfactory.server.RequestFactoryServlet;
import com.google.web.bindery.requestfactory.shared.ServiceLocator;
import com.hiper2d.server.service.CarService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

public class CarServiceLocator implements ServiceLocator {

    private static CarService serviceInstance;

    public static CarService getServiceInstance() {
        if (serviceInstance == null) {
            HttpServletRequest request = RequestFactoryServlet.getThreadLocalRequest();
            ServletContext servletCtx = request.getSession().getServletContext();
            ApplicationContext springCtx = WebApplicationContextUtils.getWebApplicationContext(servletCtx);
            serviceInstance = springCtx.getBean(CarService.class);
        }
        return serviceInstance;
    }

    @Override
    public CarService getInstance(Class<?> clazz) {
        return CarServiceLocator.getServiceInstance();
    }
}
