package proj.skillfactory.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import proj.skillfactory.Main;
import proj.skillfactory.objects.Student;
import proj.skillfactory.objects.University;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JsonUtil {
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    public JsonUtil() {
    }

    public static String SerializeStud(Student student) {
       // Gson gson = new Gson();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String gsonString = gson.toJson(student);
        logger.log(Level.INFO,"Объект успешно сериализован.");
        return gsonString;
    }

    public static Student DeSerializeStud(String gsonString) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Student student = gson.fromJson(gsonString, Student.class);
        logger.log(Level.INFO,"Объект успешно десериализован.");
        return student;
    }

    public static String SerializeStudArr(ArrayList<Student> arr) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String gsonString = gson.toJson(arr);
        logger.log(Level.INFO,"Объект успешно сериализован.");
        return gsonString;
    }

    public static ArrayList<Student> DeSerializeStudArr(String gsonString) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        ArrayList<Student> studentsArr = gson.fromJson(gsonString, ArrayList.class);
        logger.log(Level.INFO,"Объект успешно десериализован.");
        return studentsArr;
    }
    public static String SerializeUniver(University university) {
        // Gson gson = new Gson();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String gsonString = gson.toJson(university);
        logger.log(Level.INFO,"Объект успешно сериализован.");
        return gsonString;
    }

    public static University DeSerializeUniver(String gsonString) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        University university = gson.fromJson(gsonString, University.class);
        logger.log(Level.INFO,"Объект успешно десериализован.");
        return university;
    }

    public static String SerializeUniverArr(ArrayList<University> arr) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String gsonString = gson.toJson(arr);
        logger.log(Level.INFO,"Объект успешно сериализован.");
        return gsonString;
    }

    public static ArrayList<University> DeSerializeUniverArr(String gsonString) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        ArrayList<University>univerArr = gson.fromJson(gsonString, ArrayList.class);
        logger.log(Level.INFO,"Объект успешно десериализован.");
        return univerArr;
    }
}




