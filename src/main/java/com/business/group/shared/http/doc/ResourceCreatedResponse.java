package com.business.group.shared.http.doc;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.core.annotation.AliasFor;

@ApiResponse(
        responseCode = "201",
        description = "Returns the created resource.",
        content = @Content(
                schema = @Schema(
                        implementation = Object.class
                )
        )
)
public @interface ResourceCreatedResponse {
    @AliasFor(annotation = Schema.class, attribute = "implementation")
    Class<?> value();
}
