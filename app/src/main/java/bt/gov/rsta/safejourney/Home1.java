package bt.gov.rsta.safejourney;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by user on 11/8/2017.
 */

public class Home1 extends AppCompatActivity {

    ListView listView;
    String [] list = {"Emergency", "Complaint", "First Aids", "Safety Tips", "Traffic Offences"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home1);


    /*@Nullable
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.activity_home1,container,false);
        listView= rootView.findViewById(R.id.listView);
        ArrayAdapter adapter = new ArrayAdapter(this.getApplicationContext(),android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),list[position], Toast.LENGTH_SHORT).show();
                Activity activity = null;

                switch(position)
                {
                    case 0:
                        activity = new Emergency();
                        break;

                    case 1:
                        activity = new Complaint();
                        break;

                    case 2:
                        activity = new FirstAids();
                        break;

                    case 3:
                        activity = new SafetyTips();
                        break;

                    case 4:
                        activity = new TrafficOffences();
                        break;

                    default:
                        break;

                }
            }
        });
        }
        return rootView;
        */
        ListAdapter listAdapter = new CustomAdapter(this, list);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String list = String.valueOf(parent.getItemAtPosition(position));
                Toast.makeText(Home1.this, list, Toast.LENGTH_LONG).show();
                /*Activity activity = null;

                switch(position)
                {
                    case 0:
                        activity = new Emergency();
                        break;

                    case 1:
                        activity = new Complaint();
                        break;

                    case 2:
                        activity = new FirstAids();
                        break;

                    case 3:
                        activity = new SafetyTips();
                        break;

                    case 4:
                        activity = new TrafficOffences();
                        break;

                    default:
                        break;

                }*/
            }
        });
    }

}