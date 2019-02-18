package com.example.gioele.depone.activities.Activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.gioele.depone.R;
import com.example.gioele.depone.activities.Utilities;
import com.example.gioele.depone.activities.datamodel.Resturant;
import com.example.gioele.depone.activities.services.RestController;

import java.util.HashMap;
import java.util.Map;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class RegisterActivity extends AppCompatActivity implements Response.ErrorListener, Response.Listener<String> {
    Intent intent;
    TextView emailTv;
    TextView emailConfirm;
    TextView password;
    TextView utente;
    Button reginsterBtn;
    EditText phone;

    private RestController restController;
    private Context context;
    String x= "auth/local/register";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reginster_activity);
        utente = findViewById(R.id.user);
        phone = findViewById(R.id.phone);
        emailTv=findViewById(R.id.email);
        emailConfirm=findViewById(R.id.emailconfirm);
        password = findViewById(R.id.password);
        reginsterBtn=findViewById(R.id.reginster);

        restController = new RestController(this);


        phone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Utilities.isPhoneValid(phone);
            }

            @Override
            public void afterTextChanged(Editable s) {
                Utilities.checkStatus();
            }
        });

        emailTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doImplicidIntent();
            }
        });


        reginsterBtn.setOnClickListener(new View.OnClickListener() {
            private String Semail=emailTv.toString();
            private String pwd=password.toString();
            private String user=utente.toString();


            @Override
            public void onClick(View v) {

                restController.postRequest(x,RegisterActivity.this,RegisterActivity.this,Semail,pwd,user);
            }
        });

        intent = getIntent();
            final String email = intent.getStringExtra("email");
            emailTv.setText(email);

        password.addTextChangedListener(new TextWatcher() {
                                            @Override
                                            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                                            }

                                            @Override
                                            public void onTextChanged(CharSequence s, int start, int before, int count) {
                                               if( Utilities.checkStatus() ){
                                                   reginsterBtn.setEnabled(true);
                                               }
                                               else{reginsterBtn.setEnabled(false);}
                                            }

                                            @Override
                                            public void afterTextChanged(Editable s) {

                                            }
                                        }
        );
    }
    public void doImplicidIntent(){
        Uri uri = Uri.parse("mailto:"+emailTv.getText());
        Intent intento = new Intent(Intent.ACTION_SENDTO,uri);
        startActivity(intento);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        //Log.e("response",error.getMessage());
        Toast.makeText(this, "response error"+error.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResponse(String response) {
        Toast.makeText(this, "iscrizione effettuata", Toast.LENGTH_SHORT).show();
        Log.e("response",response);
    }






}
