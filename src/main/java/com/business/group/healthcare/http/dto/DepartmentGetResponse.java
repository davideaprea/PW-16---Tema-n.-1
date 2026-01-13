package com.business.group.healthcare.http.dto;

public record DepartmentGetResponse(
        long id,
        String name,
        String description
) {
}
