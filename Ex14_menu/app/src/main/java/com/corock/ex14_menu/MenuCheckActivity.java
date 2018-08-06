package com.corock.ex14_menu;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MenuCheckActivity extends AppCompatActivity {

    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_check);

        txtResult = (TextView) findViewById(R.id.txtResult);
    }

    /**
     * onCreateOptionsMenu(): 옵션 메뉴 생성
     * menu_check.xml을 불러와서 옵션 메뉴 구성
     *
     * @return false: 무효 처리
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        MenuInflater inflater = getMenuInflater();
        // res/menu/menu_check.xml 파일을 읽어서 메뉴를 생성함
        inflater.inflate(R.menu.menu_check, menu);

        return true;    // 메뉴가 생성됨
    }

    /**
     * onOptionsItemSelected(): 옵션 메뉴의 아이템을 선택했을 때
     * 메뉴 아이템이 선택되었을 때의 처리
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // 선택한 메뉴 아이템의 아이디
        switch (item.getItemId()) {
            case R.id.bigfont:
                if (item.isChecked()) {         // 체크된 상태이면
                    // txtResult.setTextSize(20);  // 20sp
                    txtResult.setTextSize(TypedValue.COMPLEX_UNIT_PX, 20);
                } else {
                    // txtResult.setTextSize(40);  // 40sp
                    txtResult.setTextSize(TypedValue.COMPLEX_UNIT_PX, 40);
                }
                break;

            // 텍스트의 색상 변경
            case R.id.red:
                txtResult.setTextColor(Color.RED);
                break;
            case R.id.green:
                txtResult.setTextColor(Color.GREEN);
                break;
            case R.id.blue:
                txtResult.setTextColor(Color.BLUE);
                break;
        }

        return true;
    }

    /**
     * onPrepareOptionsMenu(): 옵션 메뉴를 출력하기 전에 실행
     */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // 폰트 사이즈가 40px이면
        if (txtResult.getTextSize() == 40) {
            menu.findItem(R.id.bigfont).setChecked(true);       // 체크
        } else {
            menu.findItem(R.id.bigfont).setChecked(false);      // 체크 해제
        }

        // 텍스트의 색상 조회
        int color = txtResult.getTextColors().getDefaultColor();
        if (color == Color.RED) {
            menu.findItem(R.id.red).setChecked(true);
        } else if (color == Color.GREEN) {
            menu.findItem(R.id.green).setChecked(true);
        } else if (color == Color.BLUE) {
            menu.findItem(R.id.blue).setChecked(true);
        }
        return true;
    }   // end of onPrepareOptionsMenu()

}