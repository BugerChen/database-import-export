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


/**
 * @author chenjy
 * @date 2022/4/2 11:54
 * @desc
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@HeadStyle(fillPatternType = FillPatternTypeEnum.SOLID_FOREGROUND, fillForegroundColor = 57,horizontalAlignment = HorizontalAlignmentEnum.CENTER)
@HeadFontStyle(fontHeightInPoints = 10)
@ContentFontStyle(fontHeightInPoints = 10)
public class ExportTableInfoDTO {



    /**
     * 表名
     */
    @ExcelProperty(value = "表名",index = 0)
    String tableName;

    /**
     * 表简称
     */
    @ExcelProperty(value = "表简称",index = 1)
    String tableComment;

    /**
     * 业务说明
     */
    @ExcelProperty(value = "业务说明",index = 2)
    String tableDesc;


    /**
     * 维护团队
     */
    @ExcelProperty(value = "维护团队",index = 3)
    String team;


    /**
     * 维护人
     */
    @ExcelProperty(value = "维护人",index = 4)
    String creator;

}
