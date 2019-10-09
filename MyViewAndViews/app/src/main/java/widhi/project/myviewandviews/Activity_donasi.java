package widhi.project.myviewandviews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Activity_donasi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donasi);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Donasi");
        }
    }
}
