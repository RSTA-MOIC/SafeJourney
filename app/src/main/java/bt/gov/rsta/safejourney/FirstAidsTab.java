package bt.gov.rsta.safejourney;

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

public class FirstAidsTab extends android.support.v4.app.Fragment implements View.OnClickListener {

    public FirstAidsTab(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.firstaids_layout, container, false);


        Button but1 = (Button) rootView.findViewById(R.id.buttonBone);
        Button but2 = (Button) rootView.findViewById(R.id.buttonBurn);
        Button but3 = (Button) rootView.findViewById(R.id.buttonArtificial);
        Button but4 = (Button) rootView.findViewById(R.id.buttonCuts);
        Button but5 = (Button) rootView.findViewById(R.id.buttonFaint);
        Button but6 = (Button) rootView.findViewById(R.id.buttonFood);
        Button but7 = (Button) rootView.findViewById(R.id.buttonstroke);
        Button but8 = (Button) rootView.findViewById(R.id.buttonDrown);

        but1.setOnClickListener(this);
        but2.setOnClickListener(this);
        but3.setOnClickListener(this);
        but4.setOnClickListener(this);
        but5.setOnClickListener(this);
        but6.setOnClickListener(this);
        but7.setOnClickListener(this);
        but8.setOnClickListener(this);

        return rootView;

    }

    @Override
    public void onClick(View view) {
        Fragment fragment;

        switch(view.getId()) {
            case R.id.buttonBone:
                fragment = new Fracture();
                replaceFragment(fragment);
                break;

            case R.id.buttonBurn:
                fragment = new Burns();
                replaceFragment(fragment);
                break;

            case R.id.buttonArtificial:
                fragment = new cpr();
                replaceFragment(fragment);
                break;

            case R.id.buttonCuts:
                fragment = new Cuts_and_Wounds();
                replaceFragment(fragment);
                break;

            case R.id.buttonFaint:
                fragment = new Fainting();
                replaceFragment(fragment);
                break;

            case R.id.buttonFood:
                fragment = new Food();
                replaceFragment(fragment);
                break;

            case R.id.buttonstroke:
                fragment = new heat();
                replaceFragment(fragment);
                break;

            case R.id.buttonDrown:
                fragment = new drown();
                replaceFragment(fragment);
                break;
        }
    }

    public void replaceFragment(Fragment someFragment) {
        android.support.v4.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_constraint, someFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
