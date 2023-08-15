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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/dockerbt/tools")
@OpenAPIDefinition(tags ={@Tag(name="Tools", description = "API to manage tools.")})
@RestController
@Slf4j
@CrossOrigin
@RequiredArgsConstructor
public class ToolController
{
    private final ToolService toolService;

    @Operation(tags = {"Tools"}, summary = "Get tool by id", responses = {
            @ApiResponse(responseCode = ApiResponseConstants.RESPONSE_CODE_OK, description = "Success"),
            @ApiResponse(responseCode = ApiResponseConstants.RESPONSE_CODE_BAD_REQUEST, description = "Bad request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class))),
            @ApiResponse(responseCode = ApiResponseConstants.RESPONSE_CODE_INTERNAL_SERVER_ERROR, description = "Something went wrong on the server!", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class))),
    })
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ToolDto getToolById(@PathVariable(name = "id") Long id) {
        return toolService.getToolById(id);
    }

    @Operation(tags = {"Tools"}, summary = "Add new tool", responses = {
            @ApiResponse(responseCode = ApiResponseConstants.RESPONSE_CODE_OK, description = "Success"),
            @ApiResponse(responseCode = ApiResponseConstants.RESPONSE_CODE_BAD_REQUEST, description = "Bad request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class))),
    })
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ToolDto addTool(@RequestBody @Validated ToolDto toolDto) {
        return toolService.addTool(toolDto);
    }

    @Operation(tags = {"Tools"}, summary = "Update tool", responses = {
            @ApiResponse(responseCode = ApiResponseConstants.RESPONSE_CODE_OK, description = "Success"),
            @ApiResponse(responseCode = ApiResponseConstants.RESPONSE_CODE_BAD_REQUEST, description = "Bad request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class))),
            @ApiResponse(responseCode = ApiResponseConstants.RESPONSE_CODE_INTERNAL_SERVER_ERROR, description = "Something went wrong on the server!", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class))),
            @ApiResponse(responseCode = ApiResponseConstants.RESPONSE_CODE_NOT_FOUND, description = "No matching record found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class)))
    })
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ToolDto updateTool(@RequestBody @Validated ToolDto toolDto, @PathVariable(name = "id") Long id) {
        return toolService.updateTool(toolDto, id);
    }

    @Operation(tags = {"Tools"}, summary = "Delete tool", responses = {
            @ApiResponse(responseCode = ApiResponseConstants.RESPONSE_CODE_NO_CONTENT, description = "Success"),
            @ApiResponse(responseCode = ApiResponseConstants.RESPONSE_CODE_BAD_REQUEST, description = "Bad request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class))),
            @ApiResponse(responseCode = ApiResponseConstants.RESPONSE_CODE_INTERNAL_SERVER_ERROR, description = "Something went wrong on the server!", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class))),
            @ApiResponse(responseCode = ApiResponseConstants.RESPONSE_CODE_NOT_FOUND, description = "No matching record found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class)))
    })
    @DeleteMapping(value = "/{id}")
    public void deleteTool(@PathVariable(name = "id") Long id) {
        toolService.deleteTool(id);
    }
}
