package com.dockerbt.api.controllers;

import com.dockerbt.api.constants.ApiResponseConstants;
import com.dockerbt.api.dtos.ToolDto;
import com.dockerbt.api.exceptions.handler.ApiError;
import com.dockerbt.api.services.ToolService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/api/toolshop/tools")
@OpenAPIDefinition(tags ={@Tag(name="Tools", description = "API to manage tools.")})
@RestController
@Slf4j
@CrossOrigin
@RequiredArgsConstructor
public class ToolController
{
    private final ToolService toolService;

    @Operation(tags = {"Example"}, summary = "Get a string-message", responses = {
            @ApiResponse(responseCode = ApiResponseConstants.RESPONSE_CODE_OK, description = "Success"),
            @ApiResponse(responseCode = ApiResponseConstants.RESPONSE_CODE_BAD_REQUEST, description = "Bad request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class))),
            @ApiResponse(responseCode = ApiResponseConstants.RESPONSE_CODE_INTERNAL_SERVER_ERROR, description = "Something went wrong on the server!", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class))),
            @ApiResponse(responseCode = ApiResponseConstants.RESPONSE_CODE_NOT_FOUND, description = "No matching record found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class)))
    })
    @RequestMapping(value = "/message", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getMessage()
    {
        return "Message from ToolController";
    }

    @Operation(tags = {"Tools"}, summary = "Get tool by id", responses = {
            @ApiResponse(responseCode = ApiResponseConstants.RESPONSE_CODE_OK, description = "Success"),
            @ApiResponse(responseCode = ApiResponseConstants.RESPONSE_CODE_BAD_REQUEST, description = "Bad request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class))),
            @ApiResponse(responseCode = ApiResponseConstants.RESPONSE_CODE_INTERNAL_SERVER_ERROR, description = "Something went wrong on the server!", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class))),
    })
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ToolDto> getToolById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.of(toolService.getToolById(id));
    }

}
