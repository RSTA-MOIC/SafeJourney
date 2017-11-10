package bt.gov.rsta.safejourney;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class Home extends AppCompatActivity {

    private static final String TAG = "Home";

    private SectionPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mSectionsPagerAdapter = new SectionPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.emergency);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_complaint_black_24dp);
        tabLayout.getTabAt(2).setIcon(R.drawable.firstaids);
        tabLayout.getTabAt(3).setIcon(R.drawable.safety_icon);
        tabLayout.getTabAt(4).setIcon(R.drawable.trafficoffence);

        BottomNavigationView bottomNavigationView_Bar = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView_Bar);

        bottomNavigationView_Bar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        Intent intent1 = new Intent(Home.this, Home1.class);
                        startActivity(intent1);
                        break;

                    case R.id.navigation_profile:
                        Intent intent2 = new Intent(Home.this, Profile.class);
                        startActivity(intent2);
                        break;

                    case R.id.navigation_notification:
                        Intent intent3 = new Intent(Home.this, Notification.class);
                        startActivity(intent3);
                        break;

                    case R.id.action_settings:
                        Intent intent4 = new Intent(Home.this, Setting.class);
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
        adapter.addFragment(new ComplaintTab());
        adapter.addFragment(new FirstAidsTab());
        adapter.addFragment(new SafetyTipsTab());
        adapter.addFragment(new TrafficOffencesTab());
        viewPager.setAdapter(adapter);
    }
}

/*import android.app.ActivityManager;
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

   /* @Override
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

}*/
