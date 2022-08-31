package com.logap.app.LAPrest.controller.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "String")
public class StringModel {

    @Id
    public String string;

    public String vogal;

    public String tempoTotal;

}
