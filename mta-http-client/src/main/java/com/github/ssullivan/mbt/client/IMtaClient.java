package com.github.ssullivan.mbt.client;

/**
 * Created by catal on 7/11/2017.
 */
public interface IMtaClient {
    void getBusTimes(final String stopId, final Integer radius, final Integer numTimesPerLine,
                final Integer numStopTimes);

    default void getBusTImes(final String stopId) {
        getBusTimes(stopId, -1, 5, 20);
    }

    void getListOfLines();

    void getStopsForLineRequest(final String lineDirId);


}
