package com.database.mysql.dto.mysql.structure;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;


/**
 * @author chenjy
 * @date 2022/4/2 11:54
 * @desc
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TableInfoDTO {

    String tableCatalog;

    String tableSchema;

    String tableName;

    String tableType;

    String engine;

    Long version;

    String rowFormat;

    Long tableRows;

    Long avgRowLength;

    Long dataLength;

    Long maxDataLength;

    Long indexLength;

    Long dataFree;

    Long autoIncrement;

    Date createTime;

    Date updateTime;

    Date checkTime;

    String tableCollation;

    Long checksum;

    String createOptions;

    String tableComment;

}
