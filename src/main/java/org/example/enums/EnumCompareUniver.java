package org.example.enums;

public enum EnumCompareUniver {
    UnivComparatorById("Сравнение университетов по Id"),
    UnivComparatorByMainProfile ("Сравнение университетов по профилю"),
    UnivComparatorByName ("Сравнение университетов по названию"),
    UnivComparatorByShortName ("Сравнение университетов по аббривиатуре"),
    UnivComparatorByYearOfFoundation("Сравнение университетов по году создания");
    String enumCompareUniv;
    EnumCompareUniver(String enumCompareUniv) {
        this.enumCompareUniv = enumCompareUniv;
    }



}
