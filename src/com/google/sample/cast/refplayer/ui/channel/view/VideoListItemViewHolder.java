package com.google.sample.cast.refplayer.ui.channel.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidquery.AQuery;
import com.google.sample.cast.refplayer.R;
import com.squareup.picasso.Picasso;

public class VideoListItemViewHolder extends RecyclerView.ViewHolder {
    private final View mParent;
    private TextView mTitleView;
    private TextView mDescriptionView;
    private ImageView mImgView;

    public static VideoListItemViewHolder newInstance(View parent) {
        ImageView imgView = parent.findViewById(R.id.imageView1);
        TextView titleView = parent.findViewById(R.id.textView1);
        TextView descriptionView = parent.findViewById(R.id.textView2);
        View menu = parent.findViewById(R.id.menu);
        View textContainer = parent.findViewById(R.id.text_container);
        AQuery aQuery = new AQuery(parent);
        return new VideoListItemViewHolder(parent, imgView, textContainer, titleView, descriptionView, menu,
                aQuery);
    }

    private VideoListItemViewHolder(View parent, ImageView imgView, View textContainer, TextView titleView,
                       TextView descriptionView, View menu, AQuery aQuery) {
        super(parent);
        mParent = parent;
        mImgView = imgView;
        mTitleView = titleView;
        mDescriptionView = descriptionView;
    }

    public void setTitle(String title) {
        mTitleView.setText(title);
    }

    public void setDescription(String description) {
        mDescriptionView.setText(description);
    }

    public void setImage(String imgUrl) {
        Picasso.with(mImgView.getContext()).load(imgUrl).into(mImgView);
    }

    public void setOnClickListener(View.OnClickListener listener) {
        mParent.setOnClickListener(listener);
    }

    public ImageView getImageView() {
        return mImgView;
    }
}
