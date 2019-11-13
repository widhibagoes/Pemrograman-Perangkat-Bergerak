package widhi.project.footballclub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;

public class ProfilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        if(getSupportActionBar() != null) {
            getSupportActionBar().setTitle("My Profile");
        }
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            final Drawable pindah = ContextCompat.getDrawable(this, R.drawable.ic_arrow_back_black_24dp);
            pindah.setColorFilter(ContextCompat.getColor(this, R.color.White), PorterDuff.Mode.SRC_ATOP);
            getSupportActionBar().setHomeAsUpIndicator(pindah);
        }
        public boolean onOptionsItemSelected(MenuItem mt){
            finish();
            return super.onOptionsItemSelected(mt);
        }
    }
