package com.aerojasm.restchef;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.linkedin.platform.LISessionManager;
import com.linkedin.platform.errors.LIAuthError;
import com.linkedin.platform.listeners.ApiListener;
import com.linkedin.platform.listeners.AuthListener;
import com.linkedin.platform.utils.Scope;

/**
 * Created by aerojasm on 31/10/16.
 */

public class StartActivity extends AppCompatActivity{
    Button ingresar;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        ingresar = (Button) findViewById(R.id.buttonIngresar);
    }

    public void signUp(View view){
        Intent signUp = new Intent(this,SignUpctivity.class);
        startActivity(signUp);
    }

    public void signIn(View view){
        Intent signIn = new Intent(this,LoginActivity.class);
        startActivity(signIn);
    }

    public void signInLinkedin(final View view){
        LISessionManager.getInstance(getApplicationContext()).init(
                this, Scope.build(), new AuthListener() {

                    @Override
                    public void onAuthSuccess() {
                        ingresar.setVisibility(view.GONE);
                        Intent principal = new Intent(StartActivity.this, ChatActivity.class);
                        startActivity(principal);
                    }

                    @Override
                    public void onAuthError(LIAuthError error) {
                        Toast.makeText(getApplicationContext(), "Error" + error.toString(), Toast.LENGTH_LONG).show();
                    }
                }, true);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        LISessionManager.getInstance(getApplicationContext()).onActivityResult(this, requestCode, resultCode, data);
        Intent chefInfo = new Intent(this, ChefProfile.class);
        startActivity(chefInfo);
    }

    private static Scope builtScope() {
        return Scope.build(Scope.R_BASICPROFILE,Scope.R_EMAILADDRESS);
    }


}
