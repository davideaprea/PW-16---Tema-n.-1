package com.business.group.shared.exception;

import lombok.Getter;

import java.util.List;

@Getter
public class ConflictingResourceException extends RuntimeException {
    private final Object submittedResource;
    private final List<?> conflictingResources;

    public ConflictingResourceException(
            String cause,
            Object submittedResource,
            List<?> conflictingResources
    ) {
        super("Submitted resource %s is in conflict with the following parameters: %s. Cause: %s."
                .formatted(submittedResource, conflictingResources, cause));
        this.submittedResource = submittedResource;
        this.conflictingResources = List.copyOf(conflictingResources);
    }
}
