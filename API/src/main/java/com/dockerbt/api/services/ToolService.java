package com.dockerbt.api.services;

import com.dockerbt.api.dtos.ToolDto;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public interface ToolService
//{
//    Optional<ToolDto> getToolById(Long toolId);
//}

        import org.apache.poi.xssf.usermodel.XSSFWorkbook;
        import org.springframework.data.domain.Pageable;
        import org.springframework.http.ResponseEntity;
        import org.springframework.stereotype.Service;

        import java.util.List;
        import java.util.Optional;

@Service
public interface ToolService {
    Optional<ToolDto> getToolById(Long toolId);
}