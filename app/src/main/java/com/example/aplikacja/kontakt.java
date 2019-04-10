package com.example.aplikacja;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class kontakt extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kontakt_activity);
    }
public void fejsbuk(View view){
    Intent fejsbukintent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/krzysztof.gryka.1"));
    startActivity(fejsbukintent);
    }
    public void emajl(View view) {

String emaillist[] = {"krzysio580196@gmail.com"};
Intent intent = new Intent(Intent.ACTION_SEND);
intent.setType("message/rfc822");
intent.putExtra(Intent.EXTRA_EMAIL, emaillist);
intent.putExtra(Intent.EXTRA_SUBJECT, "Pytanie");
startActivity(Intent.createChooser(intent, "Wybierz mejla"));
        }
    }
