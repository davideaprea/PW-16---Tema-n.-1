package com.business.group.shared.dto;

import java.io.InputStream;

public record FileGetResponse(
        InputStream fileStream
) {
}
