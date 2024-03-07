package proj.skillfactory;

import proj.skillfactory.comparators.ComparatorStudents;
import proj.skillfactory.comparators.ComparatorUniver;
import proj.skillfactory.enums.EnumCompareStudents;
import proj.skillfactory.enums.EnumCompareUniver;
import proj.skillfactory.objects.Student;
import proj.skillfactory.objects.University;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Stream;

import static proj.skillfactory.FileReader.studentsArr;
import static proj.skillfactory.FileReader.universityArr;
import static proj.skillfactory.comparators.ChooseComparator.StudComparator;
import static proj.skillfactory.comparators.ChooseComparator.UniverComparator;

public class Main {
    public static void main(String[] args) {


        FileReader.fileRead("universityInfo.xlsx");

        ComparatorStudents comparatorStudents = StudComparator(EnumCompareStudents.StudentsComparatorByName);
        ComparatorUniver comparatorUniver = UniverComparator(EnumCompareUniver.UnivComparatorByYearOfFoundation);

        studentsArr.sort(comparatorStudents);
        universityArr.sort(comparatorUniver);

        Stream<Student> studentStream = studentsArr.stream();
        Stream<University> universityStream = universityArr.stream();
        studentStream.forEach(System.out::println);
        universityStream.forEach(System.out::println);
        //   studentStream.close();
        //   universityStream.close();

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
        Iterator<Student> itrS = studentStreamFin.iterator();
        String its = null;
        Student isstud = null;
        while (itrS.hasNext()) {
            its = JsonUtil.SerializeStud(itrS.next());
            System.out.println(its);
            isstud = JsonUtil.DeSerializeStud(its);
            System.out.println(isstud);
        }
    }
}
