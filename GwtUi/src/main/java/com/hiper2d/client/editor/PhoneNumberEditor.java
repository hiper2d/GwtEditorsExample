package com.hiper2d.client.editor;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.hiper2d.client.domain.PhoneNumber;

import java.util.logging.Logger;

public class PhoneNumberEditor extends Composite implements Editor<PhoneNumber> {

    private static Logger logger = Logger.getLogger("");

    interface PhoneNumberEditorUiBinder extends UiBinder<Widget, PhoneNumberEditor> {}
    private static PhoneNumberEditorUiBinder ourUiBinder = GWT.create(PhoneNumberEditorUiBinder.class);

    @UiField
    TextBox type;

    @UiField
    TextBox number;

    public PhoneNumberEditor() {
        initWidget(ourUiBinder.createAndBindUi(this));
        logger.info("Created Phone Number Editor");
    }

    public void resetValues() {
        type.setValue("");
        number.setValue("");
    }
}