package com.hiper2d.server.locator;

import com.google.web.bindery.requestfactory.shared.Locator;
import com.google.web.bindery.requestfactory.shared.ServiceLocator;
import com.hiper2d.server.domain.Car;

import java.util.Date;

public class CarLocator extends Locator<Car, Long> {

    @Override
    public Car create(Class<? extends Car> clazz) {
        return new Car();
    }

    @Override
    public Car find(Class<? extends Car> clazz, Long id) {
        return null;
    }

    @Override
    public Class<Car> getDomainType() {
        return Car.class;
    }

    @Override
    public Long getId(Car domainObject) {
        return domainObject.getId();
    }

    @Override
    public Class<Long> getIdType() {
        return Long.class;
    }

    @Override
    public Object getVersion(Car domainObject) {
        return new Date();
    }
}
