package com.example.gioele.depone.activities.services;

import android.app.VoiceInteractor;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class RestController {

    private final static String BASE_URL = "http://138.68.86.70/";
    private final static  String VERSIONN="v1/";

    private RequestQueue queque;
    public RestController(Context context){
        queque= Volley.newRequestQueue(context);
    }

    public void getRequest(String endpoint, Response.Listener<String> succes,Response.ErrorListener error){
        StringRequest request = new StringRequest(Request.Method.GET,
                BASE_URL.concat(endpoint),
                succes,
                error
        );
        queque.add(request);
    }
}
