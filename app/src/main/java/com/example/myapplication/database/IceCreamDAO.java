package com.example.myapplication.database;

import io.requery.Entity;
import io.requery.Generated;
import io.requery.Key;
import io.requery.Persistable;

@Entity
public interface IceCreamDAO extends Persistable{

    @Key
    @Generated
    int getId();

    String getML();

    Float getPrice();

    Boolean getIsCheck();

    String getFlavorOne();

    String getFlavorTow();

    String getSyrup();
}
