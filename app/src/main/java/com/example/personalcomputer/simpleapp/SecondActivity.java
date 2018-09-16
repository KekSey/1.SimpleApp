package com.example.personalcomputer.simpleapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView textMsgView = findViewById(R.id.text_msg_view);
        textMsgView.setText(getIntent().getStringExtra("KEY_TEXT_MSG"));
        //Вывод сообщения с форматными данными ???
        //textMsgView.setText(getString(R.string.user_text_msg, "KEY_TEXT_MSG"));
    }

    //Хорошая практика реализации Intent'а на запуск второго Activity
    public static void start(Activity activity, String textMsg) {
        Intent intent = new Intent(activity, SecondActivity.class);
        intent.putExtra("KEY_TEXT_MSG", textMsg);
        activity.startActivity(intent);
    }
}
