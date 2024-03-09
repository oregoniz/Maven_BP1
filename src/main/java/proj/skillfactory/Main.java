package proj.skillfactory;

import proj.skillfactory.comparators.ComparatorStudents;
import proj.skillfactory.comparators.ComparatorUniver;
import proj.skillfactory.enums.EnumCompareStudents;
import proj.skillfactory.enums.EnumCompareUniver;
import proj.skillfactory.objects.Statistics;
import proj.skillfactory.objects.Student;
import proj.skillfactory.objects.University;
import proj.skillfactory.readWrite.FileReader;
import proj.skillfactory.util.JsonUtil;
import proj.skillfactory.util.StatUtil;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Stream;

import static proj.skillfactory.comparators.ChooseComparator.StudComparator;
import static proj.skillfactory.comparators.ChooseComparator.UniverComparator;
import static proj.skillfactory.readWrite.FileReader.studentsArr;
import static proj.skillfactory.readWrite.FileReader.universityArr;
import static proj.skillfactory.readWrite.XlsWriter.xlsGenerator;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {


        FileReader.fileRead("src/main/resources/universityInfo.xlsx");

        ComparatorStudents comparatorStudents = StudComparator(EnumCompareStudents.StudentsComparatorByName);
        ComparatorUniver comparatorUniver = UniverComparator(EnumCompareUniver.UnivComparatorByYearOfFoundation);

        studentsArr.sort(comparatorStudents);
        universityArr.sort(comparatorUniver);

        Stream<Student> studentStream = studentsArr.stream();
        Stream<University> universityStream = universityArr.stream();
        studentStream.forEach(System.out::println);
        universityStream.forEach(System.out::println);
        studentStream.close();
        universityStream.close();

        String stringStudSerialized = JsonUtil.SerializeStudArr(studentsArr);
        System.out.println(stringStudSerialized);
        String stringUniverSerialized = JsonUtil.SerializeUniverArr(universityArr);
        System.out.println(stringUniverSerialized);

        ArrayList<Student> studReturnedArr = JsonUtil.DeSerializeStudArr(stringStudSerialized);
        ArrayList<University> univerReturnedArr = JsonUtil.DeSerializeUniverArr(stringUniverSerialized);

        if (studentsArr.size() == studReturnedArr.size() && universityArr.size() == univerReturnedArr.size()) {
            System.out.println("Количество элементов совпадает");
        } else System.out.println("ОШИБКА!!!! Количество элементов не совпадает");

        Stream<Student> studentStreamFin = studentsArr.stream();
        studentStreamFin.forEach(student -> {
            String itString = JsonUtil.SerializeStud(student);
            System.out.println(itString);
            Student itStud = JsonUtil.DeSerializeStud(itString);
            System.out.println(itStud);
        });

        ArrayList<Statistics> statArr = StatUtil.GetStatistics(studentsArr, universityArr);
        xlsGenerator(statArr, "src/main/resources/Statistics.xlsx");
    }
}
