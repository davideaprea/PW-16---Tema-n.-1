package com.business.group.shared.dto;

import java.io.InputStream;

public record FileUploadRequest(
        String name,
        InputStream content,
        long size
) {
}
