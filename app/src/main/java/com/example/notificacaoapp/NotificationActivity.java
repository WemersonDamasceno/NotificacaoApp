package com.example.notificacaoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);


        TextView msg = (TextView)findViewById(R.id.tvSegundaActivity);
        String mensagem = getIntent().getStringExtra("mensagem");
        msg.setText(mensagem);

    }
}