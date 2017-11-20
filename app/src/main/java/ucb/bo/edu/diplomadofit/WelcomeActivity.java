package ucb.bo.edu.diplomadofit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmResults;

public class WelcomeActivity extends AppCompatActivity {
    private Realm myRealm;
    private EditText nombre;
    private EditText peso;
    private EditText edad;
    private EditText estatura;
    private EditText grasa;
    private EditText imc;
    private EditText telefono;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
          this.myRealm = Realm.getDefaultInstance();
         // myRealm.deleteAll();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    public void clickGuardar(View view) {
        nombre = (EditText)findViewById(R.id.editTextNombre);
        peso = (EditText)findViewById(R.id.editTextPeso);
        edad = (EditText)findViewById(R.id.editTextEdad);
        estatura  = (EditText)findViewById(R.id.editTextEstatura);
        grasa = (EditText)findViewById(R.id.editTextGrasa);
        imc = (EditText)findViewById(R.id.editTextIMC);
        telefono = (EditText)findViewById(R.id.editTextTelefono);
        if ((nombre.getText().toString()).matches("") || (peso.getText().toString()).matches("")
                || (edad.getText().toString()).matches("") || (estatura.getText().toString()).matches("") ||
                (grasa.getText().toString()).matches("") || (imc.getText().toString()).matches("") ||
                (telefono.getText().toString()).matches("")) {
            Toast.makeText(this, "Necesita llenar todo el Formulario", Toast.LENGTH_SHORT).show();
        }else
        {
            this.myRealm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    Client cliente = realm.createObject(Client.class, UUID.randomUUID().toString());
                    cliente.setName(nombre.getText().toString());
                    cliente.setEdad(Integer.parseInt(edad.getText().toString()));
                    cliente.setGrasa(Float.valueOf(grasa.getText().toString()));
                    cliente.setEstatura(Float.valueOf(estatura.getText().toString()));
                    cliente.setImc(Float.valueOf(imc.getText().toString()));
                    cliente.setPeso(Float.valueOf(peso.getText().toString()));
                    cliente.setTelefono(telefono.getText().toString());
                }
            });

//        RealmResults<Client> list = this.myRealm.where(Client.class).findAll();
//        for (Client u : list) {
//            System.out.println(u.getId() + " Nombre " + u.getName());
//        }
            Intent ListClientes = new Intent(getApplicationContext(), ClientsActivity.class);
            startActivity(ListClientes);
        }

    }

}
