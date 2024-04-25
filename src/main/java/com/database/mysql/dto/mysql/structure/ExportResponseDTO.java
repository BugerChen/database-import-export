package com.database.mysql.dto.mysql.structure;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * @author chenjy
 * @date 2022/4/2 17:43
 * @desc
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExportResponseDTO {

    String tableFile;
    String columnFile;
    String alterSql;
}
