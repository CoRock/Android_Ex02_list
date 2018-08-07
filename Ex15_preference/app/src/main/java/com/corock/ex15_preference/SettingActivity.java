package com.corock.ex15_preference;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SettingActivity extends AppCompatActivity {

    TextView checkbox, ringtone, txtScreen;
    EditText text;
    Button btnOk;
    SharedPreferences prefs;    // 환경설정 정보 접근 클래스

    /**
     * onCreate(): 생성
     * cf. onStart(): 준비
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);

        checkbox = (TextView) findViewById(R.id.checkbox);
        ringtone = (TextView) findViewById(R.id.ringtone);
        txtScreen = (TextView) findViewById(R.id.screen);
        text = (EditText) findViewById(R.id.text);
        btnOk = (Button) findViewById(R.id.btnOk);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 환경설정 편집기 객체 생성
                SharedPreferences.Editor edit = prefs.edit();
                // 에디터객체.put자료형("변수명", "변경할 값")
                edit.putString("text", text.getText().toString());
                edit.commit();      // 커밋을 해야 xml 파일에 저장됨
                Toast.makeText(getApplicationContext(),
                        "환경설정값이 변경되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * onResume(): 재시작
     */
    @Override
    protected void onResume() {
        super.onResume();

        // 환경설정 관리자 객체
        prefs = PreferenceManager.getDefaultSharedPreferences(this);

        // 환경설정.get자료형("변수명", "기본값")
        float font_size = Float.parseFloat(prefs.getString("font", "10"));

        // TypedValue.COMPLEX_UNIT_단위
        ringtone.setTextSize(TypedValue.COMPLEX_UNIT_SP, font_size);
        checkbox.setTextSize(TypedValue.COMPLEX_UNIT_SP, font_size);
        txtScreen.setTextSize(TypedValue.COMPLEX_UNIT_SP, font_size);

        // Color.parseColor(스트링) 스트링을 Color 자료형으로 변환
        /*
            흰색을 표현하는 방법:
            1) Color.WHITE
            2) Color.parseColor("#ffffff")
        */
        String color = prefs.getString("font_color", "#ff0000");
        checkbox.setTextColor(Color.parseColor(color));
        ringtone.setTextColor(Color.parseColor(color));
        txtScreen.setTextColor(Color.parseColor(color));

        // 체크박스 체크 여부
        boolean ch = prefs.getBoolean("checkbox", false);
        checkbox.setText(ch + "");
        boolean screenCheck = prefs.getBoolean("screenOn", false);
        txtScreen.setText(screenCheck + "");

        // <unset>: EditPreference 태그에 값이 입력되지 않은 경우
        String ring = prefs.getString("ringtone", "<unset>");
        ringtone.setText(ring);

        // 화면 조명 유지 옵션
        if (screenCheck) {
            getWindow().addFlags((WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON));
        }

        String str = prefs.getString("text", "");
        text.setText(str);
    }   // end of onResume()

    /**
     * onCreateOptionsMenu(): 옵션 메뉴 생성
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 메뉴 생성; 메뉴를 클릭하면 환경설정 화면으로 이동
        menu.add("환경설정").setIntent(new Intent(this, EditPreferences.class));

        return super.onCreateOptionsMenu(menu);
    }   // end of onCreateOptionsMenu()

}