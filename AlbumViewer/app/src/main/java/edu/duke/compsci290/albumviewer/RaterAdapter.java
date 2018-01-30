package edu.duke.compsci290.albumviewer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * User could rate a specific song.
 *
 * Created by Mercy Fang on 1/29/18.
 */

public class RaterAdapter extends RecyclerView.Adapter<RaterAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout mLinearLayout;
        private TextView mSong;
        private RatingBar mRatingBar;

        private ViewHolder(View itemView) {
            super(itemView);

            // Connect the instance variables in the ViewHolder class to the inflated instances.
            this.mLinearLayout = itemView.findViewById(R.id.rater_holder_linear_layout);
            this.mSong = itemView.findViewById(R.id.song_name_text_view);
            this.mRatingBar = itemView.findViewById(R.id.song_rater_rating_bar);
        }
    }

    private Context mContext;
    private String mSong;

    public RaterAdapter(final Context context, String song) {
        mContext = context;
        mSong = song;
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    @Override
    public RaterAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater mInflater =
                (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = mInflater.inflate(R.layout.rater_holder, parent, false);
        final RaterAdapter.ViewHolder raterHolder = new RaterAdapter.ViewHolder(row);
        return raterHolder;
    }

    @Override
    public void onBindViewHolder(RaterAdapter.ViewHolder holder, int position) {
        holder.mSong.setText(mSong);
    }
}
