package com.dockerbt.api.services;

import com.dockerbt.api.dtos.ToolDto;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public interface ToolService {
    ToolDto getToolById(Long toolId);
    ToolDto addTool(ToolDto toolDto);
    ToolDto updateTool(ToolDto toolDto, Long id);
    void deleteTool(Long id);
}