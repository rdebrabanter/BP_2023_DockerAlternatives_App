package com.dockerbt.api.services;

import com.dockerbt.api.dtos.ToolDto;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public interface ToolService {
    Optional<ToolDto> getToolById(Long toolId);
}