package com.google.sample.cast.refplayer.ui.stationlist.model;

import com.google.sample.cast.refplayer.domain.model.Station;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class StationListItemViewModelMapperImpl implements StationListItemViewModelMapper {

    @Inject
    public StationListItemViewModelMapperImpl() {}

    @Override
    public StationListItemViewModel map(Station source) {
        return new StationListItemViewModel.Builder()
                .id(source.getId())
                .name(source.getName())
                .coverURL(source.getCoverURL())
                .build();
    }

    @Override
    public List<StationListItemViewModel> map(List<Station> source) {
        List<StationListItemViewModel> result = new ArrayList<>();
        for (Station station : source) {
            result.add(map(station));
        }
        return result;
    }
}
