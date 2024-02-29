package org.example;

public enum StudyProfile {

    PROGRAMMER("Программирование"),
    DENTIST ("Стоматология"),
    PHYSICS("Физикя"),
    ACCOUNTAINT("Бухгалтерия"),

    LINGUISTICS("Лингвистика"),
    MEDICINE("Медицина"),
    MATHEMATICS("Математика"),
    ARTIST("Искусство");

    String profileName;
    StudyProfile(String profileName) {
        this.profileName = profileName;}

}
