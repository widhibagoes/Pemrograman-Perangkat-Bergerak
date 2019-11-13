package widhi.project.footballclub;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class DetaiListClub extends AppCompatActivity {
    private int club_id;
    ImageView imgDetail;
    TextView tvName, tvDesc;
    private ArrayList<Club> listClub = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detai_list_club);

        club_id = getIntent().getIntExtra("club_id",0);
        tvName = findViewById(R.id.nama_club);
        tvDesc = findViewById(R.id.desc_detail);
        imgDetail = findViewById(R.id.img_detail);

        listClub.addAll(ClubData.getListData());
        jdl();
        setLayout();
    }

    void jdl(){
        getSupportActionBar().setTitle(listClub.get(club_id).getName());
    }
    void setLayout(){
        tvName.setText(listClub.get(club_id).getName());
        tvDesc.setText(listClub.get(club_id).getDescription());
        Glide.with(this)
                .load(listClub.get(club_id).getPhoto())
                .apply(new RequestOptions().fitCenter())
                .into(imgDetail);
    }
}
