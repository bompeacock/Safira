package com.example.cong.myapplication.model;

import java.io.Serializable;

/**
 * Created by Cong on 02/09/2017.
 */

public class OrderAddress implements Serializable{
    public String street;
    public String war;
    public String district;
    public String city;
    public String country;
    public String phone;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getWar() {
        return war;
    }

    public void setWar(String war) {
        this.war = war;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean check() {

        if(street==null||street.equals("")) return false;
        if(war==null||war.equals("")) return false;
        if(district==null||district.equals("")) return false;
        if(city==null||city.equals("")) return false;
        if(country==null||country.equals("")) return false;
        if(phone==null||phone.equals("")) return false;

        return  true;
    }

    @Override
    public String toString() {
        return "Street " + street + "\n"
                + war + " / " + district + " / " + city + " / " + country +"\n"
                + "Phone: " + phone ;
    }
}
