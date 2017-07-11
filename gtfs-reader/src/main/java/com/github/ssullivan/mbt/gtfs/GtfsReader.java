package com.github.ssullivan.mbt.gtfs;

import com.github.ssullivan.mbt.gtfs.models.*;

import java.util.List;
import java.util.Map;

/**
 * Created by catal on 7/8/2017.
 */
public class GtfsReader {
    private static final String AGENCY_CSV = "agency.txt";
    private static final String CALENDAR_CSV = "calendar.txt";
    private static final String CALENDAR_DATES_CSV = "calendar_dates.txt";
    private static final String ROUTES_CSV = "routes.txt";
    private static final String SHAPES_CSV = "shapes.txt";
    private static final String STOP_TIMES_CSV = "stop_times.txt";
    private static final String TRIPS_CSV = "trips.txt";

    private Map<String, GtfsAgency> _agency;
    private List<GtfsCalendar> _calendars;
    private List<GtfsCalendarDate> _calendarDates;
    private Map<String, GtfsRoute> _routes;
    private Map<String, GtfsShapePoint> _shapes;

}
