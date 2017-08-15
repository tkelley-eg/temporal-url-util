package com.egineering.temportalurlutil.domain;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class TemporalUrl {

    @Id
    private String id;

    private String firstName;
    private String lastName;
    private Date effectiveDate;
    private Date expirationDate;
    private String urlToken;

    public TemporalUrl(String firstName, String lastName, Date effectiveDate, Date expirationDate, String urlToken) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.effectiveDate = effectiveDate;
        this.expirationDate = expirationDate;
        this.urlToken = urlToken;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getUrlToken() {
        return urlToken;
    }

    public void setUrlToken(String urlToken) {
        this.urlToken = urlToken;
    }

    @Override
    public String toString() {
        return "TemporalUrl{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", effectiveDate=" + effectiveDate +
                ", expirationDate=" + expirationDate +
                ", urlToken='" + urlToken + '\'' +
                '}';
    }
}
