package edu.duke.compsci290.albumviewer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

public class AlbumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);

        Intent receivedIntent = this.getIntent();
        String albumName = receivedIntent.getStringExtra(getString(R.string.albumnamekey));
        int albumId = getResources().getIdentifier(albumName, "array", getPackageName());
        String[] songs = getResources().getStringArray(albumId);

        RecyclerView rv = findViewById(R.id.activity_album_recycler_view);
        rv.setAdapter(new SongAdapter(this, songs));
        rv.setLayoutManager(new LinearLayoutManager(this));
    }
}
