package com.business.group.location.domain.exception;

import lombok.Getter;

@Getter
public class NonContiguousFloorsException extends RuntimeException {
    private final int first;
    private final int second;

    public NonContiguousFloorsException(int first, int second) {
        super("Found floors with a non contiguous sequence: %d, %d".formatted(first, second));
        this.first = first;
        this.second = second;
    }
}
