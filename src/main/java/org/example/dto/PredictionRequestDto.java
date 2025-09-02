package org.example.dto;

public class PredictionRequestDto {

    private String city;
    private String weather_conditions;
    private String road_traffic_density;
    private double vehicle_age;
    private double vehicle_rating;
    private double distance_km;
    private double order_price;
    private int multiple_orders;
    private double delivery_person_rating;

    public PredictionRequestDto() {}

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getWeather_conditions() { return weather_conditions; }
    public void setWeather_conditions(String weather_conditions) { this.weather_conditions = weather_conditions; }

    public String getRoad_traffic_density() { return road_traffic_density; }
    public void setRoad_traffic_density(String road_traffic_density) { this.road_traffic_density = road_traffic_density; }

    public double getVehicle_age() { return vehicle_age; }
    public void setVehicle_age(double vehicle_age) { this.vehicle_age = vehicle_age; }

    public double getVehicle_rating() { return vehicle_rating; }
    public void setVehicle_rating(double vehicle_rating) { this.vehicle_rating = vehicle_rating; }

    public double getDistance_km() { return distance_km; }
    public void setDistance_km(double distance_km) { this.distance_km = distance_km; }

    public double getOrder_price() { return order_price; }
    public void setOrder_price(double order_price) { this.order_price = order_price; }

    public int getMultiple_orders() { return multiple_orders; }
    public void setMultiple_orders(int multiple_orders) { this.multiple_orders = multiple_orders; }

    public double getDelivery_person_rating() { return delivery_person_rating; }
    public void setDelivery_person_rating(double delivery_person_rating) { this.delivery_person_rating = delivery_person_rating; }

    @Override
    public String toString() {
        return "FoodDeliveryPredictionRequestDto{" +
                "city='" + city + '\'' +
                ", weather_conditions='" + weather_conditions + '\'' +
                ", road_traffic_density='" + road_traffic_density + '\'' +
                ", vehicle_age=" + vehicle_age +
                ", vehicle_rating=" + vehicle_rating +
                ", distance_km=" + distance_km +
                ", order_price=" + order_price +
                ", multiple_orders=" + multiple_orders +
                ", delivery_person_rating=" + delivery_person_rating +
                '}';
    }
}