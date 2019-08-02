package com.example.rpwebsites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
Spinner spn1;
Spinner spn2;
Button btnGo;
ArrayList<String> alNumbers;
ArrayAdapter<String> aaNumbers;
WebView wvMyPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spn1 = findViewById(R.id.spnCategory);
        spn2 = findViewById(R.id.spnSubCategory);
        btnGo = findViewById(R.id.button);


        alNumbers = new ArrayList<>();
        //Create an ArrayAdapter using the default Spinner layout and the ArrayList
        aaNumbers = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, alNumbers);

        //Bind the ArrayAdapter to the spinner
        spn2.setAdapter(aaNumbers);
        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                switch (position) {
                    case 0:
                        alNumbers.clear();
                        //Get the string-array and store as an Array
                        String[] strNumbers = getResources().getStringArray(R.array.subCategory);

                        //Convert Array to List and add to the ArrayList
                        alNumbers.addAll(Arrays.asList(strNumbers));
                        aaNumbers.notifyDataSetChanged();
                        spn2.setSelection(2);
                        break;
                    case 1:
                        alNumbers.clear();
                        //Get the string-array and store as an Array
                        String[] strNumbers1 = getResources().getStringArray(R.array.subCategory2);

                        //Convert Array to List and add to the ArrayList
                        alNumbers.addAll(Arrays.asList(strNumbers1));
                        aaNumbers.notifyDataSetChanged();
                        spn2.setSelection(1);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,SecondActivity1.class);
            if(spn1.getSelectedItemPosition() == 0){
                if(spn2.getSelectedItemPosition() == 0){
                    intent.putExtra("url", "https://www.rp.edu.sg/");
                }
                else if(spn2.getSelectedItemPosition() == 1){
                    intent.putExtra("url", "https://www.rp.edu.sg/student-life");
                }
            }else if(spn1.getSelectedItemPosition() == 1){
                if(spn2.getSelectedItemPosition() == 0){
                    intent.putExtra("url", "https://www.rp.edu.sg/soi/full-time-diplomas/details/r47");
                }
                else if(spn2.getSelectedItemPosition() == 1){
                    intent.putExtra("url","https://www.rp.edu.sg/soi/full-time-diplomas/details/r12");

                }
            }

            startActivity(intent);

            }
        });

    }
}
