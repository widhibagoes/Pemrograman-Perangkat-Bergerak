package widhi.project.ormawapolines;

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

public class CardHmjAdapter extends RecyclerView.Adapter<CardHmjAdapter.ListViewHolder> {
    private ArrayList<Hmj> listHmj;
    private Context context;

    public CardHmjAdapter(Context context, ArrayList<Hmj> listHmj){
        this.listHmj = listHmj;
        this.context = context;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_hmj, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        final Hmj hmj = listHmj.get(position);
        Glide.with(holder.itemView.getContext())
                .load(hmj.getPhoto())
                .apply(new RequestOptions().fitCenter())
                .into(holder.imgphoto);

        holder.tvName.setText(hmj.getName());
        holder.tvDesc.setText(hmj.getDescription());
        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detail = new Intent(context, DetaiListHmj.class);
                detail.putExtra("hmj_id", hmj.getId());
                context.startActivity(detail);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listHmj.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgphoto;
        TextView tvName, tvDesc;
        CardView cv;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgphoto = itemView.findViewById(R.id.img_hmj_list);
            tvName = itemView.findViewById(R.id.name_list_hmj);
            tvDesc = itemView.findViewById(R.id.desc_hmj_list);
            cv = itemView.findViewById(R.id.cardview_item);
        }
    }
}
