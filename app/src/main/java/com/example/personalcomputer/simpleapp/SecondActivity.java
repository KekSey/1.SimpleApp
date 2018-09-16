package com.example.personalcomputer.simpleapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private TextView textMsgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //Объявление и инициализация элемента TextView
        textMsgView = findViewById(R.id.text_msg_view);
        textMsgView.setText(getIntent().getStringExtra("KEY_TEXT_MSG"));

        //Вывод сообщения с форматными данными ???
        //textMsgView.setText(getString(R.string.user_text_msg, "KEY_TEXT_MSG"));

        //Объявление и инициализация элемента Button
        Button buttonEmail = findViewById(R.id.btn_email);
        //Создание обработчика событий OnClickListener()
        buttonEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Вызов информационного pop-up в случае отсутствия необходимого почтового приложения
                Toast.makeText(SecondActivity.this, "No Email app found", Toast.LENGTH_SHORT).show();
                //sendMail();
            }
        });
    }

    //Хорошая практика реализации Intent'а на запуск второго Activity
    public static void start(Activity activity, String textMsg) {
        Intent intent = new Intent(activity, SecondActivity.class);
        intent.putExtra("KEY_TEXT_MSG", textMsg);
        activity.startActivity(intent);
    }

    //Объявление метода sendMail()
    private void sendMail() {
        String recipient = "nagaaoffmail@gmail.com";
        String subject = "check@check.com";
        String message = textMsgView.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, recipient);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);

        intent.setType("message/rfc822");
        startActivity(intent.createChooser(intent, "Choose an email client"));
    }
}
