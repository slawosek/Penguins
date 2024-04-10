package pl.swosek.sample.penguin.data.controller.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

}
