package com.github.ssullivan.mbt.gtfs;

import com.fasterxml.jackson.core.FormatSchema;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.github.ssullivan.mbt.gtfs.models.csv.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Created by catal on 7/8/2017.
 */
public class GtfsReader {
    private static final Logger Log = LoggerFactory.getLogger(GtfsReader.class);
    private static ObjectMapper MAPPER = new CsvMapper()
          ;

    private static final String AGENCY_CSV = "agency.txt";
    private static final String CALENDAR_CSV = "calendar.txt";
    private static final String CALENDAR_DATES_CSV = "calendar_dates.txt";
    private static final String ROUTES_CSV = "routes.txt";
    private static final String SHAPES_CSV = "shapes.txt";
    private static final String STOP_TIMES_CSV = "stop_times.txt";
    private static final String STOPS_CSV = "stops.txt";
    private static final String TRIPS_CSV = "trips.txt";

    private Map<String, GtfsAgency> _agency = new HashMap<>();
    private List<GtfsCalendar> _calendars = new ArrayList<>();
    private List<GtfsCalendarDate> _calendarDates = new ArrayList<>();
    private Map<String, GtfsRoute> _routes = new HashMap<>();
    private Map<String, GtfsShapePoint> _shapes = new HashMap<>();
    private List<GtfsStopTime> _stopTimes = new ArrayList<>();
    private Map<String, GtfsStop> _stops = new HashMap<>();
    private Map<String, GtfsTrip> _trips = new HashMap<>();

    public Map<String, GtfsAgency> getAgency() {
        return Collections.unmodifiableMap(_agency);
    }

    public List<GtfsCalendar> getCalendars() {
        return Collections.unmodifiableList(_calendars);
    }

    public List<GtfsCalendarDate> getCalendarDates() {
        return Collections.unmodifiableList(_calendarDates);
    }

    public Map<String, GtfsRoute> getRoutes() {
        return Collections.unmodifiableMap(_routes);
    }

    public Map<String, GtfsShapePoint> getShapes() {
        return Collections.unmodifiableMap(_shapes);
    }

    public List<GtfsStopTime> getStopTimes() {
        return Collections.unmodifiableList(_stopTimes);
    }

    public Map<String, GtfsStop> getStops() {
        return Collections.unmodifiableMap(_stops);
    }

    public Map<String, GtfsTrip> getTrips() {
        return Collections.unmodifiableMap(_trips);
    }

    public void read(InputStream inputStream) throws IOException {
        try (ZipInputStream zipInputStream = new ZipInputStream(inputStream, Charset.forName("UTF-8"))) {

            ZipEntry zipEntry = null;

            while ((zipEntry = zipInputStream.getNextEntry()) != null) {

                switch (zipEntry.getName()) {
                    case AGENCY_CSV:
                        readAgency(new ClosedShieldInputStream(zipInputStream));
                        break;
                    case CALENDAR_CSV:
                        break;
                    case CALENDAR_DATES_CSV:
                        break;
                    case ROUTES_CSV:
                        readRoutes(new ClosedShieldInputStream(zipInputStream));
                        break;
                    case SHAPES_CSV:
                        break;
                    case STOPS_CSV:
                        readStops(new ClosedShieldInputStream(zipInputStream));
                        break;
                    case STOP_TIMES_CSV:
                        readStopTimes(new ClosedShieldInputStream(zipInputStream));
                        break;
                    case TRIPS_CSV:
                        readTrips(new ClosedShieldInputStream(zipInputStream));
                        break;
                    default:
                        Log.warn("Unrecognized GTFS file {}", zipEntry.getName());
                        zipInputStream.closeEntry();
                }
                zipInputStream.closeEntry();
            }
        }
    }

    private void readTrips(InputStream inputStream) throws IOException {
        CsvSchema schema = CsvSchema
                .builder()
                .setUseHeader(true)
                .build();

        Iterator<GtfsTrip> iter = MAPPER.readerFor(GtfsTrip.class)
                .with(schema)
                .readValues(inputStream);

        while (iter.hasNext()) {
            GtfsTrip gtfsTrip = iter.next();
            _trips.put(gtfsTrip.id(), gtfsTrip);
        }
    }

    private void readStops(InputStream inputStream) throws IOException {
        CsvSchema schema = CsvSchema
                .builder()
                .setUseHeader(true)
                .build();

        Iterator<GtfsStop> iter = MAPPER.readerFor(GtfsStop.class)
                .with(schema)
                .readValues(inputStream);

        while (iter.hasNext()) {
            GtfsStop gtfsStop = iter.next();
            _stops.put(gtfsStop.id(), gtfsStop);
        }
    }

    private void readStopTimes(InputStream inputStream) throws IOException {
        CsvSchema schema = CsvSchema
                .builder()
                .setUseHeader(true)
                .build();

        Iterator<GtfsStopTime> iter = MAPPER.readerFor(GtfsStopTime.class)
                .with(schema)
                .readValues(inputStream);

        while (iter.hasNext()) {
            GtfsStopTime gtfsStopTime = iter.next();
            _stopTimes.add(gtfsStopTime);
        }
    }

    private void readAgency(InputStream inputStream) throws IOException {
        CsvSchema schema = CsvSchema
                .builder()
                .setUseHeader(true)
                .build();

        Iterator<GtfsAgency> iter = MAPPER.readerFor(GtfsAgency.class)
                .with(schema)
                .readValues(inputStream);

        while (iter.hasNext()) {
            GtfsAgency gtfsAgency = iter.next();
            _agency.put(gtfsAgency.id(), gtfsAgency);
        }
    }

    private void readRoutes(InputStream inputStream) throws IOException {
        CsvSchema schema = CsvSchema
                .builder()
                .setUseHeader(true)
                .build();

        Iterator<GtfsRoute> iter = MAPPER.readerFor(GtfsRoute.class)
                .with(schema)
                .readValues(inputStream);

        while (iter.hasNext()) {
            GtfsRoute gtfsRoute = iter.next();
            _routes.put(gtfsRoute.id(), gtfsRoute);
        }
    }

    private static class ClosedShieldInputStream extends InputStream {
        private InputStream _delegate;

        public ClosedShieldInputStream(InputStream delegate) {
            _delegate = delegate;
        }

        @Override
        public int read() throws IOException {
            return _delegate.read();
        }

        @Override
        public int read(byte[] b) throws IOException {
            return _delegate.read(b);
        }

        @Override
        public int read(byte[] b, int off, int len) throws IOException {
            return _delegate.read(b, off, len);
        }

        @Override
        public long skip(long n) throws IOException {
            return _delegate.skip(n);
        }

        @Override
        public int available() throws IOException {
            return _delegate.available();
        }

        @Override
        public synchronized void mark(int readlimit) {
            _delegate.mark(readlimit);
        }

        @Override
        public synchronized void reset() throws IOException {
            _delegate.reset();
        }

        @Override
        public boolean markSupported() {
            return _delegate.markSupported();
        }

        @Override
        public void close() throws IOException {

        }
    }
}
