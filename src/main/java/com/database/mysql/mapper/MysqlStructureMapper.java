package com.database.mysql.mapper;

import com.database.mysql.dto.mysql.structure.ColumnsInfoDTO;
import com.database.mysql.dto.mysql.structure.TableInfoDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author chenjy
 * @date 2022/4/2 11:38
 * @desc
 */
public interface MysqlStructureMapper {


    /**
     * 根据库名获取表信息
     * @param tableSchema
     * @return
     */
    List<TableInfoDTO> listTable(@Param("tableSchema") String tableSchema);

    /**
     * 根据库名获取字段信息
     * @param tableSchema
     * @return
     */
    List<ColumnsInfoDTO> listColumn(@Param("tableSchema") String tableSchema);


}
