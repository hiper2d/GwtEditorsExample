package com.hiper2d.client.domain;


import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.ProxyFor;
import com.hiper2d.server.domain.Car;
import com.hiper2d.server.locator.CarLocator;

import java.util.List;

@ProxyFor(value = Car.class, locator = CarLocator.class)
public interface CarProxy extends EntityProxy {

    Long getId();
    void setId(Long id);

    String getName();
    void setName(String name);
}
