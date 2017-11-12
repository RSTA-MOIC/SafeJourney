package bt.gov.rsta.safejourney;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * Created by user on 11/9/2017.
 */

public class Home1 extends AppCompatActivity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstaneState) {
        super.onCreate(savedInstaneState);
        setContentView(R.layout.activity_home1);

        BottomNavigationView bottomNavigationView_Bar = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView_Bar);

        bottomNavigationView_Bar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        Intent intent1 = new Intent(Home1.this, Home.class);
                        startActivity(intent1);
                        break;

                    case R.id.navigation_profile:
                        Intent intent2 = new Intent(Home1.this, Profile.class);
                        startActivity(intent2);
                        break;

                    case R.id.navigation_notification:
                        Intent intent3 = new Intent(Home1.this, Notification.class);
                        startActivity(intent3);
                        break;

                    case R.id.action_settings:
                        Intent intent4 = new Intent(Home1.this, Setting.class);
                        startActivity(intent4);
                        break;
                }
                return false;
            }
        });
    }
}
