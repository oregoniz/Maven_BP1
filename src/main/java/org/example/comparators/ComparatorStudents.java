package org.example.comparators;

//import org.apache.commons.codec.binary.StringUtils;

import org.apache.commons.lang3.StringUtils;
import org.example.objects.Student;

import java.util.Comparator;

public abstract interface ComparatorStudents extends Comparator<Student> {


    public class StudentsComparatorByName implements ComparatorStudents {

        @Override
        public int compare(Student o1, Student o2) {

            return StringUtils.compare(o1.getFullName(), o2.getFullName());

        }
    }

    public static class StudentsComparatorByCourceNumber implements ComparatorStudents {

        @Override
        public int compare(Student o1, Student o2) {

            return Integer.compare(o1.getCurrentCourseNumber(), o2.getCurrentCourseNumber());
        }
    }

    public static class StudentsComparatorByUnivId implements ComparatorStudents {

        @Override
        public int compare(Student o1, Student o2) {
            return StringUtils.compare(o1.getUniversityId(), o2.getUniversityId());
        }
    }

    public static class StudentsComparatorByAvgExamScore implements ComparatorStudents {

        @Override
        public int compare(Student o1, Student o2) {

            return Float.compare(o1.getAvgExamScore(),o2.getAvgExamScore());
        }
    }
}

