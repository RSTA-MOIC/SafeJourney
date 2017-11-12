package bt.gov.rsta.safejourney;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.android.volley.toolbox.StringRequest;
import com.android.volley.AuthFailureError;
import com.android.volley.toolbox.Volley;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.Response;

import android.widget.RadioButton;

import com.android.volley.Request;

import android.widget.RadioGroup;
import android.widget.EditText;
import android.widget.Button;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {

    private EditText name, phone, email, password, age;

    private RadioGroup gender, driver;
    String genderSend, driverSend;
    private Button register;
    private RequestQueue requestQueue;
    private static final String URL = "http://172.23.23.161/SafeJourney/android/register.php";
    private StringRequest request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Context contexRegister = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = (EditText) findViewById(R.id.regName);
        phone = (EditText) findViewById(R.id.regPhone);
        email = (EditText) findViewById(R.id.regEmail);
        password = (EditText) findViewById(R.id.regPassword);
        age = (EditText) findViewById(R.id.regAgeEnter);

        gender = (RadioGroup) findViewById(R.id.regGenderGp);
        int radioButtonID = gender.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton) gender.findViewById(radioButtonID);
        genderSend = (String) radioButton.getText();

        driver = (RadioGroup) findViewById(R.id.regDriverGp);
        int driverSelected = driver.getCheckedRadioButtonId();
        RadioButton rb = (RadioButton) driver.findViewById(driverSelected);
        driverSend = (String) rb.getText();

        register = (Button) findViewById(R.id.regButton);

        requestQueue = Volley.newRequestQueue(this);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(name.length()==0 || phone.length()==0 || email.length()==0 || password.length()==0 || age.length()==0 || phone.length() !=8 || password.length()<=6){
                    Toast.makeText(getApplicationContext(),"Please fill all fields and press register",Toast.LENGTH_LONG).show();
                }else{
                    request = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonobject = new JSONObject(response);
                                if (jsonobject.names().get(0).equals("success")) {
                                    Toast.makeText(getApplicationContext(),"Welcome\n"+jsonobject.getString("name"),Toast.LENGTH_LONG).show();
                                    startActivity(new Intent(getApplication(),RegisterSuccess.class));
                                }
                                if(jsonobject.has("exist")){
                                    Toast.makeText(getApplicationContext(),""+jsonobject.getString("exist"),Toast.LENGTH_LONG).show();
                                }
                                if(jsonobject.has("missingParam")){
                                    Toast.makeText(getApplicationContext(),""+jsonobject.getString("missingParam"),Toast.LENGTH_LONG).show();
                                }
                                if(jsonobject.has("dataError")){
                                    Toast.makeText(getApplicationContext(),""+jsonobject.getString("dataError"),Toast.LENGTH_LONG).show();
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
                            hashMap.put("name", name.getText().toString());
                            hashMap.put("phone", phone.getText().toString());
                            hashMap.put("email", email.getText().toString());
                            hashMap.put("password", password.getText().toString());
                            hashMap.put("age", age.getText().toString());
                            hashMap.put("gender", genderSend);
                            hashMap.put("driver", driverSend);

                            return hashMap;
                        }
                    };
                    requestQueue.add(request);
                }
            }
        });
    }
}
