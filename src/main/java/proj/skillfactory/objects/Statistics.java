package proj.skillfactory.objects;

import proj.skillfactory.enums.StudyProfile;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlAccessorType(XmlAccessType.FIELD)
public class Statistics {
    @XmlElement(name = "universityProfile")
    StudyProfile mainProfile;
    @XmlElement(name = "avgScore")
    String avgExamScore;
    @XmlTransient
    int StudNumStudyProfile;
    @XmlTransient
    int UnivNumStudyProfile;
    @XmlTransient
    String UniversityNames;


    public Statistics(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
    }


    public StudyProfile getMainProfile() {
        return mainProfile;
    }


    public String getAvgExamScore() {
        return avgExamScore;
    }

    public void setAvgExamScore(String avgExamScore) {
        this.avgExamScore = avgExamScore;
    }

    public int getStudNumStudyProfile() {
        return StudNumStudyProfile;
    }

    public void setStudNumStudyProfile(int studNumStudyProfile) {
        StudNumStudyProfile = studNumStudyProfile;
    }

    public int getUnivNumStudyProfile() {
        return UnivNumStudyProfile;
    }

    public void setUnivNumStudyProfile(int univNumStudyProfile) {
        UnivNumStudyProfile = univNumStudyProfile;
    }

    public String getUniversityNames() {
        return UniversityNames;
    }

    public void setUniversityNames(String universityNames) {
        UniversityNames = universityNames;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "mainProfile=" + mainProfile +
                ", avgExamScore=" + avgExamScore +
                ", StudNumStudyProfile=" + StudNumStudyProfile +
                ", UnivNumStudyProfile=" + UnivNumStudyProfile +
                ", UniversityNames=" + UniversityNames +
                '}';
    }

}
