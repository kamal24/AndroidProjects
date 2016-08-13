package edu.udayton.myemailapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);

        List<String>  Attractions= Arrays.asList(getResources().getStringArray(R.array.list_of_array));
        setListAdapter(new ArrayAdapter<String>(this,R.layout.activity_main,R.id.list,Attractions));


    }


    protected void onListItemClick(ListView l, View v, int position, long id){
        Intent intent=null;
        switch(position){
            case 0:
                intent=new Intent(MainActivity.this,Email.class);
                break;

            case 1:
                intent=new Intent(MainActivity.this,Browser.class);
                break;

        }

        startActivity(intent);
    }
}
