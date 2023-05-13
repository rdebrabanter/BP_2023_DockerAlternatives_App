package com.dockerbt.api.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "tool")
public class Tool
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "tool_number")
    private String toolNumber;

    @Column(name = "department")
    private String department;

    @Column(name = "serial_number")
    private String serialNumber;

    @Column(name = "date_in_use")
    private LocalDateTime dateInUse;
}