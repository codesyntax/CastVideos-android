package com.google.sample.cast.refplayer.ui.stationlist.model;

import com.google.sample.cast.refplayer.domain.model.Channel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class StationListItemViewModelMapperImpl implements StationListItemViewModelMapper {

    @Inject
    public StationListItemViewModelMapperImpl() {}

    @Override
    public StationListItemViewModel map(Channel source) {
        return new StationListItemViewModel.Builder()
                .id(source.getId())
                .name(source.getName())
                .coverURL(source.getCoverURL())
                .build();
    }

    @Override
    public List<StationListItemViewModel> map(List<Channel> source) {
        List<StationListItemViewModel> result = new ArrayList<>();
        for (Channel channel : source) {
            result.add(map(channel));
        }
        return result;
    }
}
