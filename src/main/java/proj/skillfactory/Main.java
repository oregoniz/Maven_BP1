package proj.skillfactory;

import proj.skillfactory.comparators.ComparatorStudents;
import proj.skillfactory.comparators.ComparatorUniver;
import proj.skillfactory.enums.EnumCompareStudents;
import proj.skillfactory.enums.EnumCompareUniver;
import proj.skillfactory.objects.Statistics;
import proj.skillfactory.readWrite.FileReader;
import proj.skillfactory.util.StatUtil;

import java.io.IOException;
import java.util.ArrayList;

import static proj.skillfactory.comparators.ChooseComparator.StudComparator;
import static proj.skillfactory.comparators.ChooseComparator.UniverComparator;
import static proj.skillfactory.readWrite.FileReader.studentsArr;
import static proj.skillfactory.readWrite.FileReader.universityArr;
import static proj.skillfactory.readWrite.XlsWriter.xlsGenerator;

import java.util.logging.LogManager;
import java.util.logging.Logger;
import static java.util.logging.Level.INFO;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        logger.log(INFO, "Программа запущена.");
        try {
            LogManager.getLogManager().readConfiguration(
                    Main.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e) {
            System.err.println("Не удалось сконфигурировать логгер: " + e.toString());
        }
        logger.log(INFO, "Логгер сконфигурирован");

        FileReader.fileRead("src/main/resources/universityInfo.xlsx");

        ComparatorStudents comparatorStudents = StudComparator(EnumCompareStudents.StudentsComparatorByName);
        ComparatorUniver comparatorUniver = UniverComparator(EnumCompareUniver.UnivComparatorByYearOfFoundation);

        studentsArr.sort(comparatorStudents);
        universityArr.sort(comparatorUniver);

        ArrayList<Statistics> statArr = StatUtil.GetStatistics(studentsArr, universityArr);
        xlsGenerator(statArr, "src/main/resources/Statistics.xlsx");
        logger.log(INFO, "Программа успешно завершена.");
    }
}
