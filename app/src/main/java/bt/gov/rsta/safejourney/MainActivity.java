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

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText edit1, edit2;
    ImageView img;
    TextView txt1, txt2, txt3, txt4;
    int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Context context1 = this, context2 = this, context3 = this, context4 = this;
        button =  (Button)findViewById(R.id.button);
        edit1 = (EditText)findViewById(R.id.editText);
        edit2 = (EditText)findViewById(R.id.editText2);
        img = (ImageView)findViewById(R.id.imageView);
        txt1 = (TextView)findViewById(R.id.textView);
        txt2 = (TextView)findViewById(R.id.textView1);
        txt3 = (TextView)findViewById(R.id.textView2);
        txt4 = (TextView)findViewById(R.id.textView3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                if(edit1.getText().toString().equals("karma") && edit2.getText().toString().equals("nakama4avr")){
                    Toast.makeText(getApplicationContext(), "Redirecting....", Toast.LENGTH_SHORT).show();
                    Intent intent1 = new Intent(context1, Home.class);
                    startActivity(intent1);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Credentials", Toast.LENGTH_SHORT).show();

                    if(counter == 0){
                        button.setEnabled(false);
                    }
                }
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
                Intent intent2 = new Intent(context2, Registry.class);
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