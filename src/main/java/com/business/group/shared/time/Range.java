package com.business.group.shared.time;

public interface Range<T extends Comparable<? super T>> {
    T from();

    T to();

    default boolean isValid() {
        return from().compareTo(to()) <= 0;
    }

    default boolean overlapsWith(Range<T> other) {
        return from().compareTo(other.to()) < 0 && to().compareTo(other.from()) > 0;
    }
}
