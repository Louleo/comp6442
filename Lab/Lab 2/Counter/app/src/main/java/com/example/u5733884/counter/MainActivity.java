package com.example.u5733884.counter;

import android.databinding.DataBindingUtil;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.example.u5733884.counter.databinding.ActivityMainBinding;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {

//    @Override
    private ActivityMainBinding binding;
    private int value = 0;
    private String valuetostring;
    private void updateUI(final int value)
    {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                binding.textView.setText(Integer.toString(value));
            }
        }) ;
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        binding.buttonClick.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                value = value + 1;
                valuetostring = String.valueOf(value);
                binding.textView.setText(valuetostring);
            }
        });

        binding.buttonClick.setOnLongClickListener(new View.OnLongClickListener(){

            @Override
            public boolean onLongClick(View v) {
                final Timer timer = new Timer();
                timer.schedule(new TimerTask(){
                    @Override
                    public void run() {
                    if (binding.buttonClick.isPressed()){
                        final int newvalue = value+1;
                        value = newvalue;
                        updateUI(newvalue);
                    }else{
                        timer.cancel();
                    }
                    }
                },1000,1000);

                return true;
            }
        });

        binding.buttonReset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                value = 0;
                binding.textView.setText(null);
            }
        });
    }

}
