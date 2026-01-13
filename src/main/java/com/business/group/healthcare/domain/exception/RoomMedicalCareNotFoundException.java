package com.business.group.healthcare.domain.exception;

public class RoomMedicalCareNotFoundException extends RuntimeException {
    public RoomMedicalCareNotFoundException(long medicalCareId, long roomId) {
        super("Couldn't find any room medical service with the following parameters: medicalCareId = %d; roomId = %d"
                .formatted(medicalCareId, roomId));
    }
}
