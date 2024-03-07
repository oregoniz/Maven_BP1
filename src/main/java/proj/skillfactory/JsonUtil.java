package proj.skillfactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import proj.skillfactory.objects.Student;
import proj.skillfactory.objects.University;

import java.util.ArrayList;

public class JsonUtil {
    public JsonUtil() {
    }

    public static String SerializeStud(Student student) {
       // Gson gson = new Gson();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String gsonString = gson.toJson(student);
        System.out.println("Объект успешно сериализован.");
        return gsonString;
    }

    public static Student DeSerializeStud(String gsonString) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Student student = gson.fromJson(gsonString, Student.class);
        System.out.println("Объект успешно десериализован.");
        return student;
    }

    public static String SerializeStudArr(ArrayList<Student> arr) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String gsonString = gson.toJson(arr);
        System.out.println("Объект успешно сериализован.");
        return gsonString;
    }

    public static ArrayList<Student> DeSerializeStudArr(String gsonString) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        ArrayList<Student> studentsArr = gson.fromJson(gsonString, ArrayList.class);
        System.out.println("Объект успешно десериализован.");
        return studentsArr;
    }
    public static String SerializeUniver(University university) {
        // Gson gson = new Gson();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String gsonString = gson.toJson(university);
        System.out.println("Объект успешно сериализован.");
        return gsonString;
    }

    public static University DeSerializeUniver(String gsonString) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        University university = gson.fromJson(gsonString, University.class);
        System.out.println("Объект успешно десериализован.");
        return university;
    }

    public static String SerializeUniverArr(ArrayList<University> arr) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String gsonString = gson.toJson(arr);
        System.out.println("Объект успешно сериализован.");
        return gsonString;
    }

    public static ArrayList<University> DeSerializeUniverArr(String gsonString) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        ArrayList<University>univerArr = gson.fromJson(gsonString, ArrayList.class);
        System.out.println("Объект успешно десериализован.");
        return univerArr;
    }
}




