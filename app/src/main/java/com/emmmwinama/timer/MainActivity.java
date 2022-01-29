package com.emmmwinama.timer;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtTimer;
    TextView txtElapsed;
    Button btnReset;

    private final long startTime = 6000;
    private final long interval = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        txtTimer = (TextView) findViewById(R.id.txt_timer);
        txtElapsed = (TextView) findViewById(R.id.txt_time_elapsed);
        btnReset = (Button) findViewById(R.id.btn_reset);



        CountDownTimer countDownTimer = new CountDownTimer(startTime, interval) {
            @SuppressLint("SetTextI18n")
            @Override
            public void onTick(long l) {
                txtTimer.setText("Time: "+l/1000);
                txtElapsed.setText("TimeElapsed: "+(startTime-l)/1000);
            }

            @Override
            public void onFinish() {
                txtTimer.setText("TIMER FINISHED");
            }
        };

        countDownTimer.start();

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                countDownTimer.start();
            }
        });
    }
}