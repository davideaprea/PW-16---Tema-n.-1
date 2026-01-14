package com.business.group.shared.http.doc;

import com.business.group.shared.http.InvalidPayloadErrorResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@ApiResponse(
        responseCode = "400",
        description = "Invalid payload.",
        content = @Content(
                schema = @Schema(
                        implementation = InvalidPayloadErrorResponse.class
                )
        )
)
public @interface InvalidPayloadResponseDoc {
    @AliasFor(annotation = ApiResponse.class, attribute = "description")
    String value() default "Invalid payload.";
}
