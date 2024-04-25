package com.database.mysql.dto.mysql.structure;

import lombok.Data;

import java.io.Serializable;

/**
 * COLUMNS
 * @author 
 */
@Data
public class ColumnsInfoDTO implements Serializable {
    String tableCatalog;

    String tableSchema;

    String tableName;

    String tableComment;

    String columnName;

    Long ordinalPosition;

    String columnDefault;

    String isNullable;

    String dataType;

    Long characterMaximumLength;

    Long characterOctetLength;

    Long numericPrecision;

    Long numericScale;

    Long datetimePrecision;

    String characterSetName;

    String collationName;

    String columnType;

    String isKey;

    String columnKey;

    String extra;

    String privileges;

    String columnComment;

    String generationExpression;

    static final long serialVersionUID = 1L;
}