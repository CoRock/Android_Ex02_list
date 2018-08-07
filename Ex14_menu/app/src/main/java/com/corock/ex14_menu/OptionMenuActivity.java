package com.corock.ex14_menu;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class OptionMenuActivity extends ListActivity {

    TextView selection;
    ListView list;
    String[] items = {"lorem", "ipsum", "dolor", "sit", "amet"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.option_menu);

        selection = (TextView) findViewById(R.id.selection);

        // 어댑터 생성: new ArrayAdapter(컨텍스트, 레이아웃, 데이터)
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, items);
        // 리스트뷰에 어댑터를 적용(리스트뷰에 자료가 출력됨)
        setListAdapter(adapter);
    }

    /**
     * onCreateOptionsMenu(): 옵션 메뉴가 만들어질 때
     *
     * @param menu
     * @return false: 메뉴 표시 안됨
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        // 메뉴그룹아이디, 메뉴아이템아이디, 출력순서, 타이틀
        // menu.add("5sp");

        menu.add(0, 1, 0, "5sp");
        menu.add(0, 2, 0, "15sp");
        menu.add(0, 3, 0, "25sp");
        menu.add(0, 4, 0, "35sp");
        menu.add(0, 5, 0, "45sp");
        menu.add(0, 6, 0, "55sp");
        menu.add(0, 7, 0, "65sp");
        menu.add(0, 8, 0, "75sp");
        return true;    // 메뉴가 표시
    }

    /**
     * onOptionsItemSelected(): 옵션 메뉴의 아이템을 선택했을 때
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // item.getItemId(): 선택한 메뉴의 아이디
        switch (item.getItemId()) {
            // 리스트뷰 구분선의 두께 조절
            case 1: getListView().setDividerHeight(5);      break;
            case 2: getListView().setDividerHeight(15);     break;
            case 3: getListView().setDividerHeight(25);     break;
            case 4: getListView().setDividerHeight(35);     break;
            case 5: getListView().setDividerHeight(45);     break;
            case 6: getListView().setDividerHeight(55);     break;
            default: return false;      // 아무 동작을 하지 않음
        }

        return true;
    }

}
