package com.example.saturdayfirebase;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    EditText mName,mEmail,mComment;
    Button mbtnSave,mbtnView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mName=findViewById(R.id.edtName);
        mEmail=findViewById(R.id.edtEmail);
        mComment=findViewById(R.id.edtComment);

        mbtnSave=findViewById(R.id.btnSave);
        mbtnView=findViewById(R.id.btnView);


        mbtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String jina = mName.getText().toString();
                String arafa = mEmail.getText().toString();
                String ujumbe = mComment.getText().toString();

                Long time = System.currentTimeMillis();

                if (jina.isEmpty() || arafa.isEmpty() || ujumbe.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please Fill all Inputs", Toast.LENGTH_SHORT).show();
                } else {
                    //Send Data into DB
                    DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Maneno/" + time);
                    Item x = new Item(jina, arafa, ujumbe, String.valueOf(time));
                    ref.setValue(x).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(MainActivity.this, "Sucess", Toast.LENGTH_SHORT).show();
                            }else {
                                Toast.makeText(MainActivity.this, "Fail", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });


            }
        }
