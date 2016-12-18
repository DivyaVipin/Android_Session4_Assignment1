package assignment.android.acadgild.asc_des_listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
private static ListView listViewMonth;
    private Button btnAscend;
    private Button btnDescend;
    ArrayAdapter<String> adapter;
    ArrayList<String> deslist;
    ArrayList<String> asclist;
    private static String[] NAMES={"Vidyuth","Saras","Divya","Anu","Vipin","Arjun","Zaira","Megha"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAscend=(Button)findViewById(R.id.btnAscending) ;
        btnDescend=(Button)findViewById(R.id.btnDescending) ;
        listViewMonth=(ListView)findViewById(R.id.listViewMonth);
        listViewMonth.setFastScrollEnabled(true);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, NAMES);
        listViewMonth.setAdapter(adapter);
        btnAscend.setOnClickListener(this);
        btnDescend.setOnClickListener(this);



    }


    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btnAscending:

                asclist = new ArrayList<String>(Arrays.asList(NAMES));
                Collections.sort(asclist);
                adapter = new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1, asclist);
                listViewMonth.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                break;
            case R.id.btnDescending:
                deslist = new ArrayList<String>(Arrays.asList(NAMES));
                Collections.sort(deslist, Collections.reverseOrder());
                adapter = new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1, deslist);
                listViewMonth.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                break;

            default:
                break;
        }

    }
}
