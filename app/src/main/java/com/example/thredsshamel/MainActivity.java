package com.example.thredsshamel;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.example.thredsshamel.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
boolean iscolore=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread thread=new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for(long i=0 ;i<1000000;i++){
                            long f=i;
                            if (i%700 ==0){
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
binding.counterTv.setText(String.valueOf(f));
                                    }
                                });
                            }
                        }


                    }
                });
                thread.start();
            }
        });
binding.changebtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        if(iscolore==true){
            binding.getRoot().setBackgroundColor(Color.parseColor("#FFFFFFFF"));
iscolore=false;
        }else {
            binding.getRoot().setBackgroundColor(Color.parseColor("#FFBB86FC"));
iscolore=true;
        }
    }
});
    }
}