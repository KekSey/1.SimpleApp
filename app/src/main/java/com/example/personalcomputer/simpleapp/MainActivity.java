package com.example.personalcomputer.simpleapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText textMsg;
    private EditText textClone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Инициализация EditText'а
        textMsg = findViewById(R.id.text_msg);

        Button btnPreview = findViewById(R.id.btn_preview);
        btnPreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEmpty(textMsg)) {
                    //Вызов информационного pop-up в случае отсутствия текста в поле ввода
                    Toast.makeText(MainActivity.this, "Your message is empty", Toast.LENGTH_SHORT).show();
                } else {
                    openSecondActivity();
                }
            }
        });
    }

    public void openSecondActivity() {
        SecondActivity.start(this, textMsg.getText().toString());
    }

    //Метод проверки элементов EditText на отсутствие текста (возвращает boolean)
    public static boolean isEmpty(EditText editText) {
        boolean isEmptyResult = false;
        if (editText.getText().length() == 0) {
            isEmptyResult = true;
        }
        return isEmptyResult;
    }
}
