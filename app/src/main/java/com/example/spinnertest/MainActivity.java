package com.example.spinnertest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity { //클래스를 상속받아 MainActivity 클래스를 작성한다.

    @Override
    protected void onCreate(Bundle savedInstanceState) { //onCreate 메소드의 매개변수가 앱의 이전 실행 상태를 전달한다.
        super.onCreate(savedInstanceState); //부모클래스의 onCreate를 호출한다.
        setContentView(R.layout.activity_main); //메인을 띄운다.

        Spinner spinner = (Spinner) findViewById(R.id.spinner); //spinner 정보를 받은 객체를 생성한다.
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);
        //리소스로부터 ArrayAdapter를 생성하는 메소드
        //this가 컨텍트 정보를 넘겨준다.
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //클릭하면 항목이 오픈될 때에 항목을 표시하는 뷰의 모양을 정의한다.
        spinner.setAdapter(adapter); //adapter와 연결한다.
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            //AdapterView.OnItemSelectedListener를 구현하는 무명 클래스를 생성한다.
            //-> 스피너에서 항목이 선택되었을 때 앱에 알려주는 콜백 메소드를 제공한다.
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //onItemSelected : 어댑터 뷰의 항목이 선택되는 경우에 호출한다.
                Toast.makeText(parent.getContext(),
                        "선택된 행성은 " + parent.getItemAtPosition(position).toString(),
                        Toast.LENGTH_SHORT).show();
                //선택된 텍스트를 토스트 메시지로 표시한다.
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //onNothingSelected : 어댑터 뷰에서 선택이 사라지는 경우 호출한다. 아무것도 표시되지 않는다.

            }
        });
    }
}
