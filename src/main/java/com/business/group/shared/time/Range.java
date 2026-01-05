package com.business.group.shared.time;

import java.util.Comparator;
import java.util.List;

public interface Range<T extends Comparable<? super T>> {
    T from();

    T to();

    default boolean isValid() {
        return from().compareTo(to()) <= 0;
    }

    default boolean overlapsWith(Range<T> other) {
        return from().compareTo(other.to()) < 0 && to().compareTo(other.from()) > 0;
    }

    static <T extends Comparable<? super T>> void checkForOverlappingRanges(List<? extends Range<T>> ranges) {
        ranges.sort(Comparator.comparing(Range::from));

        for (int i = 1; i < ranges.size(); i++) {
            if (ranges.get(i).overlapsWith(ranges.get(i - 1))) {
                //throw
            }
        }
    }
}
