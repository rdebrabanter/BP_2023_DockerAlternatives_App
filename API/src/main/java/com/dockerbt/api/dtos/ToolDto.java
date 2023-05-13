package com.dockerbt.api.dtos;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class ToolDto
{
    private Long id;
    private String toolNumber;
    private String department;
    private String serialNumber;
    private LocalDateTime dateInUse;
}