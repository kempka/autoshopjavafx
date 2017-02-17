package ru.java2017.autoshop.objects;

/**
 * Created by UserBoot on 17.02.2017.
 */
public class MyRequests {

    public static final String query_All_Car = "SELECT * FROM car";
    public static final String query_Join1_Car = "SELECT " +
            "c1.id_car, " +
            "c2.name_ru, " +
            "c3.name_ru, " +
            "c4.name_ru, " +
            "c5.name_ru, " +
            "capasity, " +
            "c6.name_ru, " +
            "price, " +
            "c7.name_ru, " +
            "c8.name_ru, " +
            "issue_year, " +
            "description " +

            "FROM car c1 " +

            "join spr_cartype c2 on c1.id_car_type=c2.id " +
            "join spr_model c3 on c1.id_model=c3.id " +
            "join spr_transmission c4 on c1.id_transmission=c4.id " +
            "join spr_privod c5 on c1.id_privod=c5.id " +
            "join spr_brand c6 on c1.id_brand=c6.id " +
            "join spr_condition c7 on c1.id_condition=c7.id " +
            "join spr_color c8 on c1.id_color=c8.id;";
}
