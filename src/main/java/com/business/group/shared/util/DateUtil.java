package com.business.group.shared.util;

public class DateUtil {
    private DateUtil() {
    }

    public static <T extends Comparable<T>> int compare(T before, T after) {
        return after.compareTo(before);
    }

    public static <T extends Comparable<T>> boolean isBefore(T before, T after) {
        return compare(before, after) < 0;
    }
}
