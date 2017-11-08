package bt.gov.rsta.safejourney;

import android.app.ActivityManager;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class Home extends AppCompatActivity {


   // public BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
       //     = new BottomNavigationView.OnNavigationItemSelectedListener() {

       /* @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    transaction.replace(R.id.content, new Home1()).commit();
                    return true;
                case R.id.navigation_profile:
                    transaction.replace(R.id.content, new Profile()).commit();
                    return true;
                case R.id.navigation_notification:
                    transaction.replace(R.id.content, new Notification()).commit();
                    return true;
                case R.id.navigation_setting:
                    transaction.replace(R.id.content, new Setting()).commit();
                    return true;
            }
            return false;
        }

    };*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        BottomNavigationViewHelper.disableShiftMode(navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull  MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        break;

                    case R.id.navigation_profile:
                        break;

                    case R.id.navigation_notification:
                        break;

                    case R.id.action_settings:
                        break;
                }
                return false;
            }
        });



        //BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        //navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
