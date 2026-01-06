package com.business.group.schedule.dto;

public record Range<T extends Comparable<? super T>>(
        T from,
        T to
) {
}
