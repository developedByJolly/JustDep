package com.example.gioele.depone.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.gioele.depone.R;

public class RegisterActivity extends AppCompatActivity {
    Intent intent;
    TextView emailTv;
    TextView emailConfirm;
    TextView password;
    Button reginsterBtn;
    EditText phone;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reginster_activity);
        phone = findViewById(R.id.phone);
        emailTv=findViewById(R.id.email);
        emailConfirm=findViewById(R.id.emailconfirm);
        password = findViewById(R.id.password);
        reginsterBtn=findViewById(R.id.reginster);

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
}
