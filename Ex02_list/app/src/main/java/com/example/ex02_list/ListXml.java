package com.example.ex02_list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListXml extends AppCompatActivity {

    TextView txtResult;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 현재 액티비티의 화면 레이아웃 파일 설정
        // '아까 만든 걸 재탕; 레이아웃 파일은 여러 곳에서 공유 가능
        setContentView(R.layout.list2);

        txtResult = (TextView) findViewById(R.id.txtResult);
        list = (ListView) findViewById(R.id.list);

        // R.array.배열변수명 : xml에 저장된 배열 데이터를 불러옴
        // createFromResource(출력 화면, 배열 데이터 파일, 개별 값 출력 레이아웃 파일)
        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(this, R.array.fruit,
                        android.R.layout.simple_list_item_1);
        list.setAdapter(adapter);

        // xml 배열의 내용을 ArrayList로 저장
        // getResource() 리소스(res)
        // getStringArray(배열 변수명)
        final List<String> items = Arrays.asList(getResources().getStringArray(R.array.fruit));
        /* 'final을 붙이지 않으면 에러!
            items = new ArrayList<String>();
            items.add("hello");
            items.add("android");
         */

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 내부 클래스에서 '로컬' 변수에 접근할 경우 final로 선언해야 함
                txtResult.setText(items.get(position));
            }
        });
    }

}