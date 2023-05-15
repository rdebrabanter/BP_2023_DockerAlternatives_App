package com.dockerbt.api.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Tool
{
    private Long id;
    private String toolNumber;
    private String department;
    private String serialNumber;
    private LocalDateTime dateInUse;
}