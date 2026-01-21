package com.business.group.examination.domain.dto;

public record ReportGetCommand(
        long reportId,
        long loggedUserId
) {
}
