package com.aerojasm.restchef;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by aerojasm on 31/10/16.
 */
public class ChefProfile{

    private String photo, name, lastname;
    private int id;

    public ChefProfile(String pName, String pLastname, String pPhoto, int pId){
        photo = pPhoto;
        name = pName;
        lastname = pLastname;
        id = pId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

}
