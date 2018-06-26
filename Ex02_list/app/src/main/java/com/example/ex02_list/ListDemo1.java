package com.example.ex02_list;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

// ListActivity : 리스트뷰가 포함된 화면
public class ListDemo1 extends ListActivity {

    TextView txtResult;
    String[] items = { "사과", "포도", "레몬", "수박", "바나나", "체리" };

    // Alt + Insert

    /**
     *
     * @param l         : ListView는 배열이라고 생각할 것
     * @param v         : ListView 중에서 어떤 View를 눌렀는 지
     * @param position  : 리스트뷰에서 선택한 아이템의 인덱스 값
     * @param id
     */
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        txtResult.setText("좋아하는 과일: " + items[position]);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list1);

        // list1.xml에 선언된 TextView와 연결됨
        txtResult = (TextView) findViewById(R.id.txtResult);

        // 어댑터 생성(배열을 집합 뷰로 변환시키는 변환기)
        // new ArrayAdapter(컨텍스트, 레이아웃파일, 배열)
        // android.R.layout 안드로이드 내장 R 클래스
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);

        // 리스트뷰에 어댑터가 적용됨(데이터 바인딩 처리됨)
        setListAdapter(adapter);
    }
}
