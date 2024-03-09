package proj.skillfactory.readWrite;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import proj.skillfactory.enums.StudyProfile;
import proj.skillfactory.objects.Student;
import proj.skillfactory.objects.University;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class FileReader {
    private FileReader() {
    }

    public static ArrayList<Student> studentsArr;
    public static ArrayList<University> universityArr;

    public static void fileRead(String file) {
        FileInputStream fis = null;


        XSSFWorkbook wb = null;
        {
            try {
                fis = new FileInputStream(file);
                wb = new XSSFWorkbook(fis);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


        XSSFSheet sheetStud = wb.getSheetAt(0);
        XSSFSheet sheetUniver = wb.getSheetAt(1);
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
        return universityArr;
    }
}




