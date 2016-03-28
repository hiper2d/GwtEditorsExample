package com.hiper2d.client.message;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.Constants;

/**
 * Created by nodi on 23.01.16.
 */
public interface Messages extends Constants {

    Messages INSTANCE = GWT.create(Messages.class);

    String colon();

    @Key("label.name")
    String labelName();

    @Key("label.title")
    String labelTitle();

    @Key("label.phone.numer")
    String labelPhoneNumer();

    @Key("label.phone")
    String labelPhone();

    @Key("error.any")
    String errorAny();

    @Key("log.selected.page")
    String logSelectedPage();

    @Key("label.car")
    String labelCar();
}
