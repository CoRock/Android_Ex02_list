package com.example.ex02_list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListArray extends AppCompatActivity {

    // 위젯들은 멤버변수로 올려놓는 것이 좋음; 다른 메서드에서 사용하게끔
    ListView list;
    EditText edit1;
    Button button1;
    List<String> items;
    ArrayAdapter<String> adapter;

// case 2: public class ListArray extends AppCompatActivity implements View.OnClickListener
//    @Override
//    public void onClick(View v) {
//        String str = edit1.getText().toString();
//        items.add(str);
//
//        adapter.notifyDataSetChanged();
//    }
//      ...
//      button1.setOnClickListener(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_array);

        list = (ListView) findViewById(R.id.list);
        edit1 = (EditText) findViewById(R.id.edit1);
        button1 = (Button) findViewById(R.id.button1);

        // 리스트 생성
        items = new ArrayList<String>();
        items.add("사과");    items.add("포도");    items.add("파인애플");
        items.add("체리");    items.add("자두");

        // 어댑터 생성
        // new ArrayAdapter<자료형>(출력 화면, 출력용 레이아웃 파일, 입력 데이터)
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);

        // 리스트뷰에 어댑터를 적용시킴(리스트뷰에 출력됨)
        list.setAdapter(adapter);

        // 버튼 클릭 이벤트
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 원본 데이터 --> 어댑터 --> 리스트뷰(뷰들의 집합)
                // 사용자가 입력한 값을 리스트에 추가
                String str = edit1.getText().toString();
                items.add(str);

                // 원본 데이터가 변경되었으므로 어댑터로 갱신
                adapter.notifyDataSetChanged();
            }
        });

        // 리스트를 길게 누를 때(long click)
        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                // 삭제
                items.remove(position);

                // 어댑터 갱신
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }

}