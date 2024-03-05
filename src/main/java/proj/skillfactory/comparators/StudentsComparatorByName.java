package proj.skillfactory.comparators;

import org.apache.commons.lang3.StringUtils;
import proj.skillfactory.objects.Student;

public class StudentsComparatorByName implements ComparatorStudents {

    @Override
    public int compare(Student o1, Student o2) {

        return StringUtils.compare(o1.getFullName(), o2.getFullName());

    }
}
