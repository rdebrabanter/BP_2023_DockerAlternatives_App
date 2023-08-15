package com.dockerbt.api.services.impl;

import com.dockerbt.api.domain.Tool;
import com.dockerbt.api.dtos.ToolDto;
import com.dockerbt.api.exceptions.BadRequestException;
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
    public Optional<ToolDto> getToolById(Long toolId)
    {
        return toolRepository.getToolById(toolId).map(toolMapper::toolToToolDto);
    }

    @Override
    public ToolDto addTool(ToolDto toolDto) {
        if (toolRepository.findToolById(toolDto.getId()).isPresent()) {
            throw new BadRequestException("Tool already exists");
        }
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
