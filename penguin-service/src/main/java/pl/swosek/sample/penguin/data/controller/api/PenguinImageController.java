package pl.swosek.sample.penguin.data.controller.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Controller for managing penguin images.
 */
@Tag(
        description = "Endpoint for managing penguin images representations.",
        name = "Penguin image Endpoint"
)
public interface PenguinImageController {

    /**
     * @return penguin image
     */
    @Operation(
            summary = "Get penguin image.",
            description = "Provides penguin image representation."
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Penguin image representation."
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Penguin image not found."
                    ),
            }
    )
    @GetMapping(
            value = "/api/penguin/{taxonKey}/image",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<byte[]> getPenguinImage(
            @Parameter(
                    description = "Taxon key.",
                    example = "63128"
            )
            @PathVariable String taxonKey
    );

    @GetMapping(
            value = "/api/images",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    List<String> getPenguinImages();



}
