package com.hiper2d.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.requestfactory.gwt.client.RequestFactoryEditorDriver;
import com.hiper2d.client.domain.CarProxy;
import com.hiper2d.client.editor.RemoteCarEditor;
import com.hiper2d.client.message.Messages;
import com.hiper2d.client.requestfactory.Factory;
import com.hiper2d.client.requestfactory.Factory.CarRequestContext;

public class RemoteCarView extends Composite {

    public static final String RESET_EMPLOYEE_BUTTON = "resetEmployeeButton";
    public static final String SAVE_EMPLOYEE_BUTTON = "saveEmployeeButton";
    public static final String FETCH_EMPLOYEE_BUTTON = "fetchEmployeeButton";

    interface EmployeeViewUiBinder extends UiBinder<Widget, RemoteCarView> { }
    private static EmployeeViewUiBinder ourUiBinder = GWT.create(EmployeeViewUiBinder.class);

    interface Driver extends RequestFactoryEditorDriver<CarProxy, RemoteCarEditor> {}
    Driver driver = GWT.create(Driver.class);

    private CarRequestContext requestContext;
    private Factory requestFactory;

    @UiField
    RemoteCarEditor сarEditor;

    private CarProxy carProxy;

    public RemoteCarView() {
        final EventBus eventBus = new SimpleEventBus();
        requestFactory = GWT.create(Factory.class);
        requestFactory.initialize(eventBus);
        requestContext = requestFactory.createCarContext();
        carProxy = requestContext.create(CarProxy.class);

        initWidget(ourUiBinder.createAndBindUi(this));
        initEmployeeEditorDriver(eventBus);
    }

    private void initEmployeeEditorDriver(EventBus eventBus) {
        driver.initialize(eventBus, requestFactory, сarEditor);
        driver.edit(carProxy, requestContext);
    }

    @UiHandler(RESET_EMPLOYEE_BUTTON)
    void onClickReset(ClickEvent e) {
        сarEditor.resetValues();
    }

    @UiHandler(SAVE_EMPLOYEE_BUTTON)
    void onClickSave(ClickEvent e) {
        requestContext = (CarRequestContext) driver.flush();
        requestContext.fire();
        if (driver.hasErrors()) {
            Window.alert(Messages.INSTANCE.errorAny());

        }
    }

    @UiHandler(FETCH_EMPLOYEE_BUTTON)
    void onClickGet(ClickEvent e) {
        requestContext = (CarRequestContext) driver.flush();
        requestContext.sayBeep().fire();
    }
}