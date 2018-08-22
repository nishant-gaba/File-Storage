package com.example.nishant.filestorage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2Activity extends AppCompatActivity {

    TextView t ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        String fileText="";
        t= (TextView)findViewById(R.id.textView);
        try{
            String FileName="Nishant_Details";
            FileInputStream fileInputStream=openFileInput(FileName);
            InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
            int charcount;
            char[] inputText=new char[100];

            while((charcount=inputStreamReader.read(inputText))>0){
                fileText=fileText+String.copyValueOf(inputText,0,charcount);
            }
            inputStreamReader.close();

        }catch (IOException e){
            e.printStackTrace();
        }
        finally {
            t.setText(fileText);
        }
    }
}
