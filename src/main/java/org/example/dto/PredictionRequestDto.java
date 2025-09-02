package org.example.dto;

public class PredictionRequestDto {

    private String delivery_person_id;
    private String weather_conditions;
    private String road_traffic_density;
    private int vehicle_condition;
    private String type_of_order;
    private String type_of_vehicle;
    private int multiple_deliveries;
    private String festival;
    private String city;

    // числовые поля
    private double delivery_person_age;
    private double delivery_person_ratings;
    private double restaurant_latitude;
    private double restaurant_longitude;
    private double delivery_location_latitude;
    private double delivery_location_longitude;
    private double order_price; // если есть
    private double distance_km; // если есть
    private String time_ordered;
    private String time_order_picked; // если нужна для модели

    public PredictionRequestDto() {}

    // Геттеры и сеттеры для всех полей
    public String getDelivery_person_id() { return delivery_person_id; }
    public void setDelivery_person_id(String delivery_person_id) { this.delivery_person_id = delivery_person_id; }

    public String getWeather_conditions() { return weather_conditions; }
    public void setWeather_conditions(String weather_conditions) { this.weather_conditions = weather_conditions; }

    public String getRoad_traffic_density() { return road_traffic_density; }
    public void setRoad_traffic_density(String road_traffic_density) { this.road_traffic_density = road_traffic_density; }

    public int getVehicle_condition() { return vehicle_condition; }
    public void setVehicle_condition(int vehicle_condition) { this.vehicle_condition = vehicle_condition; }

    public String getType_of_order() { return type_of_order; }
    public void setType_of_order(String type_of_order) { this.type_of_order = type_of_order; }

    public String getType_of_vehicle() { return type_of_vehicle; }
    public void setType_of_vehicle(String type_of_vehicle) { this.type_of_vehicle = type_of_vehicle; }

    public int getMultiple_deliveries() { return multiple_deliveries; }
    public void setMultiple_deliveries(int multiple_deliveries) { this.multiple_deliveries = multiple_deliveries; }

    public String getFestival() { return festival; }
    public void setFestival(String festival) { this.festival = festival; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public double getDelivery_person_age() { return delivery_person_age; }
    public void setDelivery_person_age(double delivery_person_age) { this.delivery_person_age = delivery_person_age; }

    public double getDelivery_person_ratings() { return delivery_person_ratings; }
    public void setDelivery_person_ratings(double delivery_person_ratings) { this.delivery_person_ratings = delivery_person_ratings; }

    public double getRestaurant_latitude() { return restaurant_latitude; }
    public void setRestaurant_latitude(double restaurant_latitude) { this.restaurant_latitude = restaurant_latitude; }

    public double getRestaurant_longitude() { return restaurant_longitude; }
    public void setRestaurant_longitude(double restaurant_longitude) { this.restaurant_longitude = restaurant_longitude; }

    public double getDelivery_location_latitude() { return delivery_location_latitude; }
    public void setDelivery_location_latitude(double delivery_location_latitude) { this.delivery_location_latitude = delivery_location_latitude; }

    public double getDelivery_location_longitude() { return delivery_location_longitude; }
    public void setDelivery_location_longitude(double delivery_location_longitude) { this.delivery_location_longitude = delivery_location_longitude; }

    public double getOrder_price() { return order_price; }
    public void setOrder_price(double order_price) { this.order_price = order_price; }

    public double getDistance_km() { return distance_km; }
    public void setDistance_km(double distance_km) { this.distance_km = distance_km; }

    public String getTime_ordered() { return time_ordered; }
    public void setTime_ordered(String time_ordered) { this.time_ordered = time_ordered; }

    public String getTime_order_picked() { return time_order_picked; }
    public void setTime_order_picked(String time_order_picked) { this.time_order_picked = time_order_picked; }
}
