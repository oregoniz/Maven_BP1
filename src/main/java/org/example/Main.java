package org.example;

public class Main {
    public static void main(String[] args){

        FileReader.fileRead("universityInfo.xlsx");
        System.out.println(FileReader.studentsArr);
        System.out.println(FileReader.universityArr);

    }
}