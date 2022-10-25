package com.jonsix.demoform.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class DemoForm {

    @NotNull
    private String requestType;
    @Pattern(regexp = "^$|[A-Za-z0-9]+", message = "Policy Number must be alphanumeric")
    private String policyNumber;
    @Pattern(regexp = "^$|[A-Za-z]+", message = "Name must be in letters only")
    private String name;
    @Pattern(regexp = "^$|[A-Za-z]+", message = "Surname must be in letters only")
    private String surname;
    @Size(max = 5000)
    private String request;

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }
}
