package com.example.it.sqlitedatabase;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
       MyDBHelper daHelper;
    EditText edId,edFirstName,edLaseName,edAddress,edSalary;
    Button Insert,Delete,Update,LoadAll;
    TextView tvfinaldata;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        daHelper = new MyDBHelper(MainActivity.this);
        init();


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
    private  void init(){
        edId  =(EditText)findViewById(R.id.etID);
        edFirstName=(EditText)findViewById(R.id.etfirstname);
        edLaseName=(EditText)findViewById(R.id.etlastname);
        edAddress=(EditText)findViewById(R.id.etaddress);
        edSalary=(EditText)findViewById(R.id.etsalary);
        Insert=(Button)findViewById(R.id.button);
        Delete=(Button)findViewById(R.id.button2);
        Update=(Button)findViewById(R.id.button3);
        LoadAll=(Button)findViewById(R.id.button4);
        tvfinaldata=(TextView)findViewById(R.id.textView) ;
        Insert.setOnClickListener(dbButtonListener);
        Delete.setOnClickListener(dbButtonListener);
        Update.setOnClickListener(dbButtonListener);
        LoadAll.setOnClickListener(dbButtonListener);
    }


    private View.OnClickListener dbButtonListener = new View.OnClickListener(){
      @Override
     public void onClick(View v){
           switch (v.getId()){
               case R.id.button:
                   long result = daHelper.insert(-1,getValue(edFirstName),getValue(edLaseName),getValue(edAddress),
                           Double.valueOf(getValue(edSalary)));
                   if (result == -1){
                       Toast.makeText(MainActivity.this,"Some error Occur", Toast.LENGTH_SHORT).show();
                   }
                   else {
                       Toast.makeText(MainActivity.this, "Data Inserted succefully, ID: " + result, Toast.LENGTH_SHORT).show();
                   }
                   break;
               case R.id.button2:
                   break;
               case R.id.button3:
                   break;
               case R.id.button4:
                   break;
           }
       }
    };

    private String getValue (EditText edittext) {
        return edittext.getText().toString().trim();
    }


    @Override
    protected void onStart() {
        super.onStart();
        daHelper.closeDB();
    }

    @Override
    protected void onStop() {
        super.onStop();
        daHelper.closeDB();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
