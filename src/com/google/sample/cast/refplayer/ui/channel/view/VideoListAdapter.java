/*
 * Copyright (C) 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.sample.cast.refplayer.ui.channel.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.google.sample.cast.refplayer.R;
import com.google.sample.cast.refplayer.ui.channel.model.VideoListItemViewModel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * An {@link ArrayAdapter} to populate the list of videos.
 */
public class VideoListAdapter extends RecyclerView.Adapter<VideoListItemViewHolder> {
    private static final String HOUR_FORMAT = "HH:mm";
    private static final String DAY_FORMAT = "dd";
    private final ItemClickListener mClickListener;
    private List<VideoListItemViewModel> videos;

    public VideoListAdapter(ItemClickListener clickListener) {
        mClickListener = clickListener;
    }

    @Override
    public VideoListItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        View parent = LayoutInflater.from(context).inflate(R.layout.item_video_list, viewGroup,
                false);
        return VideoListItemViewHolder.newInstance(parent);
    }

    @Override
    public void onBindViewHolder(final VideoListItemViewHolder viewHolder, final int position) {
        final VideoListItemViewModel video = videos.get(position);
        viewHolder.setTitle(video.getTitle());
        if (video.getDate() != null) {
            String date = getFormattedDate(video.getDate(), viewHolder.itemView.getContext());
            viewHolder.setDatetime(date);
        }
        viewHolder.setImage(video.getCoverURL());
        int duration = (int) (video.getDuration() / 1000);
        if (duration >= 60) {
            duration = duration / 60;
            viewHolder.setMinutes(String.valueOf(duration));
        } else {
            viewHolder.setSeconds(String.valueOf(duration));
        }
        viewHolder.setOnClickListener(
                view -> mClickListener.itemClicked(viewHolder.getImageView(), video));
    }

    private String getFormattedDate(Date date, Context context) {
        String result;
        Calendar now = Calendar.getInstance();
        Calendar givenDate = Calendar.getInstance();
        givenDate.setTime(date);
        if (now.get(Calendar.DATE) == givenDate.get(Calendar.DATE)) {
            SimpleDateFormat todayDateFormat = new SimpleDateFormat(HOUR_FORMAT, Locale.US);
            result = context.getString(R.string.video_list_item_date_today,
                    todayDateFormat.format(date));
        } else if (now.get(Calendar.DATE) - givenDate.get(Calendar.DATE) == 1) {
            result = context.getString(R.string.video_list_item_date_yesterday,
                    getMonthString(date, context));
        } else {
            result = getMonthString(date, context);
        }
        return result;
    }

    @NonNull
    private String getMonthString(Date date, Context context) {
        String result;
        SimpleDateFormat yesterdayDateFormat = new SimpleDateFormat(DAY_FORMAT, Locale.US);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int month = calendar.get(Calendar.MONTH);
        String monthName = context.getResources().getStringArray(R.array.months)[month];
        result = context.getString(R.string.video_list_item_month_and_day,
                monthName, yesterdayDateFormat.format(date));
        return result;
    }

    @Override
    public int getItemCount() {
        return videos == null ? 0 : videos.size();
    }

    public void setData(List<VideoListItemViewModel> videos) {
        this.videos = videos;
        notifyDataSetChanged();
    }

    /**
     * A listener called when an item is clicked in the video list.
     */
    public interface ItemClickListener {

        void itemClicked(ImageView view, VideoListItemViewModel item);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }
}
