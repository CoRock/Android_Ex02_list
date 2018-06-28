package com.example.ex04_file;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

// 안드로이드에 내장되어 있는 라이브러리
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

// Java 자체 라이브러리
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class ResourceActivity extends AppCompatActivity {

    ListView list1;
    List<String> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resource);

        list1 = (ListView) findViewById(R.id.list1);
        items = new ArrayList<>();

        try {
            // res/raw/words.xml 파일을 읽을 입력 스트림 생성
            // getResources() : res 디렉토리
            // openRawResource() : raw 디렉토리의 리소스
            InputStream is = getResources().openRawResource(R.raw.words);

            // DocumentBuilderFactory가 --> DocumentBuilder 생성 --> Document 생성
            DocumentBuilder bulider = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = bulider.parse(is, null);        // xml 분석기

            // word 태그를 모두 선택함
            NodeList words = doc.getElementsByTagName("word");      // 태그 리스트
            for (int i = 0; i < words.getLength(); i++) {
                items.add(((Element)words.item(i)).getAttribute("value"));
            }

            is.close();     // 스트림 닫기
        } catch (Exception e) {
            e.printStackTrace();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, items);
        list1.setAdapter(adapter);
    }

}