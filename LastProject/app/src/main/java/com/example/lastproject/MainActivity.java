package com.example.lastproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;

import com.example.lastproject.customer.CusFragment;
import com.example.lastproject.emp.EmpFragment;
import com.example.lastproject.last.CommonAskTask;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView btm_nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btm_nav = findViewById(R.id.btn_nav);

        getSupportFragmentManager().beginTransaction().replace(R.id.container, new CusFragment()).commit();

        btm_nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.menu_cus){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new CusFragment()).commit();
                }else if(item.getItemId() == R.id.menu_emp){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new EmpFragment()).commit();
                }
                return true;
            }
        });
        // Fragment <= FragmentManager


        /*CommonAskTask askTask = new CommonAskTask("home",this);
        askTask.excuteAsk(new CommonAskTask.AsynckTaskCallback() {
            @Override
            public void onResult(String data, boolean isResult) {
                Log.d("테스트", "onResult: " + data);
            }
        });
*/
    }
}