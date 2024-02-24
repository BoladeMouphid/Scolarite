package sn.esmt.scolarite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import sn.esmt.scolarite.http.Api;
import sn.esmt.scolarite.http.EtudiantResponse;

public class InscriptionActivity extends AppCompatActivity {
    private EditText nom;
    private EditText prenom;
    private EditText addresse;
    private EditText telephone;
    private Button retourbt;
    private EditText fraisDeScolarite;
    private Button inscriptionbt;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        nom = (EditText) findViewById(R.id.nom);
        prenom = (EditText) findViewById(R.id.prenom);
        addresse = (EditText) findViewById(R.id.addresse);
        telephone = (EditText) findViewById(R.id.telephone);
        fraisDeScolarite = (EditText) findViewById(R.id.fraisScolarite);
        inscriptionbt = (Button) findViewById(R.id.inscriptionbt);
        retourbt = (Button) findViewById(R.id.retourbt);


        inscriptionbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://10.0.2.2:8082")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Api api = retrofit.create(Api.class);

                //creation d'un objet etudiant a ajouter dans la base

                EtudiantResponse e = new EtudiantResponse();
                e.setNom(nom.getText().toString());
                e.setPrenom(prenom.getText().toString());
                e.setAdr(addresse.getText().toString());
                e.setTel(Integer.parseInt(telephone.getText().toString()));
                e.setFrais(Double.parseDouble(fraisDeScolarite.getText().toString()));

                //apel de l'api
                Call<EtudiantResponse> callSave = api.saveEtudiant(e);
                callSave.enqueue(new Callback<EtudiantResponse>() {
                    @Override
                    public void onResponse(Call<EtudiantResponse> call, Response<EtudiantResponse> response) {
                        Toast.makeText(InscriptionActivity.this,
                                "etudiant inscrit avec succes", Toast.LENGTH_LONG).show();

                    }

                    @Override
                    public void onFailure(Call<EtudiantResponse> call, Throwable t) {
                        Toast.makeText(InscriptionActivity.this,
                                "impossible d'acceder au serveur", Toast.LENGTH_LONG).show();

                    }
                });

            }
        });






    }
}