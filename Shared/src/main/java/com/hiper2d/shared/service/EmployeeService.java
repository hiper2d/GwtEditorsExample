package com.hiper2d.shared.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.hiper2d.shared.domain.Employee;

@RemoteServiceRelativePath("employees")
public interface EmployeeService extends RemoteService {
    Employee getEmployee(Long id);
}
