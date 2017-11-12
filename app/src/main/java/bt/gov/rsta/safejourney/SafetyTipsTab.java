package bt.gov.rsta.safejourney;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by user on 11/9/2017.
 */

public class SafetyTipsTab extends android.support.v4.app.Fragment implements View.OnClickListener {

    public SafetyTipsTab(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.safetytips_layout, container, false);


        Button but1 = (Button) rootView.findViewById(R.id.buttonP);
        Button but2 = (Button) rootView.findViewById(R.id.buttonB);
        Button but3 = (Button) rootView.findViewById(R.id.buttonT);
        Button but4 = (Button) rootView.findViewById(R.id.buttonF);

        but1.setOnClickListener(this);
        but2.setOnClickListener(this);
        but3.setOnClickListener(this);
        but4.setOnClickListener(this);

        return rootView;

    }

    @Override
    public void onClick(View view) {
        Fragment fragment;

        switch(view.getId()) {
            case R.id.buttonP:
                fragment = new Pedestrian();
                replaceFragment(fragment);
                break;

            case R.id.buttonB:
                fragment = new Bicycle();
                replaceFragment(fragment);
                break;

            case R.id.buttonT:
                fragment = new TWO_WHLEER();
                replaceFragment(fragment);
                break;

            case R.id.buttonF:
                fragment = new FOURWHEELER();
                replaceFragment(fragment);
                break;
        }
    }

    public void replaceFragment(Fragment someFragment) {
        android.support.v4.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frame1, someFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}