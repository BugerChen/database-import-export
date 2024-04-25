package com.database.mysql.dto.mysql.structure;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ContentFontStyle;
import com.alibaba.excel.annotation.write.style.HeadFontStyle;
import com.alibaba.excel.annotation.write.style.HeadStyle;
import com.alibaba.excel.enums.poi.FillPatternTypeEnum;
import com.alibaba.excel.enums.poi.HorizontalAlignmentEnum;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * @author chenjy
 * @date 2022/4/2 18:08
 * @desc
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@HeadStyle(fillPatternType = FillPatternTypeEnum.SOLID_FOREGROUND, fillForegroundColor = 57,horizontalAlignment = HorizontalAlignmentEnum.CENTER)
@HeadFontStyle(fontHeightInPoints = 10)
@ContentFontStyle(fontHeightInPoints = 10)
public class ExportAlterDTO {

    /**
     * 修改的行，目前只针对注释
     */
    @ExcelProperty(value = "sql模板（目前只针对没有注释的字段生成，没有做过全场景覆盖测试，使用时需要根据字段的具体情况校对sql）",index = 0)
    String alterDefaultSql;

    @ExcelIgnore
    String tableName;


    /**
     * 列
     */
    @ExcelIgnore
    String columnName;

    /**
     * 名称
     */
    @ExcelIgnore
    String columnComment;


    /**
     * 类型
     */
    @ExcelIgnore
    String columnType;

    /**
     * 默认值
     */
    @ExcelIgnore
    String columnDefault;

    /**
     * 是否可以为空
     */
    @ExcelIgnore
    String isNullable;


    /**
     * 是否主键
     */
    @ExcelIgnore
    String isKey;


}
