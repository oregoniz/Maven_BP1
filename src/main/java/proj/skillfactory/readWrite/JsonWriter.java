package proj.skillfactory.readWrite;

import proj.skillfactory.objects.AllInfo;
import proj.skillfactory.util.JsonUtil;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JsonWriter {
    private static final Logger logger = Logger.getLogger(JsonWriter.class.getName());

    private JsonWriter() {
    }

    public static void writeJsonReq(AllInfo allInfo) {

        logger.log(Level.INFO, "JSON запись начата");

        try {
            Files.createDirectory(Paths.get("jsonReqs"));
            logger.log(Level.INFO, "jsonReqs директория создана");
        } catch (IOException ioEx) {
            logger.log(Level.FINE, "jsonReqs директория существует", ioEx);
        }

        writeStudents(allInfo);
        writeUniversities(allInfo);
        writeStatisticsList(allInfo);

        logger.log(Level.INFO, "JSON успешно записан");
    }

    private static void writeStudents(AllInfo allInfo) {

        String studentsJson = JsonUtil.writeListToJson(allInfo.getStudentList());
        try {
            try (FileOutputStream outputStream = new FileOutputStream("jsonReqs/students" + allInfo.getProcessDate().getTime() + ".json")) {
                outputStream.write(studentsJson.getBytes(StandardCharsets.UTF_8));
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Students JSON writing failed", e);
        }
    }

    private static void writeUniversities(AllInfo allInfo) {
        String universitiesJson = JsonUtil.writeListToJson(AllInfo.getUniversityList());
        try {
            try (FileOutputStream outputStream = new FileOutputStream("jsonReqs/universities" + allInfo.getProcessDate().getTime() + ".json")) {
                outputStream.write(universitiesJson.getBytes(StandardCharsets.UTF_8));
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Universities JSON writing failed", e);
        }
    }

    private static void writeStatisticsList(AllInfo allInfo) {
        String studentsJson = JsonUtil.writeListToJson(allInfo.getStatisticsList());
        try {
            try (FileOutputStream outputStream = new FileOutputStream("jsonReqs/statistics" + allInfo.getProcessDate().getTime() + ".json")) {
                outputStream.write(studentsJson.getBytes(StandardCharsets.UTF_8));
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Statistics JSON writing failed", e);
        }
    }
}
