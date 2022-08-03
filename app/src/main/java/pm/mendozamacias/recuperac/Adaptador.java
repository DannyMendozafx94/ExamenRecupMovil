package pm.mendozamacias.recuperac;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adaptador
        extends RecyclerView.Adapter<Adaptador.CatsViewHolder>{

    List<Cats> listaCats;

    public Adaptador(List<Cats> listaCats) {
        this.listaCats = listaCats;
    }

    @NonNull
    @Override
    public Adaptador.CatsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new Adaptador.CatsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptador.CatsViewHolder holder, int position) {
        holder.tv_id.setText("ID: " +listaCats.get(position).getId());
        holder.tv_tags.setText("Tags: " +listaCats.get(position).getTags());
    }

    @Override
    public int getItemCount() {
        return listaCats.size();
    }


    public class CatsViewHolder extends RecyclerView.ViewHolder {

        TextView tv_id, tv_tags;

        public CatsViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_id = itemView.findViewById(R.id.tv_id);
            tv_tags = itemView.findViewById(R.id.tv_tags);
        }
    }
}
