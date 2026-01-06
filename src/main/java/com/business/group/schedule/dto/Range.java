package com.business.group.schedule.dto;

import com.business.group.shared.annotation.ValidRange;
import jakarta.validation.constraints.NotNull;

@ValidRange
public record Range<T extends Comparable<? super T>>(
        @NotNull
        T from,

        @NotNull
        T to
) {
}
