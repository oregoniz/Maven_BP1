package proj.skillfactory.comparators;

import org.apache.commons.lang3.StringUtils;
import proj.skillfactory.objects.Student;

public class StudentsComparatorByUnivId implements ComparatorStudents {

    @Override
    public int compare(Student o1, Student o2) {
        return StringUtils.compare(o1.getUniversityId(), o2.getUniversityId());
    }
}
