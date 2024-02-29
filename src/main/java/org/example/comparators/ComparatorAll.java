package org.example.comparators;

import org.example.enums.EnumCompareUniver;
import org.example.objects.Student;
import org.example.enums.EnumCompareStudents;
import org.example.objects.University;

import java.util.Comparator;

public class ComparatorAll {
    public ComparatorAll() {
    }

    public static ComparatorStudents StudComparator(EnumCompareStudents enumCompareStudents) {

        switch (enumCompareStudents) {
            case StudentsComparatorByName -> {
                return new ComparatorStudents.StudentsComparatorByName();
            }
            case StudentsComparatorByCourceNumber -> {
                return new ComparatorStudents.StudentsComparatorByCourceNumber();
            }
            case StudentsComparatorByUnivId -> {
                return new ComparatorStudents.StudentsComparatorByUnivId();
            }
            case StudentsComparatorByAvgExamScore -> {
                return new ComparatorStudents.StudentsComparatorByAvgExamScore();
            }

        }
        return null;
    }

    public static ComparatorUniver UniverComparator(EnumCompareUniver enumCompareUniver) {

        switch (enumCompareUniver) {
            case UnivComparatorByName -> {
                return new ComparatorUniver.UnivComparatorByName();
            }
            case UnivComparatorByMainProfile -> {
                return new ComparatorUniver.UnivComparatorByMainProfile();
            }
            case UnivComparatorById -> {
                return new ComparatorUniver.UnivComparatorById();
            }
            case UnivComparatorByShortName -> {
                return new ComparatorUniver.UnivComparatorByShortName();
            }

            case UnivComparatorByYearOfFoundation -> {
                return new ComparatorUniver.UnivComparatorByYearOfFoundation();
            }

        }
        return null;
    }
}