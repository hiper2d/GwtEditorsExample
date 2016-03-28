package com.hiper2d.client.editor;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

/**
 * Created by nodi on 24.01.16.
 */
public class EmployeeEditor<T> extends Composite implements Editor<T> {

    interface EmployeePanelUiBinder extends UiBinder<Widget, EmployeeEditor> {}
    private static EmployeePanelUiBinder ourUiBinder = GWT.create(EmployeePanelUiBinder.class);

    @UiField
    @Path(value = "name")
    TextBox employeeName;

    @UiField
    @Path(value = "title")
    TextBox employeeTitle;

    @Ignore
    Long id;

    public EmployeeEditor() {
        initWidget(getAndBindUi());
    }

    public void resetValues() {
        employeeName.setValue("");
        employeeTitle.setValue("");
    }

    protected Widget getAndBindUi() {
        return ourUiBinder.createAndBindUi(this);
    }
}