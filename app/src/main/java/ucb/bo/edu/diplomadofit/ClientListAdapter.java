package ucb.bo.edu.diplomadofit;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import io.realm.Case;
import io.realm.RealmResults;

/**
 * Created by USER on 17/11/2017.
 */

public class ClientListAdapter extends RecyclerView.Adapter<ClientListAdapter.ClientListViewHolder>{

    private ArrayList<ClientofList> lista;

    public static class ClientListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
         TextView txtNombre;
         TextView txtCorreo;
         TextView txtTelefono;
         ImageButton imageButton;
        Context context;

        public ClientListViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            txtNombre = (TextView) itemView.findViewById(R.id.txt_correo);
            txtCorreo =( TextView) itemView.findViewById(R.id.txt_nombre);
            txtTelefono = (TextView) itemView.findViewById(R.id.txt_telefono);
            imageButton =(ImageButton) itemView.findViewById(R.id.imageButton);
        }

        void setOnClickListeners()
        {
            imageButton.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.imageButton:
                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse("tel: "+ txtTelefono.getText().toString()));
                    v.getContext().startActivity(callIntent);
                    break;
            }
        }
    }

    public ClientListAdapter(ArrayList<ClientofList> lista) {
        this.lista = lista;
    }

    @Override
    public ClientListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_client, parent, false);
        return new ClientListAdapter.ClientListViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ClientListViewHolder holder, int position) {
        final ClientofList usuario = lista.get(position);
        holder.txtNombre.setText(usuario.getName());
        holder.txtCorreo.setText(Float.toString(usuario.getPeso()));
        holder.txtTelefono.setText(usuario.getTelefono());
        holder.setOnClickListeners();
    }

    @Override
    public int getItemCount() {
        return this.lista.size();
    }

}


