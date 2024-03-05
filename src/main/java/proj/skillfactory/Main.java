package proj.skillfactory;

import proj.skillfactory.comparators.ComparatorStudents;
import proj.skillfactory.comparators.ComparatorUniver;
import proj.skillfactory.enums.EnumCompareStudents;
import proj.skillfactory.enums.EnumCompareUniver;
import proj.skillfactory.objects.Student;
import proj.skillfactory.objects.University;

import java.util.stream.Stream;

import static proj.skillfactory.comparators.ChooseComparator.StudComparator;
import static proj.skillfactory.comparators.ChooseComparator.UniverComparator;

public class Main {
    public static void main(String[] args) {


        FileReader.fileRead("universityInfo.xlsx");

        ComparatorStudents comparatorStudents = StudComparator(EnumCompareStudents.StudentsComparatorByName);
        ComparatorUniver comparatorUniver = UniverComparator(EnumCompareUniver.UnivComparatorByYearOfFoundation);

        FileReader.studentsArr.sort(comparatorStudents);
        FileReader.universityArr.sort(comparatorUniver);

        Stream<Student> studentStream = FileReader.studentsArr.stream();
        Stream<University> universityStream = FileReader.universityArr.stream();

        studentStream.forEach(System.out::println);
        universityStream.forEach(System.out::println);


        Student studentO = new Student("Olga", "MSU", 4, 4);
        JsonUtil.SerializeStud(studentO);
        // JsonUtil.DeSerializeStud();
    }


}
