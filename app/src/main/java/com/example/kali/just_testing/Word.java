package com.example.kali.just_testing;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by kali on 10/10/17.
 */

class Word implements Serializable{
    private String AlarmName;
    private String AlarmNo;
    public int describeContents(){
        return 0;
    }



    public Word(String alname, String alno){
        AlarmName = alname;
        AlarmNo = alno;
    }

    public String getAlarmName(){
        return AlarmName;
    }
    public String getAlarmNo(){
        return AlarmNo;
    }


    }
