package org.example;

import java.io.IOException;

import static org.example.FileReader.getStudArr;
import static org.example.FileReader.getUnivArr;
import static org.example.StudyProfile.*;

public class Main {
    public static void main(String[] args) throws IOException {

        FileReader.fileRead("universityInfo.xlsx");
        System.out.println(FileReader.studentsArr);
        System.out.println(FileReader.universityArr);

    }
}