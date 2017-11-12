package bt.gov.rsta.safejourney;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
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

public class MainActivity extends AppCompatActivity {

    Button loginButton;
    EditText email, password;
    ImageView img;
    TextView txt1, txt2, txt3, txt4;
    private RequestQueue requestQueue;
    private static final String URL = "http://172.23.23.161/SafeJourney/android/login.php";
    private StringRequest request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Context context1 = this, context2 = this, context3 = this;
        loginButton =  (Button)findViewById(R.id.button);
        email = (EditText)findViewById(R.id.loginEmail);
        password = (EditText)findViewById(R.id.loginPassword);
        img = (ImageView)findViewById(R.id.imageView);
        txt1 = (TextView)findViewById(R.id.textView);
        txt2 = (TextView)findViewById(R.id.textView1);
        txt3 = (TextView)findViewById(R.id.textView2);
        txt4 = (TextView)findViewById(R.id.textView3);

        requestQueue = Volley.newRequestQueue(this);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                startActivity(new Intent(getApplication(),Home.class));
                request = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonobject = new JSONObject(response);
                            if (jsonobject.names().get(0).equals("success")) {
                                Toast.makeText(getApplicationContext(),"Welcome\n"+jsonobject.getString("success"),Toast.LENGTH_LONG).show();
                                startActivity(new Intent(getApplication(),Home.class));
                            }
                            if(jsonobject.has("loginFail")){
                                Toast.makeText(getApplicationContext(),""+jsonobject.getString("loginFail"),Toast.LENGTH_LONG).show();
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
                        hashMap.put("password", password.getText().toString());

                        return hashMap;
                    }
                };requestQueue.add(request);
            }
        });

        txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent1 = new Intent(context1, PasswordReset.class);
                startActivity(intent1);
            }
        });

        txt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent2 = new Intent(context2, Register.class);
                startActivity(intent2);
            }
        });

        txt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent3 = new Intent(context3, OfflineServices.class);
                startActivity(intent3);
            }
        });
    }
}