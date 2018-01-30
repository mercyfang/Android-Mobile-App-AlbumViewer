package edu.duke.compsci290.albumviewer;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Displays album cover, corresponding album name and artist side by side. User could also click on
 * each cover to check details about the album.
 *
 * Created by Mercy Fang on 1/27/18.
 */

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder> {
    public class ViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout mLinearLayout;
        private ImageView mImageView;
        private TextView mAlbumName;
        private TextView mArtist;

        private ViewHolder(View itemView) {
            super(itemView);

            // Connect the instance variables in the ViewHolder class to the inflated instances.
            this.mLinearLayout = itemView.findViewById(R.id.album_holder_linear_layout);
            this.mImageView = itemView.findViewById(R.id.album_artwork_image_view);
            this.mAlbumName = itemView.findViewById(R.id.album_name_text_view);
            this.mArtist = itemView.findViewById(R.id.artist_name_text_view);
        }
    }

    private Context mContext;
    private String[] mAlbums;
    private String[] mArtists;
    private static final String TAG = "AlbumAdapter";

    public AlbumAdapter(final Context context, String[] albums, String[] artists) {
        mContext = context;
        mAlbums = albums;
        mArtists = artists;
    }

    @Override
    public int getItemCount() {
        return mAlbums.length;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater mInflater =
                (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = mInflater.inflate(R.layout.album_holder, parent, false);
        final ViewHolder albumHolder = new ViewHolder(row);

        // Display the details of the album when user taps on it.
        albumHolder.mLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAlbum(mAlbums[albumHolder.getAdapterPosition()]);
            }
        });

        return albumHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String albumName = mAlbums[position].toLowerCase().replaceAll("\\W+", "");
        int drawableId = mContext.getResources().getIdentifier(
                albumName, "drawable", mContext.getPackageName());
        Drawable albumArtwork = mContext.getDrawable(drawableId);

        holder.mImageView.setImageDrawable(albumArtwork);

        // Display standardized album name by capitalizing first letter of each word.
        String albumNameCap = "";
        for (String s : albumName.split("_")) {
            if (s.equals("of") || s.equals("the")) {
                albumNameCap += s;
            } else {
                albumNameCap += s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
            }
            albumNameCap += " ";
        }
        holder.mAlbumName.setText(albumNameCap);
        holder.mArtist.setText(mArtists[position]);
    }

    private void openAlbum(String albumName) {
        Log.d(TAG, "Opening album " + albumName);
        Intent intent = new Intent(mContext, AlbumActivity.class);
        intent.putExtra(mContext.getString(R.string.albumnamekey), albumName);
        mContext.startActivity(intent);
    }
}
