package com.example.gioele.depone.activities.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;

import com.example.gioele.depone.R;
import com.example.gioele.depone.activities.Utilities;

public class LoginActivity extends AppCompatActivity  {

    Button loginButton;
    Button reginsterBtn;
    Switch colorBtn;
    EditText email;
    EditText password;
    LinearLayout ll;
    private static final int PASSWORD_LENGHT=6;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        reginsterBtn = findViewById(R.id.reginsterButton);
        loginButton = findViewById(R.id.loginButton);
        ll= findViewById(R.id.ll);
        colorBtn = (Switch) findViewById(R.id.colorbtn);

       colorBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               if(isChecked){  ll.setBackgroundColor(getResources().getColor(R.color.sfondoSwitch));}
               else{ll.setBackgroundColor(getResources().getColor(R.color.ColorDark));}
           }
       });


        loginButton.setEnabled(true);//per debug
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
               Utilities.isPswdValid(password);
            }

            @Override
            public void afterTextChanged(Editable s) {
               if(Utilities.checkStatus()){
                   loginButton.setEnabled(true);
               }
               else {loginButton.setEnabled(false);}

            }
        });
        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Utilities.isEmailValid(email);
            }

            @Override
            public void afterTextChanged(Editable s) {
                Utilities.checkStatus();
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RestaurantListActivity.class);
                startActivity(intent);

            }
        });
        reginsterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                String em = email.getText().toString();
                intent.putExtra("email",em);
                startActivity(intent);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        return true;
    }
    


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.login){
            startActivity(new Intent(this, RegisterActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

