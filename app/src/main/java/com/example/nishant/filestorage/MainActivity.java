package com.example.nishant.filestorage;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner s1;

    EditText email,password,state;
    Button save ;
    File file ;

    String Email,Pass,State,Country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        s1=(Spinner)findViewById(R.id.spinner);
        email = (EditText)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.Password);
        state=(EditText)findViewById(R.id.State);
        save = (Button)findViewById(R.id.button);


        final List<String> list = new ArrayList<String>();
        list.add("Select Country");
        list.add("India");
        list.add("Canada");
        list.add("USA");

        ArrayAdapter<String> spinner = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,list);

        spinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        s1.setAdapter(spinner);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Country= String.valueOf(s1.getSelectedItem());
                Email= email.getText().toString();
                Pass= password.getText().toString();
                State= state.getText().toString();

                String FileName = "Nishant_Details";

                FileOutputStream fileOutputStream ;

                String FileContents = ("Email:" + Email +" "+
                        "Password :" + Pass +" "+
                        "State :" + State +" "+
                        "Country :" + Country);

                Intent i= new Intent(MainActivity.this,Main2Activity.class);

                try {
                    fileOutputStream= openFileOutput(FileName, Context.MODE_PRIVATE);
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
                    outputStreamWriter.write(FileContents);
                    outputStreamWriter.close();
                    startActivity(i);

                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        });
    }
}
