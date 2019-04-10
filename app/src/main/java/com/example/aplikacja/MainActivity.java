package com.example.aplikacja;

import com.example.aplikacja.R;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button b;
    EditText et;
    EditText et2;
    TextView tv;
    Button button2;
    Button exitt;
    Button button3;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b = (Button) findViewById(R.id.button1);
        et = (EditText) findViewById(R.id.edit);
        et2 = (EditText) findViewById(R.id.edit1);
        tv = (TextView) findViewById(R.id.Out);


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = et.getText().toString();
                tv.setText(str);
            }

            private void showToastWithText(CharSequence toastText) {
                Toast.makeText(getApplicationContext(), toastText, Toast.LENGTH_LONG).show();
            }
        });

        button2 = (Button) findViewById(R.id.button2);
        exitt = (Button) findViewById(R.id.exit);
        button3 = (Button) findViewById(R.id.button3);

        button2.setOnClickListener(this);
        exitt.setOnClickListener(this);
        button3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case  R.id.button2:
                Intent intent = new Intent(this, Main2Activity.class);
                startActivity(intent);
                break;

            case R.id.exit:
                System.exit(0);
                break;

            case R.id.button3:
                Intent cos = new Intent(this, kontakt.class);
                startActivity(cos);

                break;

            default:
                break;
        }
    }
}


