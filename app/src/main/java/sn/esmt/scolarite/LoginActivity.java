package sn.esmt.scolarite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText emailtext;
    private EditText motdepassetext;
    private Button loginbt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailtext = (EditText) findViewById(R.id.email);
        motdepassetext = (EditText) findViewById(R.id.motdepasse);
        loginbt = (Button) findViewById(R.id.loginbt);

        loginbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailtext.getText().toString();
                String pwd = motdepassetext.getText().toString();
                if(email.isEmpty()|| pwd.isEmpty()){
                    Toast.makeText(LoginActivity.this,"veillez renseignez les champs", Toast.LENGTH_LONG).show();

                }
                else{
                    if(email.equals("esmt@esmt.sn") && pwd.equals("123") ){
                        Intent i = new Intent(LoginActivity.this,HomeActivity.class);
                        startActivity(i);

                    }
                    else {
                        Toast.makeText(LoginActivity.this,"Email ou mot de passe incorrecte", Toast.LENGTH_LONG).show();


                    }
                }
            }
        });

    }
}