package com.hiper2d.client.editor;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;
import com.hiper2d.client.domain.CarProxy;

public class RemoteCarEditor extends Composite implements Editor<CarProxy> {

    interface RemoteCarEditorUiBinder extends UiBinder<Widget, RemoteCarEditor> {}
    private static RemoteCarEditorUiBinder ourUiBinder = GWT.create(RemoteCarEditorUiBinder.class);

    @Ignore
    @UiField
    Label id;

    @UiField
    TextBox name;


    public RemoteCarEditor() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }

    public void resetValues() {
        name.setValue("");
    }
}
