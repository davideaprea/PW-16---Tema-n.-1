package com.business.group.shared.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.time.Duration;

@Converter
public class DurationConverter implements AttributeConverter<Duration, Long> {
    @Override
    public Long convertToDatabaseColumn(Duration duration) {
        if (duration == null) {
            return 0L;
        }

        return duration.getSeconds();
    }

    @Override
    public Duration convertToEntityAttribute(Long seconds) {
        if (seconds == null) {
            return Duration.ZERO;
        }

        return Duration.ofSeconds(seconds);
    }
}
