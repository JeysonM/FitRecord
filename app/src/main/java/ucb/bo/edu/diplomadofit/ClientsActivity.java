package ucb.bo.edu.diplomadofit;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

public class ClientsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Realm myRealm;
    private Integer clientCount = 0;

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
                clientCount++;
                if(clientCount == 5){
                    notificacionInterna();
                }
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



    public void notificacionInterna() {
        Intent i = new Intent(this, ClientsActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, i, PendingIntent.FLAG_ONE_SHOT);

        Uri sonido = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        android.support.v4.app.NotificationCompat.Builder notification = new NotificationCompat.Builder(this)

                .setContentTitle("FitRecord")
                .setContentText("Felicidades tienes 5 clientes Registrados!")
                .setSound(sonido)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                ;

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, notification.build());


    }
}
