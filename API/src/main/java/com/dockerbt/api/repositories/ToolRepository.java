package com.dockerbt.api.repositories;

import com.dockerbt.api.domain.Tool;
import com.dockerbt.api.exceptions.NotFoundException;
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

    public Optional<Tool> findToolById(Long toolId) {
        for (Tool t: toolList) {
            if (t.getId() == toolId) {
                return Optional.of(t);
            }
        }
        return Optional.empty();
    }

    public Optional<Tool> getToolById(Long toolId) {
        for (Tool t: toolList) {
            if (t.getId() == toolId) {
                return Optional.of(t);
            }
            else {
                throw new NotFoundException("Tool not found");
            }
        }
        return Optional.empty();
    }

    public Tool addTool(Tool tool) {
        Long id = toolList.get(toolList.size() - 1).getId();
        Tool newTool = tool;
        newTool.setId(id + 1);
        toolList.add(newTool);
        return tool;
    }
    public Tool updateTool(Tool tool, Long id) {
        Tool updateTool = findToolById(id).orElseThrow(() -> new NotFoundException("Tool not found"));
        updateTool.setToolNumber(tool.getToolNumber());
        updateTool.setDepartment(tool.getDepartment());
        updateTool.setSerialNumber(tool.getSerialNumber());
        updateTool.setDateInUse(tool.getDateInUse());
        return updateTool;
    }
    public void deleteTool(Long id) {
        Tool deleteTool = findToolById(id).orElseThrow(() -> new NotFoundException("Tool not found"));
        toolList.remove(deleteTool);
    }
}
