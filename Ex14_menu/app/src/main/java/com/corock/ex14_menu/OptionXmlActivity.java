package com.corock.ex14_menu;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

// menu.xml 파일에서 메뉴항목을 읽어서 메뉴를 구현
public class OptionXmlActivity extends ListActivity {

    // 멤버변수
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
        this.setListAdapter(adapter);
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

        // xml 파일을 읽어서 메뉴 아이템들을 전개시키는 코드
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.menu, menu);

        return true;    // 메뉴가 표시
    }

    /**
     * onOptionsItemSelected(): 옵션 메뉴의 아이템을 선택했을 때
     *
     * @param item
     * @return false: 아무 동작을 하지 않음
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // 선택한 메뉴 아이템의 값이 item에 복사
        // item.getItemId(): 선택한 메뉴의 아이디
        switch (item.getItemId()) {
            // 리스트뷰 구분선의 두께 조절
            case R.id.menu1:
                getListView().setDividerHeight(5);
                return true;
            case R.id.menu2:
                getListView().setDividerHeight(15);
                return true;
            case R.id.menu3:
                getListView().setDividerHeight(25);
                return true;
            case R.id.menu4:
                getListView().setDividerHeight(35);
                return true;
            case R.id.menu5:
                getListView().setDividerHeight(45);
                return true;
            default:
                return false;
        }
    }

}