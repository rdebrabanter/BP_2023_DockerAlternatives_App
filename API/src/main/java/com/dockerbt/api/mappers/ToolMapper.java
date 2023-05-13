package com.dockerbt.api.mappers;

import com.dockerbt.api.domain.Tool;
import com.dockerbt.api.dtos.ToolDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ToolMapper
{
    List<ToolDto> toolListToToolDtoList(List<Tool> all);
    ToolDto toolToToolDto(Tool data);
    Tool toolDtoToTool(ToolDto data);
}
