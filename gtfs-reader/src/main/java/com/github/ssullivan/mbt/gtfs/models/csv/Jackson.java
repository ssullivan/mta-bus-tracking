package com.github.ssullivan.mbt.gtfs.models.csv;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class Jackson {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("YYYY-MM-dd");
    private static final Pattern YEAR_MONTH_DAY = Pattern.compile("^(\\d{4})(0\\d|\\d{2})(0\\d|\\d{2})$");
    static class YearMonthDayDeserializer extends JsonDeserializer<LocalDate> {

        @Override
        public LocalDate deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
            final Matcher matcher = YEAR_MONTH_DAY.matcher(p.getText());
            if (matcher.matches()) {
                final String ymd = matcher.group(1) + "-" + matcher.group(2) + "-" + matcher.group(3);

                return LocalDate.parse(ymd);
            }
            return LocalDate.parse(p.getText(), DATE_TIME_FORMATTER);
        }
    }
}
