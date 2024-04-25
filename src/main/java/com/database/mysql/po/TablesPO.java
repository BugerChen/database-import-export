package com.database.mysql.po;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * TABLES
 * @author 
 */
@Data
public class TablesPO implements Serializable {
    private String tableCatalog;

    private String tableSchema;

    private String tableName;

    private String tableType;

    private String engine;

    private Long version;

    private String rowFormat;

    private Long tableRows;

    private Long avgRowLength;

    private Long dataLength;

    private Long maxDataLength;

    private Long indexLength;

    private Long dataFree;

    private Long autoIncrement;

    private Date createTime;

    private Date updateTime;

    private Date checkTime;

    private String tableCollation;

    private Long checksum;

    private String createOptions;

    private String tableComment;

    private static final long serialVersionUID = 1L;
}