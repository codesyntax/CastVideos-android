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
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.google.android.gms.cast.MediaInfo;
import com.google.sample.cast.refplayer.R;
import com.google.sample.cast.refplayer.ui.channel.model.VideoListItemViewModel;

import java.util.List;

/**
 * An {@link ArrayAdapter} to populate the list of videos.
 */
public class VideoListAdapter extends RecyclerView.Adapter<VideoListItemViewHolder> {
    private final ItemClickListener mClickListener;
    private List<VideoListItemViewModel> videos;

    public VideoListAdapter(ItemClickListener clickListener) {
        mClickListener = clickListener;
    }

    @Override
    public VideoListItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        View parent = LayoutInflater.from(context).inflate(R.layout.item_video_list, viewGroup, false);
        return VideoListItemViewHolder.newInstance(parent);
    }

    @Override
    public void onBindViewHolder(final VideoListItemViewHolder viewHolder, final int position) {
        final VideoListItemViewModel video = videos.get(position);
        viewHolder.setTitle(video.getTitle());
        viewHolder.setDescription(video.getDescription());
        viewHolder.setImage(video.getCoverURL());
        viewHolder.setOnClickListener(
                view -> mClickListener.itemClicked(viewHolder.getImageView(), video));
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
