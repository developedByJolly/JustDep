package com.example.gioele.depone.activities;

import android.text.TextUtils;
import android.widget.TextView;

public class Utilities {
    private static final int PASSWORD_LENGHT=6;

    public static boolean emaiStatus=false;
    public static boolean passwordStatus=false;
    public static boolean phoneStatus=false;

    public static boolean checkStatus(){
        return true; // just for debug
        /*
        if(emaiStatus==true&&passwordStatus==true){
            return true;
        }
        else{return false;}
        */
    }
    public static void isPswdValid(TextView password){
         /*   if(password.getText().length()<PASSWORD_LENGHT){
            passwordStatus=false;
        }
        else {passwordStatus=true;}
        */
    }
    public static void isEmailValid(TextView email) {
        /*
        if( android.util.Patterns.EMAIL_ADDRESS.matcher(email.getText()).matches()){
            emaiStatus=true;
        }
        else{emaiStatus=false;}
        */
    }
    public static void isPhoneValid(TextView phone) {
        if (TextUtils.isEmpty(phone.getText())) {
            phoneStatus=false;
        } else if(android.util.Patterns.PHONE.matcher(phone.getText()).matches())
            phoneStatus=true;
        }
    }

