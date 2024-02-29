package org.example.enums;

public enum EnumCompareStudents {
    StudentsComparatorByName ("Сравнение студентов по имени"),
    StudentsComparatorByCourceNumber ("Сравнение студентов по курсу"),
    StudentsComparatorByUnivId ("Сравнение студентов по Id"),
    StudentsComparatorByAvgExamScore ("Сравнение студентов по рейтингу");

   String EnumCompareStud;

    EnumCompareStudents(String enumCompareStud) {
        EnumCompareStud = enumCompareStud;
    }
}
