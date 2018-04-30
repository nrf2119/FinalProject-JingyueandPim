package com.example.awos.finalproject_jingyuepim;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class AuthenticationActivity extends AppCompatActivity {
    private FirebaseAuth mrAuth;
    private EditText userNameEditText;
    private EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);

        userNameEditText = (EditText) findViewById(R.id.username);
        passwordEditText = (EditText) findViewById(R.id.password);
        mrAuth = FirebaseAuth.getInstance();

    }

    public void logIn(View view) {
        String email = userNameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        mrAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            Toast.makeText(AuthenticationActivity.this, task.getException().toString(), Toast.LENGTH_SHORT).show();
                            Log.v("Research",task.getException().toString());
                        } else {
                            Toast.makeText(AuthenticationActivity.this, task.getResult().getUser().getEmail() + " logged in successful",
                                    Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }
                });
    }

    public void signUp(View view) {
        String email = userNameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        mrAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            Toast.makeText(AuthenticationActivity.this, task.getException().toString(), Toast.LENGTH_SHORT).show();
                            Log.v("Research",task.getException().toString());
                        } else {
                            Toast.makeText(AuthenticationActivity.this, task.getResult().getUser().getEmail() + " signed up successful",
                                    Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }
                });
    }


}
