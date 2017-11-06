package com.google.sample.cast.refplayer.ui.stationlist.model;

import com.google.sample.cast.refplayer.domain.model.Station;

import java.util.List;

public interface StationListItemViewModelMapper {

    StationListItemViewModel map(Station source);

    List<StationListItemViewModel> map(List<Station> source);
}
