package com.hiper2d.client.editor;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.hiper2d.shared.domain.Employee;

public class ExtendedEmployeeEditor extends EmployeeEditor<Employee> {
    interface ExtendedEmployeeEditorUiBinder extends UiBinder<Widget, ExtendedEmployeeEditor> {}
    private static ExtendedEmployeeEditorUiBinder ourUiBinder = GWT.create(ExtendedEmployeeEditorUiBinder.class);

    public ExtendedEmployeeEditor() {
        super();
    }

    protected Widget getAndBindUi() {
        return ourUiBinder.createAndBindUi(this);
    }
}