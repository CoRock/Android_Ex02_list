package com.example.ex02_list;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PhonebookActivity extends AppCompatActivity {

    // 변수 선언
    TextView txtResult;
    ListView list;
    List<PhonebookDTO> items;
    Uri number;     // 전화번호 변수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 화면 레이아웃 파일 지정
        setContentView(R.layout.list2);

        txtResult = (TextView) findViewById(R.id.txtResult);
        list = (ListView) findViewById(R.id.list);
        items = new ArrayList<PhonebookDTO>();
        items.add(new PhonebookDTO("김철수", "010-111-2222"));
        items.add(new PhonebookDTO("홍철수", "010-222-3333"));
        items.add(new PhonebookDTO("박철호", "010-333-4444"));
        items.add(new PhonebookDTO("김영희", "010-444-5555"));

        // 커스텀 어댑터 생성
        // new 어댑터(출력 화면, 아이템의 레이아웃 파일, 원본 데이터)
        MyAdapter adapter = new MyAdapter(this, R.layout.phonebook, items);
        list.setAdapter(adapter);
    }

    // ArrayAdapter를 상속받은 커스텀 어댑터 작성
    class MyAdapter extends ArrayAdapter<PhonebookDTO> {

        // 생성자를 오버라이드 해야 함
        public MyAdapter(
                @NonNull Context context, int resource, @NonNull List<PhonebookDTO> objects) {
            super(context, resource, objects);
        }

        /** getView: 각각의 뷰를 붙여주는 메서드
         *
         * @param position      : 몇 번째
         * @param convertView   : 만든 뷰
         * @param parent        : 상위
         * @return
         */
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View v = convertView;

            // 첫 번째 아이템일 때만 생성
            if (v == null) {
                // 레이아웃 생성기; '안드로이드에 내장되어 있는 레이아웃을 생성하는 시스템 객체;
                LayoutInflater li = (LayoutInflater) getLayoutInflater();
                v = li.inflate(R.layout.phonebook, null);
            }

            final PhonebookDTO dto = items.get(position);
            // 'findViewById(x) --> v.findVIewById(o)
            TextView txtName = (TextView) v.findViewById(R.id.txtName);
            TextView txtTel = (TextView) v.findViewById(R.id.txtName);

            txtName.setText(dto.getName());
            txtName.setText(dto.getTel());

            // 리스트뷰의 child view에 이벤트
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Intent.ACTION_CALL : 안드로이드의 내장 액티비티(전화걸기 화면)
                    // Uri.parse(스트링) : 스트링을 uri 형식으로 변환
                    // tel : 전화번호 --> 전화번호 형식; ex. tel: 010-111-2222
//                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel: " + dto.getTel()));

                    // API level 23, 6.0(마시멜로) 이전 vs. 이후
//                    startActivity(intent);
                    number = Uri.parse("tel: " + dto.getTel());
                    check();
                }
            });

            return v;   // convertView를 리턴
        }
    }   // end of inner class

    void check() {
        // 전화걸기 권한이 있는 지 확인
        if(checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // 권한 설정이 왜 필요한 지에 대한 설명(선택적)
            if(shouldShowRequestPermissionRationale(Manifest.permission.CALL_PHONE)) {
                Toast.makeText(PhonebookActivity.this, "CALL_PHONE", Toast.LENGTH_SHORT).show();
            }
            // 사용자에게 권한을 요청하는 팝업이 뜸
            requestPermissions(new String[] { Manifest.permission.CALL_PHONE }, 1);
        } else {    // 전화걸기 권한이 있을 경우
            Intent intent = new Intent(Intent.ACTION_CALL, number);
            startActivity(intent);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {      // 요청 코드
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    check();
                    Log.d("test", "ok");
                } else {
                    Log.d("test", "Permission deny");
                }
        }
    }   // end of onRequestPermissionsResult method

}   // end of main class