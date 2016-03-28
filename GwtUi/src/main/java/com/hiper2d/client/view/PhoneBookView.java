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
import com.hiper2d.client.domain.Employee;
import com.hiper2d.client.domain.PhoneBook;
import com.hiper2d.client.domain.PhoneNumber;
import com.hiper2d.client.editor.ExtendedEmployeeEditor;
import com.hiper2d.client.editor.PhoneBookEditor;
import com.hiper2d.client.editor.PhoneNumberEditor;
import com.hiper2d.client.message.Messages;

import java.util.logging.Level;
import java.util.logging.Logger;

public class PhoneBookView extends Composite implements PhoneBookEditor {

    private static Logger logger = Logger.getLogger("");

    public static final String RESET_EMPLOYEE_BUTTON = "resetEmployeeButton";
    public static final String SAVE_EMPLOYEE_BUTTON = "saveEmployeeButton";
    public static final String FETCH_EMPLOYEE_BUTTON = "fetchEmployeeButton";

    interface PhoneBookViewUiBinder extends UiBinder<Widget, PhoneBookView> {}
    private static PhoneBookViewUiBinder ourUiBinder = GWT.create(PhoneBookViewUiBinder.class);

    interface Driver extends SimpleBeanEditorDriver<PhoneBook, PhoneBookEditor> {}
    Driver driver = GWT.create(Driver.class);

    private PhoneBook phoneBook;

    @UiField
    ExtendedEmployeeEditor employeeEditor;

    @UiField
    PhoneNumberEditor phoneNumberEditor;

    public PhoneBookView() {
        logger.log(Level.INFO, "Created PhoneBook View");
        initWidget(ourUiBinder.createAndBindUi(this));
        initPhoneBookDriver();
    }

    private void initPhoneBookDriver() {
        phoneBook = new PhoneBook();
        phoneBook.setEmployee(new Employee());
        phoneBook.setPhoneNumber(new PhoneNumber());
        driver.initialize(this);
        driver.edit(phoneBook);
    }

    @Override
    public ExtendedEmployeeEditor employee() {
        return employeeEditor;
    }

    @Override
    public PhoneNumberEditor phoneNumber() {
        return phoneNumberEditor;
    }

    @UiHandler(RESET_EMPLOYEE_BUTTON)
    void onClickReset(ClickEvent e) {
        employeeEditor.resetValues();
        phoneNumberEditor.resetValues();
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
        driver.edit(phoneBook);
    }
}