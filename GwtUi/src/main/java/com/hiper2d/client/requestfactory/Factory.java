package com.hiper2d.client.requestfactory;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.RequestFactory;
import com.google.web.bindery.requestfactory.shared.Service;
import com.hiper2d.server.locator.CarServiceLocator;
import com.hiper2d.server.service.CarService;

public interface Factory extends RequestFactory {

    CarRequestContext createCarContext();

    @Service(value = CarService.class, locator = CarServiceLocator.class)
    public interface CarRequestContext extends RequestContext {
        Request<String> sayBeep();
    }
}
