package com.dockerbt.api.repositories;

import com.dockerbt.api.domain.Tool;
import com.dockerbt.api.dtos.ToolDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ToolRepository
{
    private List<Tool> toolList = new ArrayList<>();
    
    public ToolRepository() {
        Tool tool = new Tool();
        tool.setId(1L);
        tool.setToolNumber("123/456");
        tool.setDepartment("GC");
        tool.setSerialNumber("77899");
        tool.setDateInUse(LocalDateTime.of(2023, 5, 16, 7, 31));
        this.toolList.add(tool);
    }

    public Tool getToolById(Long toolId) {
        final Tool output = null;
        for (Tool t: toolList) {
            if (t.getId() == toolId)
                return t;
        }
        return null;
    }

    public Tool addTool(Tool tool) {
        Long id = toolList.get(toolList.size() - 1).getId();
        Tool newTool = tool;
        newTool.setId(id + 1);
        toolList.add(newTool);
        return tool;
    }
    public Tool updateTool(Tool tool, Long id) {
        Tool updateTool = getToolById(id);
        updateTool.setToolNumber(tool.getToolNumber());
        updateTool.setDepartment(tool.getDepartment());
        updateTool.setSerialNumber(tool.getSerialNumber());
        updateTool.setDateInUse(tool.getDateInUse());
        return updateTool;
    }
    public void deleteTool(Long id) {
        Tool deleteTool = getToolById(id);
        toolList.remove(deleteTool);
    }
}
