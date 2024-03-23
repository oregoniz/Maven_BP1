package proj.skillfactory.comparators;

import proj.skillfactory.enums.EnumCompareUniver;
import proj.skillfactory.enums.EnumCompareStudents;

public class ChooseComparator {

    public ChooseComparator() {
    }

    public static ComparatorStudents StudComparator(EnumCompareStudents enumCompareStudents) {

        switch (enumCompareStudents) {
            case StudentsComparatorByName -> {
                return new StudentsComparatorByName();
            }
            case StudentsComparatorByCourceNumber -> {
                return new StudentsComparatorByCourceNumber();
            }
            case StudentsComparatorByUnivId -> {
                return new StudentsComparatorByUnivId();
            }
            case StudentsComparatorByAvgExamScore -> {
                return new StudentsComparatorByAvgExamScore();
            }

        }
        return null;
    }

    public static ComparatorUniver UniverComparator(EnumCompareUniver enumCompareUniver) {

        switch (enumCompareUniver) {
            case UnivComparatorByName -> {
                return new UnivComparatorByName();
            }
            case UnivComparatorByMainProfile -> {
                return new UnivComparatorByMainProfile();
            }
            case UnivComparatorById -> {
                return new UnivComparatorById();
            }
            case UnivComparatorByShortName -> {
                return new UnivComparatorByShortName();
            }

            case UnivComparatorByYearOfFoundation -> {
                return new UnivComparatorByYearOfFoundation();
            }

        }
        return null;
    }
}