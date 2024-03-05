package proj.skillfactory;
import com.google.gson.Gson;
import proj.skillfactory.objects.Student;

public class JsonUtil {
    public JsonUtil() {
    }

    public static void SerializeStud(Student student) {
        // Создаем объект для сериализации
        Gson gson = new Gson();
        gson.toJson(student);
        System.out.println(gson);
        System.out.println("Объект успешно сериализован.");
        /*try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("serialized_object.ser"))) {
            outputStream.writeObject(student);
            System.out.println("Объект успешно сериализован.");
        } catch (
                IOException e) {
            e.printStackTrace();
        }*/
    }

 /*   public static void DeSerializeStud(Gson gson) {
        // Создаем объект для сериализации
        Student deserializedObject = null;
        JsonReader reader = new JsonReader();
        Student student =  gson.fromJson(gson,new );

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("serialized_object.ser"))) {
            // Десериализуем объект из файла
            deserializedObject = (Student) inputStream.readObject();
            System.out.println("Объект успешно десериализован.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Теперь deserializedObject содержит восстановленный объект
    }*/
}



