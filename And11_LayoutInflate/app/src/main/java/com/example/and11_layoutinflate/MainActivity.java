package com.example.and11_layoutinflate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {


    Button btn;
    LinearLayout li ;
    RelativeLayout rl ;

    //자바 <- 안드로이드가 어려운점 : 대부분의 기능들이 구현이 되어있음 ( == IOS )
    // 어느정도의 커스터마이징은 되지만, 그 이상은 개인정보침해나 해킹의 위험요소

    //레이아웃 인플레이트(인플레이션 과정을 통한 화면붙이기) 과정
    //1. 화면이 붙을 공간(레이아웃)을 액티비티 내부에 미리 만들어 놓는다. (현재, 리니어, 렐러티브 )
    //2. 화면에 붙일 레이아웃을 별도로 만든다. (현재, main_sub1.xml) ↑ 마련한 공간에 붙일 예정.
    //3. 자바코드를 이용해서 레이아웃 인플레이트 시키기 <= 프래그먼트(※)


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);// Layout 연결을 해놓고 나서 해당하는 레이아웃에 있는 위젯만 find 할수있다.

    btn = findViewById(R.id.btn_inflate);
    li = findViewById(R.id.ll_layout);
    rl = findViewById(R.id.rl_layout);

        // Transaction(DB) => Commit , Rollback (작업을 확정지을껀지 아니면 되돌릴건지)
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new MainFragment()).commit();

        LayoutInflater inflater = getLayoutInflater();  // OS(Android, SDK ) 에서 제공해줌.

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inflater.inflate(R.layout.main_sub1,li,true);
                //                       어떤화면을 붙일지, 어디에, 지금?
                inflater.inflate(R.layout.main_sub2,rl,true);
            }
        });

    }
}