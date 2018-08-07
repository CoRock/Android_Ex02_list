package com.corock.ex14_menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ContextMenuActivity extends AppCompatActivity {

    EditText editName;
    Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.context_menu);

        editName = (EditText) findViewById(R.id.editName);
        btnOk = (Button) findViewById(R.id.btnOk);

        // 컨텍스트 메뉴 등록: registerForContextMenu(위젯)
        registerForContextMenu(editName);
        registerForContextMenu(btnOk);
    }

    /**
     * onCreateContextMenu(): 컨텍스트 메뉴가 생성될 때
     */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        // v : 컨텍스트 메뉴를 호출한 뷰
        if (v == editName) {
            menu.setHeaderTitle("입력메뉴");    // 메뉴 제목
            // menu.add(그룹아이디, 아이템아이디, 출력순서, 제목)
            menu.add(0, 1, 0, "번역");
            menu.add(0, 2, 0, "필기인식");
        } else if (v == btnOk) {
            menu.add(0, 3, 0, "지우기");
        }
    }

    /**
     * onContextItemSelected(): 컨텍스트 메뉴의 아이템을 선택했을 때
     */
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                Toast.makeText(this, "번역하기", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(this, "필기인식", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                editName.setText("");
                break;
        }

        return true;
    }

}