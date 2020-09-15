package com.example.seekbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static SeekBar seekBar;
    private static TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSeekBar();
    }
    public void setSeekBar(){
        seekBar = (SeekBar)findViewById(R.id.seekBar);
        textView = (TextView)findViewById(R.id.textView);

        textView.setText("Covered:" +seekBar.getProgress()+ " / "+seekBar.getMax());

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress_value;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progress_value = progress;
                textView.setText("Covered:" +progress_value+ " / "+seekBar.getMax());
                Toast.makeText(MainActivity.this, "Seekbar in progress", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Seekbar in StartTracking", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textView.setText("Covered:" +progress_value+ " / "+seekBar.getMax());
                Toast.makeText(MainActivity.this, "Seekbar in StopTracking", Toast.LENGTH_SHORT).show();
            }
        });
    }
}