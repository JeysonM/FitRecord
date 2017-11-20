package ucb.bo.edu.diplomadofit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

public class ClientsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Realm myRealm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_clients);


        this.myRealm = Realm.getDefaultInstance();
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_clients);
            ArrayList<ClientofList> lista = new ArrayList<>();

            //RealmResults<Client> list = this.myRealm.where(Client.class).findAll();
            RealmResults<Client> list = this.myRealm.where(Client.class).findAll();
            for (Client u : list) {
                lista.add(new ClientofList(u.getId(),u.getName(),u.getEdad(),u.getEstatura(),u.getPeso(),u.getGrasa(),u.getImc(),u.getTelefono()));
            }
            //lista.add(new ClientofList("sdasd","Jose",22,33f,55f,33f,55f));
            ClientListAdapter userListAdapter = new ClientListAdapter(lista);
            this.recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
            this.recyclerView.setAdapter(userListAdapter);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            this.recyclerView.setLayoutManager(linearLayoutManager);



    }

    public void clickAdd(View view) {
        Intent Registrar = new Intent(getApplicationContext(), WelcomeActivity.class);
        startActivity(Registrar);
    }
}
