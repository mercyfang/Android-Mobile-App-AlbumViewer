package edu.duke.compsci290.albumviewer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class RaterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rater);

        Intent receivedIntent = this.getIntent();
        String songName = receivedIntent.getStringExtra(getString(R.string.songnamekey));

        RecyclerView rv = findViewById(R.id.activity_rater_recycler_view);
        rv.setAdapter(new RaterAdapter(this, songName));
        rv.setLayoutManager(new LinearLayoutManager(this));
    }
}
