package bt.gov.rsta.safejourney;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by user on 11/9/2017.
 */

public class ComplaintTab extends android.support.v4.app.Fragment {
    private static final String TAG ="EmergencyTab";

    @Nullable
    public View onCreateVIew(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.complaint_layout, container, false);

        return view;
    }
}
