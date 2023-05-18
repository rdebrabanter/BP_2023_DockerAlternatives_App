package com.dockerbt.api.services.impl;

import com.dockerbt.api.domain.Tool;
import com.dockerbt.api.dtos.ToolDto;
import com.dockerbt.api.mappers.ToolMapper;
import com.dockerbt.api.repositories.ToolRepository;
import com.dockerbt.api.services.ToolService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class ToolServiceImpl implements ToolService
{
    private ToolRepository toolRepository;

    private final ToolMapper toolMapper;

    @Override
    public ToolDto getToolById(Long toolId)
    {
        return toolMapper.toolToToolDto(toolRepository.getToolById(toolId));
    }

    @Override
    public ToolDto addTool(ToolDto toolDto) {
        Tool tool = toolMapper.toolDtoToTool(toolDto);
        return toolMapper.toolToToolDto(toolRepository.addTool(tool));
    }

    @Override
    public ToolDto updateTool(ToolDto toolDto, Long id) {
        Tool tool = toolMapper.toolDtoToTool(toolDto);
        return toolMapper.toolToToolDto(toolRepository.updateTool(tool, id));
    }

    @Override
    public void deleteTool(Long id) {
        toolRepository.deleteTool(id);
    }
}
