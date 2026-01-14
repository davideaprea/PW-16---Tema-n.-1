package com.business.group.shared.http.doc;

import com.business.group.shared.http.ConflictingResourceErrorResponse;
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
        responseCode = "409",
        description = "Conflicting payload.",
        content = @Content(
                schema = @Schema(
                        implementation = ConflictingResourceErrorResponse.class
                )
        )
)
public @interface ConflictingResourceResponseDoc {
    @AliasFor(annotation = ApiResponse.class, attribute = "description")
    String value() default "Invalid payload.";
}
