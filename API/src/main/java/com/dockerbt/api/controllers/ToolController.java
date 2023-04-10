package com.dockerbt.api.controllers;

import com.dockerbt.api.constants.ApiResponseConstants;
import com.dockerbt.api.exceptions.handler.ApiError;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@OpenAPIDefinition(tags ={
        @Tag(name="Tool", description = "API to manage tools")})
@RequestMapping("api/tools")
@Validated
@Slf4j
public class ToolController
{
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
}
