package widhi.project.footballclub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvClub;
    private ArrayList<Club> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle("Football Club");
        }
        rvClub = findViewById(R.id.rv_club);
        rvClub.setHasFixedSize(true);

        list.addAll(ClubData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList() {
        rvClub.setLayoutManager(new LinearLayoutManager(this));
        CardClubAdapter cardClubAdapter = new CardClubAdapter(this, list);
        rvClub.setAdapter(cardClubAdapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu mn){
        getMenuInflater().inflate(R.menu.profil, mn);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId()==R.id.action_profil){
            Intent profil = new Intent(this, ProfilActivity.class);
            startActivity(profil);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

