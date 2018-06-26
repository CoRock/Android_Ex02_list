package com.example.ex02_list;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ProductActivity extends AppCompatActivity {

    // 변수 선언
    TextView txtResult;
    ListView list;
    List<ProductDTO> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // list2.xml을 화면 레이아웃 파일로 사용
        setContentView(R.layout.list2);

        txtResult = (TextView) findViewById(R.id.txtResult);
        list = (ListView) findViewById(R.id.list);
        items = new ArrayList<>();

        // ProductDTO 배열에 임의의 자료 입력
        ProductDTO[] dtos = new ProductDTO[50];

        for (int i = 0; i < dtos.length; i++) {
            dtos[i] = new ProductDTO("상품" + i, i * 10000);
        }

        // 어댑터 생성
        MyAdapter adapter = new MyAdapter(this, R.layout.product, items);
        list.setAdapter(adapter);
    }

    // @NonNull : null 값을 허용하지 않음
    // @Nullable : null 값 허용
    // @LayoutRes : 레이아웃 리소스의 아이디

    // 내부 클래스
    class MyAdapter extends ArrayAdapter<ProductDTO> {
        // constructor
        public MyAdapter(@NonNull Context context,
                         @LayoutRes int resource, @NonNull List<ProductDTO> objects) {
            super(context, resource, objects);
        }

        // getView()
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View v = convertView;

            // 첫 화면만 레이아웃 생성기로 생성
            if (v == null) {
                LayoutInflater li = (LayoutInflater) getLayoutInflater();
                v = li.inflate(R.layout.product, null);
            }

            // ArrayList의 자료를 product.xml에 출력
            final ProductDTO dto = items.get(position);

            // 자식 뷰.findViewById()   : 자식 뷰에서 검색
            // cf. findViewById()       : 메인 뷰에서 검색
            TextView txtProductName = (TextView) v.findViewById(R.id.txtProductName);
            TextView txtPrice = (TextView) v.findViewById(R.id.txtPrice);
            txtProductName.setText(dto.getProductName());
            txtPrice.setText(dto.getPrice() + "원");

            // 이벤트 처리
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String str = "상품명: " + dto.getProductName() + ", "
                            + "가격: " + dto.getPrice();
                    txtResult.setText(str);
                }
            });
            return v;
        }
    }

}