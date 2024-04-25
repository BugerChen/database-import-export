package com.database.mysql.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import com.database.mysql.config.CustomCellWriteHeightConfig;
import com.database.mysql.dto.mysql.structure.*;
import com.database.mysql.ftp.FtpConfiguration;
import com.database.mysql.ftp.FtpServer;
import com.database.mysql.mapper.MysqlStructureMapper;
import com.database.mysql.service.MysqlStructureExportService;
import com.database.mysql.utils.BeanUtil;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.jetty.http.HttpURI;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @author chenjy
 * @date 2022/4/2 11:33
 * @desc
 */
@Slf4j
@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MysqlStructureExportServiceImpl implements MysqlStructureExportService {



    MysqlStructureMapper mapper;

    FtpServer ftpServer;

    FtpConfiguration ftpConfiguration;

    final static String YES = "YES";

    final static String NO = "NO";

    private static final int MAX_SENSITIVE_SHEET_NAME_LEN = 31;


    private static final int SUBSTRING_SENSITIVE_SHEET_NAME_LEN = 18;

    private static final String COLUMN_FILE_PATH = "D:\\";


    @Override
    public ExportResponseDTO export(ExportRequestDTO dto) throws Exception{

        ExportResponseDTO exportResponseDTO = new ExportResponseDTO();

        exportResponseDTO.setTableFile(exportTable(dto).getTableFile());
        exportResponseDTO.setColumnFile(exportColumn(dto).getColumnFile());
        return exportResponseDTO;

    }


    @Override
    public ExportResponseDTO exportColumn(ExportRequestDTO dto) {

        String tableSchema = dto.getTableSchema();

        String tableSchemaAlias = dto.getTableSchemaAlias() == null ? dto.getTableSchema():dto.getTableSchemaAlias();

        String columnFileName = tableSchemaAlias+"表明细"+".xlsx";


        ExportResponseDTO responseDTO = new ExportResponseDTO();

        String columnFilePath  = COLUMN_FILE_PATH+columnFileName;


        ExcelWriter columnWriter = EasyExcel.write(columnFilePath, ExportColumnsInfoDTO.class)
                .registerWriteHandler(new CustomCellWriteHeightConfig())
                .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy())
                .build();


        exportColumnDate(columnWriter,tableSchema,tableSchemaAlias);



        responseDTO.setColumnFile(columnFilePath);

        return responseDTO;
    }

    @Override
    public ExportResponseDTO exportTable(ExportRequestDTO dto) throws Exception{

        String tableSchema = dto.getTableSchema();
        String tableSchemaAlias = dto.getTableSchemaAlias() == null ? dto.getTableSchema():dto.getTableSchemaAlias();
        String tableFileName = tableSchemaAlias+"表概述"+".xlsx";
        ByteArrayOutputStream tableOutputStream = new ByteArrayOutputStream();


        ExportResponseDTO responseDTO = new ExportResponseDTO();

        String tableFilePath  = COLUMN_FILE_PATH+tableFileName;

        //获取表信息
        List<TableInfoDTO> tableInfoDTOS = mapper.listTable(tableSchema);
        List<ExportTableInfoDTO> tableInfoDTOList = tableInfoDTOS.stream().map(table -> {
            ExportTableInfoDTO tableInfoDTO = BeanUtil.copy(table, ExportTableInfoDTO.class);
            tableInfoDTO.setCreator(dto.getCreator());
            tableInfoDTO.setTeam(dto.getTeam());
            return tableInfoDTO;
        }).collect(Collectors.toList());

        EasyExcel.write(tableFilePath,ExportTableInfoDTO.class).registerWriteHandler(new LongestMatchColumnWidthStyleStrategy()).sheet(tableSchemaAlias).doWrite(tableInfoDTOList);


        responseDTO.setTableFile(tableFilePath);



        return responseDTO;
    }

    @SneakyThrows
    private void exportColumnDate(ExcelWriter columnWriter, String tableSchema, String tableSchemaAlias){
        //获取字段信息
        List<ColumnsInfoDTO> columnsInfoDTOS = mapper.listColumn(tableSchema);
        List<ExportColumnsInfoDTO> exportColumnsInfoDTOS = BeanUtil.copyList(columnsInfoDTOS, ExportColumnsInfoDTO.class);
        Map<String, List<ExportColumnsInfoDTO>> listMap = exportColumnsInfoDTOS.stream().collect(Collectors.groupingBy(ExportColumnsInfoDTO::getTableName));
        AtomicInteger i = new AtomicInteger(0);
        listMap.forEach((k,v) ->{
            // 每次都要创建writeSheet 这里注意必须指定sheetNo 而且sheetName必须不一样
            v.forEach(column ->{
                if ("enable_flag".equalsIgnoreCase(column.getColumnName())){
                    column.setColumnComment("逻辑删除标志，Y正常，N删除");
                    column.setIsEnum(YES);
                }
                //取别名
                column.setTableSchema(tableSchemaAlias);
            });
            //excel的sheet名称长度不能超过31，为了避免sheet相同报错，改成时间戳
            if (k.length() > MAX_SENSITIVE_SHEET_NAME_LEN) {
                k = k.substring(0, SUBSTRING_SENSITIVE_SHEET_NAME_LEN)+System.currentTimeMillis();
            }
            WriteSheet writeSheet = EasyExcel.writerSheet(i.getAndIncrement(), k).build();
            columnWriter.write(v, writeSheet);
        });

        columnWriter.finish();
    }
}
