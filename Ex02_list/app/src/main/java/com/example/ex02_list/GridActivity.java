package com.example.ex02_list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class GridActivity extends AppCompatActivity {

    // 변수 선언
    TextView txtResult;
    GridView grid1;
    String[] items = { "사과", "포도", "바나나", "자두", "귤", "자몽",
            "사과", "포도", "바나나", "자두", "귤", "자몽",
            "사과", "포도", "바나나", "자두", "귤", "자몽" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid);

        txtResult = (TextView) findViewById(R.id.txtResult);
        grid1 = (GridView) findViewById(R.id.grid1);

        // 어댑터 생성
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, items);

        // 그리드뷰에 어댑터 적용
        grid1.setAdapter(adapter);

        // 이벤트 처리
        grid1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                txtResult.setText(items[position]);
            }
        });
    }

}