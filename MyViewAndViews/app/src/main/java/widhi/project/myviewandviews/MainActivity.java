package widhi.project.myviewandviews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn_Donasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_Donasi = findViewById(R.id.btnDonasi);
        btn_Donasi.setOnClickListener(this);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Donasi Pesawat R80");
        }
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnDonasi:
                Intent moveIntent = new Intent(MainActivity.this, Activity_donasi.class);
                startActivity(moveIntent);
                break;
        }
    }
}
