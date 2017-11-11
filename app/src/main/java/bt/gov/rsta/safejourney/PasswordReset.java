package bt.gov.rsta.safejourney;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class PasswordReset extends AppCompatActivity {

    private EditText phone,email;
    private Button submit;
    private RequestQueue requestQueue;
    private static final String URL="http://10.0.2.2/SafeJourney/android/passwordReset.ph";
    private StringRequest request;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_reset);

        email=(EditText) findViewById(R.id.emailReset);
        phone=(EditText) findViewById(R.id.PhoneReset);
        submit = (Button) findViewById(R.id.button2);
        requestQueue = Volley.newRequestQueue(this);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(email.length()==0 || phone.length()==0 || phone.length() >=8){
                    Toast.makeText(getApplicationContext(),"Please fill all fields and submit",Toast.LENGTH_LONG).show();
                }else{
                    request = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonobject = new JSONObject(response);
                                if (jsonobject.names().get(0).equals("sent")) {
                                    Toast.makeText(getApplicationContext(),""+jsonobject.getString("name"),Toast.LENGTH_LONG).show();
                                    startActivity(new Intent(getApplication(),Home.class));
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
                            hashMap.put("phone", phone.getText().toString());
                            hashMap.put("email", email.getText().toString());

                            return hashMap;
                        }
                    };
                    requestQueue.add(request);
                }
            }
        });
    }
}
