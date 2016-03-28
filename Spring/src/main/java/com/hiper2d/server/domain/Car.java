package com.hiper2d.server.domain;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

public class Car {

    private Long id;

    private Integer version;

    @Size(min = 2, max = 20)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
