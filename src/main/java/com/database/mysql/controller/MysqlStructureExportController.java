package com.database.mysql.controller;

import com.database.mysql.dto.mysql.structure.ExportRequestDTO;
import com.database.mysql.dto.mysql.structure.ExportResponseDTO;
import com.database.mysql.service.MysqlStructureExportService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenjy
 * @date 2022/4/2 11:24
 * @desc
 */
@RestController
@AllArgsConstructor
@RequestMapping("mysqlStructure")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MysqlStructureExportController {


    MysqlStructureExportService mysqlStructureExportService;

    @PostMapping("export")
    public ExportResponseDTO export (@RequestBody ExportRequestDTO dto) throws Exception{

        return mysqlStructureExportService.export(dto);

    }

    @PostMapping("exportColumn")
    public ExportResponseDTO exportColumn (@RequestBody ExportRequestDTO dto) throws Exception{

        return mysqlStructureExportService.exportColumn(dto);

    }

    @PostMapping("exportTable")
    public ExportResponseDTO exportTable (@RequestBody ExportRequestDTO dto) throws Exception{

        return mysqlStructureExportService.exportTable(dto);

    }

}
