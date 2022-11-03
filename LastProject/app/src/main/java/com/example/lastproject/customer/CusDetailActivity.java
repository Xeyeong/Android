package com.example.lastproject.customer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lastproject.R;
import com.example.lastproject.last.CommonAskTask;
import com.google.gson.Gson;

public class CusDetailActivity extends AppCompatActivity {
    EditText edt_name, edt_addr, edt_phone;
    RadioGroup rdo_grp;
    TextView tv_info;
    Button cancel, save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cus_detail);
        Intent intent = getIntent();
        CustomerVO vo = (CustomerVO) intent.getSerializableExtra("vo");

        tv_info = findViewById(R.id.tv_info);
        edt_name = findViewById(R.id.edt_name);
        edt_addr = findViewById(R.id.edt_addr);
        edt_phone = findViewById(R.id.edt_phone);
        rdo_grp = findViewById(R.id.rdo_grp);
        save = findViewById(R.id.save);
        cancel = findViewById(R.id.cancel);


        tv_info.setText(vo.getName() + "님 고객정보");

        edt_name.setText(vo.getName());
        edt_addr.setText(vo.getAddr());
        edt_phone.setText(vo.getPhone());

        if (vo.getGender().equals("남")) {
            RadioButton rdo_btn = (RadioButton) rdo_grp.getChildAt(0);
            rdo_btn.setChecked(true);
        } else {
            RadioButton rdo_btn = (RadioButton) rdo_grp.getChildAt(1);
            rdo_btn.setChecked(true);
        }
        boolean isEnable = intent.getBooleanExtra("isEnable", false);

            edt_name.setEnabled(isEnable);
            edt_phone.setEnabled(isEnable);
            edt_addr.setEnabled(isEnable);
            rdo_grp.setEnabled(isEnable);
            if(!isEnable){  //상세보기로 들어왔을때 저장버튼 자체가 안보이게 막
                save.setVisibility(View.GONE);
            }
            cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        // Android에서 요청 => Spring (data) => 응답 Android
        //현 save => Android에서 요청 (데이터를 전송"vo") => Spring (update) => 응답 Android
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                vo.setAddr(edt_addr.getText()+"");
                vo.setPhone(edt_phone.getText()+"");

                CommonAskTask askTask = new CommonAskTask("update.cu", CusDetailActivity.this);
                askTask.addParam("vo", new Gson().toJson(vo));
                askTask.excuteAsk(new CommonAskTask.AsynckTaskCallback() {
                    @Override
                    public void onResult(String data, boolean isResult) {
                        if(isResult && data.equals("화긴")){
                            finish();
                        }else{
                            Toast.makeText(CusDetailActivity.this, "실패", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });

    }
}



