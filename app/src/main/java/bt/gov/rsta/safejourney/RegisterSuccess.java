package bt.gov.rsta.safejourney;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterSuccess extends AppCompatActivity {
    TextView regsucess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_success);
        final Context regSucessContex = this;
        regsucess=(TextView) findViewById(R.id.regSucess);

        regsucess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent1 = new Intent(regSucessContex, MainActivity.class);
                startActivity(intent1);
            }
        });
    }
}
