package com.jonsix.demoform.data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "r_saved_request")
public class SavedRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name ="created")
    private Date created;

    @Column(name ="request_type")
    private String requestType;

    @Column(name ="policy_number")
    private String policyNumber;

    @Column(name ="name")
    private String name;

    @Column(name ="surname")
    private String surname;

    @Column(name ="request")
    private String request;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

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
