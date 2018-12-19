package com.google.sample.cast.refplayer.ui.channel.view;

import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.sample.cast.refplayer.R;
import com.squareup.picasso.Picasso;

public class VideoListItemViewHolder extends RecyclerView.ViewHolder {
    private final View parent;
    private final AppCompatTextView title;
    private final AppCompatTextView datetime;
    private final AppCompatTextView duration;
    private final AppCompatImageView image;
    private final AppCompatImageButton play;

    public static VideoListItemViewHolder newInstance(View parent) {
        AppCompatImageView image = (AppCompatImageView) parent.findViewById(R.id.imageView1);
        AppCompatTextView title = (AppCompatTextView) parent.findViewById(R.id.textView1);
        AppCompatTextView datetime = (AppCompatTextView) parent.findViewById(R.id.datetime);
        AppCompatTextView duration = (AppCompatTextView) parent.findViewById(R.id.duration);
        AppCompatImageButton play = (AppCompatImageButton) parent.findViewById(R.id.play);
        View textContainer = parent.findViewById(R.id.text_container);
        return new VideoListItemViewHolder(parent, image, textContainer,
                title, datetime, play, duration);
    }

    private VideoListItemViewHolder(View parent, AppCompatImageView image, View textContainer,
                                    AppCompatTextView title, AppCompatTextView datetime,
                                    AppCompatImageButton play, AppCompatTextView duration) {
        super(parent);
        this.parent = parent;
        this.image = image;
        this.title = title;
        this.datetime = datetime;
        this.duration = duration;
        this.play = play;
    }

    public void setTitle(String title) {
        this.title.setText(title);
    }

    public void setDatetime(String datetime) {
        this.datetime.setText(datetime);
    }

    public void setImage(String imgUrl) {
        Picasso.with(image.getContext()).load(imgUrl).into(image);
    }

    public void hideDuration() {
        duration.setVisibility(View.GONE);
    }

    public void setOnClickListener(View.OnClickListener listener) {
        parent.setOnClickListener(listener);
    }

    public ImageView getImageView() {
        return image;
    }

    public AppCompatImageButton getPlayButton() {
        return play;
    }

    public void setMinutes(String duration) {
        this.duration.setText(
                this.duration.getContext().getString(R.string.video_list_item_duration_minutes, duration));
    }

    public void setSeconds(String duration) {
        this.duration.setText(
                this.duration.getContext().getString(R.string.video_list_item_duration_seconds, duration));
    }
}
