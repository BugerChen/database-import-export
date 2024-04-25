package com.database.mysql.service;

import com.database.mysql.dto.mysql.structure.ExportRequestDTO;
import com.database.mysql.dto.mysql.structure.ExportResponseDTO;

/**
 * @author chenjy
 * @date 2022/4/2 11:33
 * @desc
 */
public interface MysqlStructureExportService {

    /**
     * 数据库表、字段导出
     * @param dto
     * @return
     * @throws Exception
     */
    ExportResponseDTO export(ExportRequestDTO dto)throws Exception;

    /**
     * 数据库字段导出
     * @param dto
     * @return
     * @throws Exception
     */
    ExportResponseDTO exportColumn(ExportRequestDTO dto)throws Exception;

    /**
     * 数据库表导出
     * @param dto
     * @return
     * @throws Exception
     */
    ExportResponseDTO exportTable(ExportRequestDTO dto)throws Exception;
}
