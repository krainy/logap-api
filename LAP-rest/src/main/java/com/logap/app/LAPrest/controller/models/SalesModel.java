package com.logap.app.LAPrest.controller.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="item")
public class SalesModel {

    @Id
    public Integer i_code;

    @Column(nullable = false, length = 20)
    public String i_name;

    @Column(length = 10)
    public float i_value;

    @Column(length = 10)
    public String i_type;

    @Column(length = 50)
    public String i_dealer;


    public Integer getI_code() {
        return i_code;
    }

    public void setI_code(Integer i_code) {
        this.i_code = i_code;
    }

    public String getI_name() {
        return i_name;
    }

    public void setI_name(String i_name) {
        this.i_name = i_name;
    }

    public float getI_value() {
        return i_value;
    }

    public void setI_value(float i_value) {
        this.i_value = i_value;
    }

    public String getI_type() {
        return i_type;
    }

    public void setI_type(String i_type) {
        this.i_type = i_type;
    }

    public String getI_dealer() {
        return i_dealer;
    }

    public void setI_dealer(String i_dealer) {
        this.i_dealer = i_dealer;
    }
}
