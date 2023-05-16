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
        Tool toolOpt = toolRepository.getToolById(toolId);

        return toolMapper.toolToToolDto(toolOpt);
    }

    @Override
    public ToolDto addTool(ToolDto toolDto) {
        return null;
    }

    @Override
    public ToolDto updateTool(ToolDto toolDto, Long id) {
        return null;
    }

    @Override
    public void deleteTool(Long id) {

    }


}
