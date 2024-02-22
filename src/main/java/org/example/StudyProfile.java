package org.example;

public enum StudyProfile {

    PROGRAMMER("Программист"),
    DENTIST ("Стоматолог"),
    ACCOUNTAINT("Бухгалтер"),
    DRIVER("Водитель"),
    CONSTRUCTOR("Строитель"),
    MUSICIAN("Музыкант"),
    ARTIST("Художник");
    String profileName;
    StudyProfile(String profileName) {
        this.profileName = profileName;}

}
