package com.acutecoder.bertqa.newone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    Button mark;
    private DatabaseReference mdatabaseReference;
    ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mark = findViewById(R.id.mark);
        mdatabaseReference = FirebaseDatabase.getInstance().getReference();

        mark.setOnClickListener(view -> {
//            String mlogin = login.getText().toString();
//            mdatabaseReference.child(mlogin).setValue("present");
//            Toast.makeText(MainActivity.this, "ATTEDANCE MARKED", Toast.LENGTH_SHORT).show();
            EditText email = findViewById(R.id.email), password = findViewById(R.id.login);
            FirebaseAuth auth = FirebaseAuth.getInstance();
            auth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            startActivity(new Intent(this, MainActivity3.class));
                            finish();
                        } else
                            Toast.makeText(this, Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                    });
        });

    }

    public void second(View V) {
        Intent i = new Intent(this, MainActivity2.class);
        startActivity(i);
    }


    @Override

    public void onBackPressed() {

        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Are you sure want to exit");
        builder.setCancelable(true);
        builder.setPositiveButton("YES", (dialogInterface, i) -> finish());
        builder.setNegativeButton("NO!", (dialogInterface, i) -> dialogInterface.cancel());
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

    public void re(View V) {
        Intent i = new Intent(this, MainActivity2.class);
        startActivity(i);
    }

}
