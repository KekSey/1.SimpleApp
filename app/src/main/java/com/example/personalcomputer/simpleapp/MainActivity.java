package com.example.personalcomputer.simpleapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText textMsg;
    EditText textClone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Инициализация EditText'ов
        textMsg = findViewById(R.id.text_msg);
        textClone = findViewById(R.id.text_clone);

        Button btnPreview = findViewById(R.id.btn_preview);
        btnPreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //textClone.setText(textMsg.getText().toString());
                openSecondActivity();
            }
        });
    }

    public void openSecondActivity() {
        SecondActivity.start(this, textMsg.getText().toString());
    }
}
