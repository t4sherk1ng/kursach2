package org.example.dto;

public class PredictionRequestDto {

    private String ID;
    private String Delivery_person_ID;
    private String Delivery_person_Age;
    private String Delivery_person_Ratings;
    private String Restaurant_latitude;
    private String Restaurant_longitude;
    private String Delivery_location_latitude;
    private String Delivery_location_longitude;
    private String Order_Date;
    private String Time_Orderd;
    private String Time_Order_picked;
    private String Weatherconditions;
    private String Road_traffic_density;
    private String Vehicle_condition;
    private String Type_of_order;
    private String Type_of_vehicle;
    private String multiple_deliveries;
    private String Festival;
    private String City;

    public PredictionRequestDto() {}

    // Геттеры и сеттеры для всех полей
    public String getID() { return ID; }
    public void setID(String ID) { this.ID = ID; }

    public String getDelivery_person_ID() { return Delivery_person_ID; }
    public void setDelivery_person_ID(String delivery_person_ID) { Delivery_person_ID = delivery_person_ID; }

    public String getDelivery_person_Age() { return Delivery_person_Age; }
    public void setDelivery_person_Age(String delivery_person_Age) { Delivery_person_Age = delivery_person_Age; }

    public String getDelivery_person_Ratings() { return Delivery_person_Ratings; }
    public void setDelivery_person_Ratings(String delivery_person_Ratings) { Delivery_person_Ratings = delivery_person_Ratings; }

    public String getRestaurant_latitude() { return Restaurant_latitude; }
    public void setRestaurant_latitude(String restaurant_latitude) { Restaurant_latitude = restaurant_latitude; }

    public String getRestaurant_longitude() { return Restaurant_longitude; }
    public void setRestaurant_longitude(String restaurant_longitude) { Restaurant_longitude = restaurant_longitude; }

    public String getDelivery_location_latitude() { return Delivery_location_latitude; }
    public void setDelivery_location_latitude(String delivery_location_latitude) { Delivery_location_latitude = delivery_location_latitude; }

    public String getDelivery_location_longitude() { return Delivery_location_longitude; }
    public void setDelivery_location_longitude(String delivery_location_longitude) { Delivery_location_longitude = delivery_location_longitude; }

    public String getOrder_Date() { return Order_Date; }
    public void setOrder_Date(String order_Date) { Order_Date = order_Date; }

    public String getTime_Orderd() { return Time_Orderd; }
    public void setTime_Orderd(String time_Orderd) { Time_Orderd = time_Orderd; }

    public String getTime_Order_picked() { return Time_Order_picked; }
    public void setTime_Order_picked(String time_Order_picked) { Time_Order_picked = time_Order_picked; }

    public String getWeatherconditions() { return Weatherconditions; }
    public void setWeatherconditions(String weatherconditions) { Weatherconditions = weatherconditions; }

    public String getRoad_traffic_density() { return Road_traffic_density; }
    public void setRoad_traffic_density(String road_traffic_density) { Road_traffic_density = road_traffic_density; }

    public String getVehicle_condition() { return Vehicle_condition; }
    public void setVehicle_condition(String vehicle_condition) { Vehicle_condition = vehicle_condition; }

    public String getType_of_order() { return Type_of_order; }
    public void setType_of_order(String type_of_order) { Type_of_order = type_of_order; }

    public String getType_of_vehicle() { return Type_of_vehicle; }
    public void setType_of_vehicle(String type_of_vehicle) { Type_of_vehicle = type_of_vehicle; }

    public String getMultiple_deliveries() { return multiple_deliveries; }
    public void setMultiple_deliveries(String multiple_deliveries) { this.multiple_deliveries = multiple_deliveries; }

    public String getFestival() { return Festival; }
    public void setFestival(String festival) { Festival = festival; }

    public String getCity() { return City; }
    public void setCity(String city) { City = city; }
}
