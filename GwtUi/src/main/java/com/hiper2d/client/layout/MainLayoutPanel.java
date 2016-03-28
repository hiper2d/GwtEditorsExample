package com.hiper2d.client.layout;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import com.hiper2d.client.editor.EmployeeEditor;
import com.hiper2d.client.message.HistoryToken;
import com.hiper2d.client.resourcebundle.Resources;
import com.hiper2d.client.view.EmployeeView;
import com.hiper2d.client.view.PhoneBookView;
import com.hiper2d.client.view.RemoteCarView;

/**
 * Created by nodi on 23.01.16.
 */
public class MainLayoutPanel extends ResizeComposite {



    interface MainLayoutPanelUiBinder extends UiBinder<Widget, MainLayoutPanel> {}
    private static MainLayoutPanelUiBinder ourUiBinder = GWT.create(MainLayoutPanelUiBinder.class);

    @UiField
    DockLayoutPanel dockPanel;
    @UiField
    SimplePanel westContainer;
    @UiField
    SimplePanel northContainer;
    @UiField
    SimplePanel centerContainer;

    private EmployeeView employeeView;
    private PhoneBookView phoneBookView;
    private RemoteCarView carView;

    public MainLayoutPanel() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }

    @UiFactory
    public Resources loadResources() {
        Resources.INSTANCE.basic().ensureInjected();
        return Resources.INSTANCE;
    }

    public void showEmployeeView() {
        if (employeeView == null) {
            employeeView = new EmployeeView();
        }
        fillCenterPanelWithWidget(employeeView);
    }

    public void showPhoneBookView() {
        if (phoneBookView == null) {
            phoneBookView = new PhoneBookView();
        }
        fillCenterPanelWithWidget(phoneBookView);
    }

    public void showCarView() {
        if (carView == null) {
            carView = new RemoteCarView();
        }
        fillCenterPanelWithWidget(carView);
    }

    private void fillCenterPanelWithWidget(Widget widget) {
        centerContainer.setWidget(widget);
    }

    @UiHandler("employeeButton")
    public void employeeButton(ClickEvent e) {
        History.newItem(HistoryToken.EMPLOYEE);
    }

    @UiHandler("phoneBookButton")
    public void phoneBookButton(ClickEvent e) {
        History.newItem(HistoryToken.PHONE_BOOK);
    }

    @UiHandler("carButton")
    public void carButton(ClickEvent e) {
        History.newItem(HistoryToken.CAR);
    }
}