package proj.skillfactory.objects;

import javax.xml.bind.annotation.*;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class AllInfo {
    @XmlElementWrapper(name = "studentsInfo")
    @XmlElement(name = "studentEntry")
    private List<Student> studentList;

    @XmlElementWrapper(name = "universitiesInfo")
    @XmlElement(name = "universityEntry")
    private static List<University> universityList;

    @XmlElementWrapper(name = "statisticalInfo")
    @XmlElement(name = "statisticsEntry")
    private List<Statistics> statisticsList;@XmlElement(name = "processedAt")

    private Date processDate;

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public static List<University> getUniversityList() {
        return universityList;
    }
    public void setUniversityList(List<University> universityList) {
        this.universityList = universityList;
    }

    public List<Statistics> getStatisticsList() {
        return statisticsList;
    }

    public void setStatisticsList(List<Statistics> statisticsList) {
        this.statisticsList = statisticsList;
    }

    public Date getProcessDate() {
        return processDate;
    }

    public void setProcessDate(Date processDate) {
        this.processDate = processDate;
    }
}
