package com.example.localmunkapps.bajerbook.DataFiles;

import com.example.localmunkapps.bajerbook.Database.DatabaseController;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;

/**
 * Created by marti on 11-04-2018.
 */

public class DataMain implements Serializable {

    private static DataMain instans;
    public String userGUID;
    public boolean sub;
    public SystemData systemData;
    public UserData userData;
    private DatabaseController databaseController;

    private DataMain(){
        systemData = null;
        userData = null;
    }

    public static DataMain getInstans(){
        if(instans == null){
            instans = new DataMain();
        }
        return instans;
    }

    public String generateUserKey(){
        String out = UUID.randomUUID().toString();
        System.out.println("SE HER     " + out);
        return out;
    }

    public SystemData getSystemData(){
        if(systemData == null){
            systemData = databaseController.getSystemData();
        }
        return systemData;
    }

    public UserData getUserData(String userGUID){
        if(userData == null){
            userData = databaseController.getUserData(userGUID);
        }
        return userData;
    }
}