package bt.gov.rsta.safejourney;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableRow;
import android.widget.Toast;

/**
 * Created by user on 11/9/2017.
 */

public class EmergencyTab extends android.support.v4.app.Fragment {
    private static final String TAG ="EmergencyTab";

    TableRow rowAmb,rowFire,rowPolice;

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.emergency_layout, container, false);

        rowAmb = (TableRow) view.findViewById(R.id.rowAmb);
        rowFire = (TableRow) view.findViewById(R.id.rowFire);
        rowPolice = (TableRow) view.findViewById(R.id.rowPolice);

        rowAmb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int num=112;
                makeCall(num);
            }
        });
        rowFire.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int num=111;
                makeCall(num);
            }
        });
        rowPolice.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int num=113;
                makeCall(num);
            }
        });

        return view;
    }


    protected void makeCall(int num) {
        String phone=""+num;
        Log.i("Make call", "");
        Intent phoneIntent = new Intent(Intent.ACTION_CALL);
        phoneIntent.setData(Uri.parse("tel:" +phone));
        startActivity(phoneIntent);
    }
}
