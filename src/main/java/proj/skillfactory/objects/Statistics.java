package proj.skillfactory.objects;

import proj.skillfactory.enums.StudyProfile;

public class Statistics {
    StudyProfile mainProfile;
    String avgExamScore;
    int StudNumStudyProfile;
    int UnivNumStudyProfile;
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
