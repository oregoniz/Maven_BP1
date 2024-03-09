package proj.skillfactory.enums;

public enum StudyProfile {

    PROGRAMMER("Программирование"),
    DENTIST ("Стоматология"),
    PHYSICS("Физика"),
    FINANCE("Финансы"),

    LINGUISTICS("Лингвистика"),
    MEDICINE("Медицина"),
    MATHEMATICS("Математика"),
    ARTIST("Искусство");

    String profileName;
    StudyProfile(String profileName) {
        this.profileName = profileName;}

}
