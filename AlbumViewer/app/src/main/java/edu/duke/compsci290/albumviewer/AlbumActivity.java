package edu.duke.compsci290.albumviewer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class AlbumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);

        Intent receivedIntent = this.getIntent();
        String albumName = receivedIntent.getStringExtra(getString(R.string.albumnamekey));
        String artistName = receivedIntent.getStringExtra(getString(R.string.artistnamekey));
        int albumId = getResources().getIdentifier(albumName, "array", getPackageName());
        String[] songs = getResources().getStringArray(albumId);

        String[] albums = new String[1];
        albums[0] = albumName;
        String[] artists = new String[1];
        artists[0] = artistName;

        // One RecyclerView to display album information.
        RecyclerView rv2 = findViewById(R.id.activity_album_recycler_view_2);
        rv2.setAdapter(new AlbumAdapter(this, albums, artists));
        rv2.setLayoutManager(new LinearLayoutManager(this));

        // One RecyclerView to display songs.
        RecyclerView rv = findViewById(R.id.activity_album_recycler_view);
        rv.setAdapter(new SongAdapter(this, songs));
        rv.setLayoutManager(new LinearLayoutManager(this));
    }
}
