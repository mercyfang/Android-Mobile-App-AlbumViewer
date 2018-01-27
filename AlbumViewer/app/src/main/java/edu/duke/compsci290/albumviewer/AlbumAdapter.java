package edu.duke.compsci290.albumviewer;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by MercyFang on 1/27/18.
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
        return albumHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Drawable albumArtwork = mContext.getDrawable(android.R.drawable.ic_dialog_info);
        holder.mImageView.setImageDrawable(albumArtwork);
        holder.mAlbumName.setText(mAlbums[position]);
        holder.mArtist.setText(mArtists[position]);
    }
}
