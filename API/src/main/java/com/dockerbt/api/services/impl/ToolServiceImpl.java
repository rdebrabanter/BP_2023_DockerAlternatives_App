package com.dockerbt.api.services.impl;

import com.dockerbt.api.dtos.ToolDto;
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

//    private final ToolMapper toolMapper;

    @Override
    public Optional<ToolDto> getToolById(Long toolId)
    {
//        Optional<Tool> toolOpt = toolRepository.findById(toolId);

//        return toolOpt.map(toolMapper::toolToToolDto);
        return null;
    }
}
