package proj.skillfactory;

import proj.skillfactory.comparators.ComparatorStudents;
import proj.skillfactory.comparators.ComparatorUniver;
import proj.skillfactory.enums.EnumCompareStudents;
import proj.skillfactory.enums.EnumCompareUniver;
import proj.skillfactory.objects.AllInfo;
import proj.skillfactory.objects.Statistics;
import proj.skillfactory.objects.Student;
import proj.skillfactory.objects.University;
import proj.skillfactory.readWrite.FileReader;
import proj.skillfactory.readWrite.JsonWriter;
import proj.skillfactory.readWrite.XmlWriter;
import proj.skillfactory.util.JsonUtil;
import proj.skillfactory.util.StatUtil;
import java.io.IOException;
import java.util.ArrayList;

import static proj.skillfactory.comparators.ChooseComparator.StudComparator;
import static proj.skillfactory.comparators.ChooseComparator.UniverComparator;
import static proj.skillfactory.readWrite.FileReader.studentsArr;
import static proj.skillfactory.readWrite.FileReader.universityArr;
import static proj.skillfactory.readWrite.XlsWriter.xlsGenerator;

import java.util.Date;
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

        String stringStudSerialized = JsonUtil.SerializeStudArr(studentsArr);
       // System.out.println(stringStudSerialized);
        String stringUniverSerialized = JsonUtil.SerializeUniverArr(universityArr);
        //System.out.println(stringUniverSerialized);

        ArrayList<Student> studReturnedArr = JsonUtil.DeSerializeStudArr(stringStudSerialized);
        ArrayList<University> univerReturnedArr = JsonUtil.DeSerializeUniverArr(stringUniverSerialized);
        if (studentsArr.size() == studReturnedArr.size() && universityArr.size() == univerReturnedArr.size()) {
            logger.log(INFO, "Количество элементов совпадает");
        } else logger.log(INFO, "ОШИБКА!!!! Количество элементов не совпадает");

        /*   String userHome = System.getProperty("user.home");
        File directoryJson = new File(userHome, "jsonReqs");
        if (!directoryJson.exists()) {
            directoryJson.mkdir();
            System.out.println("Создана jsonReqs");
        }
        File directoryXml = new File(userHome, "xmlReqs");
        if (!directoryXml.exists()) {
            directoryXml.mkdir();
            System.out.println("Создана xmlReqs");
        }*/

        ArrayList<Statistics> statArr = StatUtil.GetStatistics(studentsArr, universityArr);
        xlsGenerator(statArr, "src/main/resources/Statistics.xlsx");
        AllInfo allInfo = new AllInfo();
        allInfo.setStudentList(studentsArr);
        allInfo.setUniversityList(universityArr);
        allInfo.setStatisticsList(statArr);
        allInfo.setProcessDate(new Date());

        XmlWriter.generateXmlReq(allInfo);
        JsonWriter.writeJsonReq(allInfo);
        logger.log(INFO, "Программа успешно завершена.");
    }
}
