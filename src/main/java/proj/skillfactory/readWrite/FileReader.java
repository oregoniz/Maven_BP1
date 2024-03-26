package proj.skillfactory.readWrite;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import proj.skillfactory.Main;
import proj.skillfactory.enums.StudyProfile;
import proj.skillfactory.objects.Student;
import proj.skillfactory.objects.University;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileReader {
    private static final java.util.logging.Logger logger = Logger.getLogger(Main.class.getName());

    private FileReader() {
    }

    public static ArrayList<Student> studentsArr;
    public static ArrayList<University> universityArr;

    public static void fileRead(String file) {
        FileInputStream fis;
        XSSFWorkbook wb;

        try {
            fis = new FileInputStream(file);
            wb = new XSSFWorkbook(fis);
            logger.log(Level.INFO,"Файл открыт");

        } catch (IOException e) {
            logger.log(Level.SEVERE,"Файл не открыт");
            throw new RuntimeException(e);
        }

        XSSFSheet sheetStud = null;
        XSSFSheet sheetUniver = null;
        try {
            sheetStud = wb.getSheetAt(0);
            sheetUniver = wb.getSheetAt(1);
            logger.log(Level.INFO,"Листы 1, 2 файла получены.");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        FileReader.studentsArr = getStudArr(sheetStud);
        FileReader.universityArr = getUnivArr(sheetUniver);
    }

    public static ArrayList<Student> getStudArr(XSSFSheet sheet) {
        studentsArr = new ArrayList<>();
        Iterator<Row> rowIterator = sheet.iterator();
        Row row = rowIterator.next();

        while (rowIterator.hasNext()) {
            row = rowIterator.next();
            Iterator<Cell> cells = row.iterator();
            while (cells.hasNext()) {

                Cell cell = cells.next();
                String universityId = cell.getStringCellValue();

                cell = cells.next();
                String fullName = cell.getStringCellValue();

                cell = cells.next();
                int currentCourseNumber = (int) cell.getNumericCellValue();

                cell = cells.next();
                float avgExamScore = (float) cell.getNumericCellValue();

                Student student = new Student(fullName, universityId, currentCourseNumber, avgExamScore);
                studentsArr.add(student);
            }
        }
        logger.log(Level.INFO,"таблица студентов прочитана, количество: "+ studentsArr.size());
        return studentsArr;
    }

    public static ArrayList<University> getUnivArr(XSSFSheet sheet) {
        ArrayList<University> universityArr = new ArrayList<>();
        Iterator<Row> rowIterator = sheet.iterator();
        Row row = rowIterator.next();

        while (rowIterator.hasNext()) {
            row = rowIterator.next();
            Iterator<Cell> cells = row.iterator();
            while (cells.hasNext()) {

                Cell cell = cells.next();

                String uni_id = cell.getStringCellValue();
                cell = cells.next();
                String fullName = cell.getStringCellValue();
                cell = cells.next();
                String shortName = cell.getStringCellValue();
                cell = cells.next();
                int yearOfFoundation = (int) cell.getNumericCellValue();
                cell = cells.next();
                StudyProfile mainProfile = StudyProfile.valueOf(cell.getStringCellValue());
                University university = new University(uni_id, fullName, shortName, yearOfFoundation, mainProfile);

                universityArr.add(university);
            }
        }
        logger.log(Level.INFO,"таблица университетов прочитана, количество: "+universityArr.size());
        return universityArr;
    }
}




