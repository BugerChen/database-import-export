package com.database.mysql.dto.mysql.structure;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ContentFontStyle;
import com.alibaba.excel.annotation.write.style.HeadFontStyle;
import com.alibaba.excel.annotation.write.style.HeadStyle;
import com.alibaba.excel.enums.poi.FillPatternTypeEnum;
import com.alibaba.excel.enums.poi.HorizontalAlignmentEnum;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

/**
 * COLUMNS
 * @author 
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@HeadStyle(fillPatternType = FillPatternTypeEnum.SOLID_FOREGROUND, fillForegroundColor = 57,horizontalAlignment = HorizontalAlignmentEnum.CENTER)
@HeadFontStyle(fontHeightInPoints = 10)
@ContentFontStyle(fontHeightInPoints = 10)
public class ExportColumnsInfoDTO implements Serializable {


    /**
     * 列
     */
    @ExcelProperty(value = "列",index = 0)
    String columnName;

    /**
     * 名称
     */
    @ExcelProperty(value = "名称",index = 1)
    String columnComment;


    /**
     * 业务讲解
     */
    @ExcelProperty(value = "业务讲解",index = 2)
    String columnDesc;

    /**
     * 类型
     */
    @ExcelProperty(value = "类型",index = 3)
    String columnType;

    /**
     * 默认值
     */
    @ExcelProperty(value = "默认值",index = 4)
    String columnDefault;

    /**
     * 是否可以为空
     */
    @ExcelProperty(value = "是否可以为空",index = 5)
    String isNullable;


    /**
     * 是否主键
     */
    @ExcelProperty(value = "是否主键",index = 6)
    String isKey;

    /**
     * 主键类型
     */
    @ExcelProperty(value = "主键类型",index = 7)
    String columnKey;


    /**
     * 是否枚举
     */
    @ExcelProperty(value = "是否枚举",index = 8)
    String isEnum;



    /**
     * 枚举值
     */
    @ExcelProperty(value = "枚举值 ",index = 9)
    String enumValue;


    /**
     * 库名
     */
    @ExcelProperty(value = "库名",index = 10)
    String tableSchema;



    /**
     * 表名
     */
    @ExcelProperty(value = "表名",index = 11)
    String tableName;


    /**
     * 表简称
     */
    @ExcelProperty(value = "表简称",index = 12)
    String tableComment;

}