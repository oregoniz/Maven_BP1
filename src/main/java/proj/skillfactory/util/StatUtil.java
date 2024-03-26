package proj.skillfactory.util;

import proj.skillfactory.Main;
import proj.skillfactory.enums.StudyProfile;
import proj.skillfactory.objects.Statistics;
import proj.skillfactory.objects.Student;
import proj.skillfactory.objects.University;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class StatUtil {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static ArrayList<Statistics> GetStatistics(ArrayList<Student> studentArrayList, ArrayList<University> universityArrayList) {
        logger.log(Level.INFO, "Сбор статистики запущен.");
        ArrayList<Statistics> statisticsArrayList = new ArrayList<>();
        Set<StudyProfile> profiles = getAllProfiles(universityArrayList);

        profiles.forEach(profile -> {
            Statistics statistics = new Statistics(profile);
            List<University> univArrByProf = universityArrayList.stream().filter(university -> university.getMainProfile() == profile).toList();
            statistics.setUniversityNames(getUniverNames(univArrByProf).toString());
            statistics.setUnivNumStudyProfile(univArrByProf.size());

            List<Student> studUnivByProf = studentArrayList.stream().filter(student -> getUniverIds(univArrByProf).contains(student.getUniversityId())).toList();
            statistics.setStudNumStudyProfile(studUnivByProf.size());
            double avSSum = studUnivByProf.stream().mapToDouble(Student::getAvgExamScore).sum();
            Optional<Double> avS = Optional.of(avSSum / studUnivByProf.size());

            if (!avS.get().isNaN()) {
                BigDecimal bd = BigDecimal.valueOf(avS.get()).setScale(2, RoundingMode.HALF_UP);
                statistics.setAvgExamScore(bd.toString());
            } else statistics.setAvgExamScore("0");

            statisticsArrayList.add(statistics);
        });

        logger.log(Level.INFO,"Статистика собрана. Обработано объектов: "+statisticsArrayList.size());
                return statisticsArrayList;
    }

    private static List<String> getUniverIds(List<University> univArrByProf) {

        List<String> rezArr = new ArrayList<>();
        for (University university : univArrByProf) {
            rezArr.add(university.getId());
        }
        return rezArr;
    }

    private static StringBuilder getUniverNames(List<University> univArrByProf) {
        StringBuilder name = new StringBuilder();
        for (University university : univArrByProf) {
            if (name.isEmpty()) name = new StringBuilder(university.getFullName());
            else name.append(", ").append(university.getFullName());
        }
        return name;
    }

    public static Set<StudyProfile> getAllProfiles(ArrayList<University> universityArrayList) {
        Set<StudyProfile> profiles = new HashSet<>();
        universityArrayList.forEach(university -> profiles.add(university.getMainProfile()));
        return profiles;
    }

}
