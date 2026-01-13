package com.business.group.shared.exception;

import java.util.Map;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Map<String, Object> params) {
        super("Couldn't find any resource with the given parameters: %s".formatted(params));
    }
}
