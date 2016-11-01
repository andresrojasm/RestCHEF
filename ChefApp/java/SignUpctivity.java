package com.aerojasm.restchef;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by aerojasm on 31/10/16.
 */
public class SignUpctivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }

    public void entrar(View view){
        Intent principal = new Intent(this, ChatActivity.class);
        startActivity(principal);

    }
}
