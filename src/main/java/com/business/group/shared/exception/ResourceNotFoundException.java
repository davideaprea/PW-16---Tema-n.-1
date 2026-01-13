package com.business.group.shared.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException() {
        super("Couldn't find any resource with the given parameters.");
    }
}
