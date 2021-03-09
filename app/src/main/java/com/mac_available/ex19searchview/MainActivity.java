package com.mac_available.ex19searchview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SearchView searchview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar, menu);

        //searchview를 가진 menuitem객체를 얻어와서
        //searhview 참조를 해야함
        MenuItem item = menu.findItem(R.id.menu_search);
        searchview = (SearchView) item.getActionView();

        //힌트 설정하기
        searchview.setQueryHint("input word");

        //소프트키패드의 검색버튼(돋보기모양)을 클릭하는 것을
        //듣는 리스너 추가..(검색창에 글씨변경을 듣는 리스너);
        searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(MainActivity.this, "question"+query, Toast.LENGTH_SHORT).show();
                return false;
            }

            //글씨가 변경될 때 마다 발동하는 메소
            @Override
            public boolean onQueryTextChange(String newText) {

                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}