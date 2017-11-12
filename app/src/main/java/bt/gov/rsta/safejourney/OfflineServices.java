package bt.gov.rsta.safejourney;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class OfflineServices extends AppCompatActivity {

    private static final String TAG = "Home";

    private SectionPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offline_services);

        mSectionsPagerAdapter = new SectionPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.emergency);
        tabLayout.getTabAt(1).setIcon(R.drawable.firstaids);
        tabLayout.getTabAt(2).setIcon(R.drawable.safety_icon);


        BottomNavigationView bottomNavigationView_Bar = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView_Bar);

        bottomNavigationView_Bar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        Intent intent1 = new Intent(OfflineServices.this, Home1.class);
                        startActivity(intent1);
                        break;

                    case R.id.navigation_profile:
                        Intent intent2 = new Intent(OfflineServices.this, Profile.class);
                        startActivity(intent2);
                        break;

                    case R.id.navigation_notification:
                        Intent intent3 = new Intent(OfflineServices.this, Notification.class);
                        startActivity(intent3);
                        break;

                    case R.id.action_settings:
                        Intent intent4 = new Intent(OfflineServices.this, Setting.class);
                        startActivity(intent4);
                        break;
                }
                return false;
            }
        });

    }

    private void setupViewPager(ViewPager viewPager) {
        SectionPagerAdapter adapter = new SectionPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new EmergencyTab());
        adapter.addFragment(new FirstAidsTab());
        adapter.addFragment(new SafetyTipsTab());
        viewPager.setAdapter(adapter);
    }
}