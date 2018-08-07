package com.corock.ex15_preference;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.support.annotation.Nullable;

// PreferenceActivity: 환경설정 화면 전용 클래스
public class EditPreferences extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // preferences.xml 파일을 읽어서 뷰로 변환
        // 뷰로 변환하는 과정에서(파일을 읽는 과정에서) 오류가 발생할 수 있으므로 트랜잭션 처리
        getFragmentManager()
                .beginTransaction()
                .replace(android.R.id.content, new MyFragment())
                .commit();
    }

    // inner class; PreferenceFragment를 상속받음
    public static class MyFragment extends PreferenceFragment {
        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            // 환경설정 레이아웃 파일 res/xml/preferences.xml을 불러옴
            addPreferencesFromResource(R.xml.preferences);
        }
    }   // end of class MyFragment

}
