package pm.mendozamacias.recuperac;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class CatsActivity extends AppCompatActivity {

    TextView lbl_id, lbl_created, lbl_tags;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cats);

        lbl_id = (TextView) findViewById(R.id.lbl_id);
        lbl_created = (TextView) findViewById(R.id.lbl_created);
        lbl_tags = (TextView) findViewById(R.id.lbl_tags);

        String id = getIntent().getStringExtra("id");
        String created = getIntent().getStringExtra("created_at");
        String tags = getIntent().getStringExtra("tags");

        lbl_id.setText("ID: " + id);
        lbl_created.setText("CREATED AT: " + created);
        lbl_tags.setText("TAGS: " + tags);
    }
}