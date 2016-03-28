package com.hiper2d.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.hiper2d.client.editor.EmployeeEditor;
import com.hiper2d.client.editor.ExtendedEmployeeEditor;
import com.hiper2d.client.message.Messages;
import com.hiper2d.shared.domain.Employee;

public class EmployeeView extends Composite {

    public static final String RESET_EMPLOYEE_BUTTON = "resetEmployeeButton";
    public static final String SAVE_EMPLOYEE_BUTTON = "saveEmployeeButton";
    public static final String FETCH_EMPLOYEE_BUTTON = "fetchEmployeeButton";

    interface EmployeeViewUiBinder extends UiBinder<Widget, EmployeeView> { }
    private static EmployeeViewUiBinder ourUiBinder = GWT.create(EmployeeViewUiBinder.class);

    interface Driver extends SimpleBeanEditorDriver<Employee, EmployeeEditor<Employee>> {}
    Driver driver = GWT.create(Driver.class);

    @UiField
    ExtendedEmployeeEditor employeeEditor;

    private Employee employee;

    public EmployeeView() {
        employee = new Employee();
        initWidget(ourUiBinder.createAndBindUi(this));
        initEmployeeEditorDriver();
    }

    private void initEmployeeEditorDriver() {
        driver.initialize(employeeEditor);
        driver.edit(employee);
    }

    @UiHandler(RESET_EMPLOYEE_BUTTON)
    void onClickReset(ClickEvent e) {
        employeeEditor.resetValues();
    }

    @UiHandler(SAVE_EMPLOYEE_BUTTON)
    void onClickSave(ClickEvent e) {
        driver.flush();
        if (driver.hasErrors()) {
            Window.alert(Messages.INSTANCE.errorAny());

        }
    }

    @UiHandler(FETCH_EMPLOYEE_BUTTON)
    void onClickGet(ClickEvent e) {
        driver.edit(employee);
    }
}