package pl.swosek.sample.penguin.data.controller.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.swosek.sample.penguin.data.controller.dto.GetPenguinResponse;
import pl.swosek.sample.penguin.data.controller.dto.GetPenguinsResponse;

/**
 * Controller for managing penguins.
 */
@Tag(
        description = "Endpoint for managing penguins representations.",
        name = "Penguin Endpoint"
)
public interface PenguinController {

    /**
     * @return penguins
     */
    @Operation(
            summary = "Get penguins.",
            description = "Provides penguins representation."
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Penguins representation."
                    )
            }
    )
    @GetMapping(
            value = "/api/penguins",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    GetPenguinsResponse getPenguins();

    /**
     * @return penguin
     */
    @Operation(
            summary = "Get penguin.",
            description = "Provides penguin representation."
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Penguin representation."
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Penguin not found."
                    ),
            }
    )
    @GetMapping(
            value = "/api/penguin/{taxonKey}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    GetPenguinResponse getPenguin(
            @Parameter(
                    description = "Taxon key.",
                    example = "63128"
            )
            @PathVariable String taxonKey
    );

}
