package bt.gov.rsta.safejourney;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * Created by user on 11/9/2017.
 */

public class Notification extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstaneState) {
        super.onCreate(savedInstaneState);
        setContentView(R.layout.activity_notification);

        TextView tView1 =(TextView) findViewById(R.id.textTitle3);
        tView1.setText("This is Notification");

        BottomNavigationView bottomNavigationView_Bar = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView_Bar);

        bottomNavigationView_Bar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        Intent intent1 = new Intent(Notification.this, Home1.class);
                        startActivity(intent1);
                        break;

                    case R.id.navigation_profile:
                        Intent intent2 = new Intent(Notification.this, Profile.class);
                        startActivity(intent2);
                        break;

                    case R.id.navigation_notification:
                        break;

                    case R.id.action_settings:
                        Intent intent4 = new Intent(Notification.this, Setting.class);
                        startActivity(intent4);
                        break;
                }
                return false;
            }
        });
    }
}