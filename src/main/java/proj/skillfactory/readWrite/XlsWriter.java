package proj.skillfactory.readWrite;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.*;
import proj.skillfactory.Main;
import proj.skillfactory.objects.Statistics;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XlsWriter {
    private static final java.util.logging.Logger logger = Logger.getLogger(Main.class.getName());

    public XlsWriter() {
    }

    public static void xlsGenerator(ArrayList<Statistics> arrayStat, String filePath) {

        logger.log(Level.INFO, "Запуск записи статистики.");
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFFont font = wb.createFont();
        font.setFontName("Verdana");
        font.setBold(true);
        font.setFontHeightInPoints((short) 12);
        CellStyle style = wb.createCellStyle();
        style.setFont(font);

        try {
            XSSFSheet sheet = wb.createSheet("Statistics");
            XSSFRow row = sheet.createRow(0);
            row.setRowStyle(style);
            row.createCell(0).setCellValue("Профиль обучения");
            row.createCell(1).setCellValue("Средний балл");
            row.createCell(2).setCellValue("Количество студентов по профилю");
            row.createCell(3).setCellValue("Количество университетов по профилю");
            row.createCell(4).setCellValue("Названия университетов");

            for (int i = 0; i < arrayStat.size(); i++) {
                row = sheet.createRow(i + 1);
                row.createCell(0).setCellValue(arrayStat.get(i).getMainProfile().toString());
                row.createCell(1).setCellValue(arrayStat.get(i).getAvgExamScore());
                row.createCell(2).setCellValue(arrayStat.get(i).getStudNumStudyProfile());
                row.createCell(3).setCellValue(arrayStat.get(i).getUnivNumStudyProfile());
                row.createCell(4).setCellValue(arrayStat.get(i).getUniversityNames());

            }


            FileOutputStream fileOut = new FileOutputStream(filePath);
            wb.write(fileOut);
            fileOut.close();
            logger.log(Level.INFO,"Файл статистики записан");
        } catch (Exception ex) {
            logger.log(Level.SEVERE,"Ошибка записи файла статистики");
        }
    }
}
