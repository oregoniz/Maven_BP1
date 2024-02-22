package org.example;

import static org.example.StudyProfile.*;

public class Main {
    public static void main(String[] args) {

        Student std1 = new Student("Olga Regoniz","MSU",3,4);
        Student std2 = new Student("Eugene_ Kovalev","MSU",4,5);
        Student std3 = new Student("Eugene Shepelev","BSU",5,4);

        University university1 = new University("MSU","Lomonosov Moscow State University","Moscow State University",1755,PROGRAMMER);
        University university2 = new University("BSU","Bauman State University","Bauman State University",1830,PROGRAMMER);
        System.out.println(std1);
        System.out.println(std2);
        System.out.println(std3);
        System.out.println(university1);
        System.out.println(university2);
    }
}