package widhi.project.footballclub;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CardClubAdapter extends RecyclerView.Adapter<CardClubAdapter.ListViewHolder> {
    private ArrayList<Club> listClub;
    private Context context;

    public CardClubAdapter(Context context, ArrayList<Club> listClub){
        this.listClub = listClub;
        this.context = context;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_club, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        final Club club = listClub.get(position);
        Glide.with(holder.itemView.getContext())
                .load(club.getPhoto())
                .apply(new RequestOptions().fitCenter())
                .into(holder.imgphoto);

        holder.tvName.setText(club.getName());
        holder.tvDesc.setText(club.getDescription());
        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detail = new Intent(context, DetaiListClub.class);
                detail.putExtra("club_id", club.getId());
                context.startActivity(detail);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listClub.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgphoto;
        TextView tvName, tvDesc;
        CardView cv;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgphoto = itemView.findViewById(R.id.img_club_list);
            tvName = itemView.findViewById(R.id.name_list_club);
            tvDesc = itemView.findViewById(R.id.desc_club_list);
            cv = itemView.findViewById(R.id.cardview_item);
        }
    }
}
