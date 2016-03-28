package com.hiper2d.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.hiper2d.client.layout.MainLayoutPanel;
import com.hiper2d.client.message.HistoryToken;
import com.hiper2d.client.message.Messages;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by nodi on 23.01.16.
 */
public class Ui implements EntryPoint, ValueChangeHandler<String> {

    private static Logger logger = Logger.getLogger("");

    private MainLayoutPanel mainLayoutPanel;

    public void onModuleLoad() {
        mainLayoutPanel = new MainLayoutPanel();
        RootLayoutPanel.get().add(mainLayoutPanel);
        setupHistory();
    }

    public void onValueChange(ValueChangeEvent<String> valueChangeEvent) {
        String page = valueChangeEvent.getValue().trim();
        logger.log(Level.ALL, Messages.INSTANCE.logSelectedPage() + " " + page);
        switch (page) {
            case HistoryToken.EMPLOYEE: mainLayoutPanel.showEmployeeView(); break;
            case HistoryToken.PHONE_BOOK: mainLayoutPanel.showPhoneBookView(); break;
            case HistoryToken.CAR: mainLayoutPanel.showCarView(); break;
            default: mainLayoutPanel.showEmployeeView();
        }
    }

    private void setupHistory() {
        // Make this class your history manager (see onValueChange method)
        History.addValueChangeHandler(this);
        // Handle any existing history token
        History.fireCurrentHistoryState();
    }
}
