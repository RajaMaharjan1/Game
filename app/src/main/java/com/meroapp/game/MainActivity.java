package com.meroapp.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
private Button btnR, btnL, btnNew;
private TextView tv;
int random1, random2, total=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnR = findViewById(R.id.btnRt);
        btnL = findViewById(R.id.btnLt);
        btnNew = findViewById(R.id.btnNew);

        btnR.setOnClickListener(this);
        btnL.setOnClickListener(this);
        btnNew.setOnClickListener(this);


        Gen_Ran(btnR, btnL);
        tv = findViewById(R.id.result);



    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnLt:
                Check(btnR, btnL);
                Score();
                break;

            case R.id.btnRt:
                Check(btnL, btnR);
                Score();

            case R.id.btnNew:
                tv.setText("");
                total= 0;
                btnR.setEnabled(true);
                btnL.setEnabled(true);
                Gen_Ran(btnR, btnL);
                break;
        }

    }

    private void Gen_Ran(Button b1, Button b2) {
        random1 = new Random().nextInt(100) + 1;
        random2 = new Random().nextInt(100) + 1;
        b1.setText(String.valueOf(random1));
        b2.setText(String.valueOf(random2));
    }

    public void Check(Button b1, Button b2) {
        if (Integer.parseInt(b1.getText().toString()) > Integer.parseInt(b2.getText().toString())) {
            Gen_Ran(btnR, btnL);
            total++;
            tv.setText("Point " + (total));
        } else {
            Gen_Ran(btnR, btnL);
            total--;
            tv.setText("Point " + total);
        }
    }
    public void Score() {
        if (total == 10) {
            tv.setText("You Win");
            btnR.setEnabled(false);
            btnL.setEnabled(false);
           // btnNew.setVisibility(View.VISIBLE);
        } else if (total == -10) {
            tv.setText("You lose");
            btnR.setEnabled(false);
            btnL.setEnabled(false);
           // btnNew.setVisibility(View.VISIBLE);
        }
    }


    }

