package com.google.sample.cast.refplayer.ui.stationlist.model;

import com.google.sample.cast.refplayer.domain.model.Channel;

import java.util.List;

public interface StationListItemViewModelMapper {

    StationListItemViewModel map(Channel source);

    List<StationListItemViewModel> map(List<Channel> source);
}
