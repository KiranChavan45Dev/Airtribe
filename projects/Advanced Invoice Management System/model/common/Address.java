package model.common;

import java.io.Serializable;

public class Address implements Serializable{
    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String country;

    public Address(){

    }

    public Address(String street, String city, String state, String postalCode, String country) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
    }

    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }   
    public String getPostalCode() {
        return postalCode;
    }   
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }   
    public String getCountry() {
        return country;
    }   
    public void setCountry(String country) {
        this.country = country;
    }   

    @Override
    public String toString() {
        return street + ", " + city + ", " + state + " - " + postalCode + ", " + country;
    }
}
