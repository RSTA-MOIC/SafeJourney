package bt.gov.rsta.safejourney;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 11/9/2017.
 */

public class ComplaintTab extends android.support.v4.app.Fragment {

    private static final String TAG ="EmergencyTab";

    Spinner selectComplaint;
    EditText location, vecNo, headingTo, description,email;
    Button submit;
    String text;
    private RequestQueue requestQueue;
    private static final String URL = "http://172.23.23.161/SafeJourney/android/regComplaint.php";
    private StringRequest request;

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.complaint_layout, container, false);

        selectComplaint = (Spinner) view.findViewById(R.id.complaintsSelect);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.complaintsSelect, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource((android.R.layout.simple_spinner_dropdown_item));
        selectComplaint.setAdapter(adapter);

        location = (EditText) view.findViewById(R.id.location);
        vecNo = (EditText) view.findViewById(R.id.vecNo);
        headingTo = (EditText) view.findViewById(R.id.headingTo);
        description = (EditText) view.findViewById(R.id.description);
        email=(EditText) view.findViewById(R.id.emailComp);
        text = ((Spinner) view.findViewById(R.id.complaintsSelect)).getSelectedItem().toString();

        submit = (Button) view.findViewById(R.id.complaintSubmit);
        requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(email.length()==0 || location.length()==0 || vecNo.length()==0){
                    Toast.makeText(getActivity().getApplicationContext(),"Please fill all fields and press register",Toast.LENGTH_LONG).show();
                }else{
                    request = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonobject = new JSONObject(response);
                                if (jsonobject.names().get(0).equals("success")) {
                                    Toast.makeText(getActivity().getApplicationContext(),jsonobject.getString("success"),Toast.LENGTH_LONG).show();
                                    startActivity(new Intent(getActivity().getApplication(),Home.class));
                                }
                                if(jsonobject.has("invalid")){
                                    Toast.makeText(getActivity().getApplicationContext(),""+jsonobject.getString("invalid"),Toast.LENGTH_LONG).show();
                                }
                                if(jsonobject.has("missingParam")){
                                    Toast.makeText(getActivity().getApplicationContext(),""+jsonobject.getString("missingParam"),Toast.LENGTH_LONG).show();
                                }
                                if(jsonobject.has("error")){
                                    Toast.makeText(getActivity().getApplicationContext(),""+jsonobject.getString("error"),Toast.LENGTH_LONG).show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    }) {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            HashMap<String, String> hashMap = new HashMap<String, String>();
                            hashMap.put("email", email.getText().toString());
                            hashMap.put("type", selectComplaint.getSelectedItem().toString());
                            hashMap.put("location", location.getText().toString());
                            hashMap.put("vno", vecNo.getText().toString());
                            hashMap.put("headto", headingTo.getText().toString());
                            hashMap.put("description", description.getText().toString());

                            return hashMap;
                        }
                    };
                    requestQueue.add(request);
                }
            }
        });

        return view;
    }

}