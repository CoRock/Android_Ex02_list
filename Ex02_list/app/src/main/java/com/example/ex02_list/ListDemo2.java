package com.example.ex02_list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ListDemo2 extends AppCompatActivity {

    // 1. 변수 선언
    TextView txtResult;
    ListView list;
    String[] items = { "TV", "냉장고", "세탁기", "오디오", "스마트폰" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list2);

        // 2. 리소스 연결
        txtResult = (TextView) findViewById(R.id.txtResult);
        list = (ListView) findViewById(R.id.list);

        // 3. 어댑터 생성(배열 데이터를 각각의 화면으로 변환하는 변환기)
        ArrayAdapter<String> adapter =
                // new ArrayAdapter(컨텍스트, 레이아웃 파일, 배열 데이터)
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);

        // 리스트뷰에 어댑터를 연결시킴(리스트뷰에 데이터가 채워짐)
        list.setAdapter(adapter);

        // 이벤트 처리(리스트뷰의 아이템을 클릭할 때 처리되는 코드)
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // position : 아이템의 인덱스 값(배열의 인덱스와 같음)
                txtResult.setText(items[position]);
            }
        });
    }

}
