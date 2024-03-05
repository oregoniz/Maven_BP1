package proj.skillfactory.comparators;

import proj.skillfactory.objects.Student;

public class StudentsComparatorByAvgExamScore implements ComparatorStudents {

    @Override
    public int compare(Student o1, Student o2) {

        return Float.compare(o1.getAvgExamScore(), o2.getAvgExamScore());
    }
}
