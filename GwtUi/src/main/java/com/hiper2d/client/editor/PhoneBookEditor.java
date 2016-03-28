package com.hiper2d.client.editor;

import com.google.gwt.editor.client.Editor;
import com.hiper2d.client.domain.PhoneBook;

public interface PhoneBookEditor extends Editor<PhoneBook> {

    ExtendedEmployeeEditor employee();
    PhoneNumberEditor phoneNumber();
}
