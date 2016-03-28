package com.hiper2d.shared.service;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.hiper2d.shared.domain.Employee;

public interface EmployeeServiceAsync {
    void getEmployee(Long id, AsyncCallback<Employee> asyncCallback);
}
