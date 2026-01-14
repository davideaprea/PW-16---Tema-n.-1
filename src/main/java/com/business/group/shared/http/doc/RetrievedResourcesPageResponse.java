package com.business.group.shared.http.doc;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.core.annotation.AliasFor;

@ApiResponse(
        responseCode = "200",
        description = "Returns a page of resources.",
        content = @Content(
                schema = @Schema(
                        implementation = Object.class
                )
        )
)
public @interface RetrievedResourcesPageResponse {
    @AliasFor(annotation = Schema.class, attribute = "implementation")
    Class<?> value();
}
