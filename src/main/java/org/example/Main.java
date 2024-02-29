package org.example;

import org.example.comparators.ComparatorAll;
import org.example.comparators.ComparatorStudents;
import org.example.comparators.ComparatorUniver;
import org.example.enums.EnumCompareStudents;
import org.example.enums.EnumCompareUniver;
import org.example.objects.Student;
import org.example.objects.University;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {


        FileReader.fileRead("universityInfo.xlsx");

        ComparatorStudents comparatorStudents = ComparatorAll.StudComparator(EnumCompareStudents.StudentsComparatorByName);
        ComparatorUniver comparatorUniver = ComparatorAll.UniverComparator(EnumCompareUniver.UnivComparatorByName);

        FileReader.studentsArr.sort(comparatorStudents);
        FileReader.universityArr.sort(comparatorUniver);

        Stream<Student> studentStream = FileReader.studentsArr.stream();
        Stream<University> universityStream = FileReader.universityArr.stream();

        studentStream.forEach(System.out::println);
        universityStream.forEach(System.out::println);
    }
}
