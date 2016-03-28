package com.hiper2d.shared.domain;

import java.io.Serializable;

public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long employeeId;
    private String name;
    private String title;
    private Integer version;
    private String hiddenValue;

    public Employee() {
        name = "Charles Lewis";
        title = "Manager";
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getHiddenValue() {
        return hiddenValue;
    }

    public void setHiddenValue(String hiddenValue) {
        this.hiddenValue = hiddenValue;
    }
}
