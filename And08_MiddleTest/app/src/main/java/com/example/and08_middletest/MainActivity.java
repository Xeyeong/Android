package com.example.and08_middletest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btn = findViewById(R.id.bbb);
        btn.setOnClickListener(this);
        //btn2
        Button btn2 = findViewById(R.id.bbb2);

        btn2.setOnClickListener(new View.OnClickListener() {
            int i = 0;
            @Override
            public void onClick(View v) {

                ArrayList<ImageView> view = new ArrayList<>();
                view.add(findViewById(R.id.img3));
                view.add(findViewById(R.id.img4));
                if (i == 2)
                    i = 0;
                for (int j = 0; j < view.size(); j++) {
                    view.get(j).setVisibility(View.GONE);
                }
                view.get(i).setVisibility(View.VISIBLE);
                i++;

            }
        });

    }
    //btn1
    int i = 0;
    @Override
    public void onClick(View v) {
        ArrayList<ImageView> view = new ArrayList<>();
        view.add(findViewById(R.id.img1));
        view.add(findViewById(R.id.img2));


        if (i == 2)
            i = 0;
            for (int j = 0; j < view.size(); j++){
                view.get(j).setVisibility(View.GONE);
        }
        view.get(i).setVisibility(View.VISIBLE);
        i++;
    }

}









