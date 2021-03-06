package com.piotrmajcher.piwind.piwindmobile.models;

import com.piotrmajcher.piwind.piwindmobile.dto.MeteoDataTO;

import java.util.Date;

public class MeteoData {

    private Double temperature;

    private Double windSpeed;

    private Date date;

    private String windDirectionDescription;

    private String beaufortCategoryDescription;

    private String temperatureConditionsDescription;

    private String waterConditionsDescription;

    private String equipmentSuggestion;

    public MeteoData(MeteoDataTO meteoDataTO) {
        temperature = meteoDataTO.getTemperature();
        windSpeed = meteoDataTO.getWindSpeed();
        date = meteoDataTO.getDateTime();
        windDirectionDescription = meteoDataTO.getWindDirectionDescription();
        beaufortCategoryDescription = meteoDataTO.getBeaufortCategoryDescription();
        temperatureConditionsDescription = meteoDataTO.getTemperatureConditionsDescription();
        waterConditionsDescription = meteoDataTO.getWaterConditionsDescription();
        equipmentSuggestion = meteoDataTO.getEquipmentSuggestion();
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getWindDirectionDescription() {
        return windDirectionDescription;
    }

    public void setWindDirectionDescription(String windDirectionDescription) {
        this.windDirectionDescription = windDirectionDescription;
    }

    public String getBeaufortCategoryDescription() {
        return beaufortCategoryDescription;
    }

    public void setBeaufortCategoryDescription(String beaufortCategoryDescription) {
        this.beaufortCategoryDescription = beaufortCategoryDescription;
    }

    public String getTemperatureConditionsDescription() {
        return temperatureConditionsDescription;
    }

    public void setTemperatureConditionsDescription(String temperatureConditionsDescription) {
        this.temperatureConditionsDescription = temperatureConditionsDescription;
    }

    public String getWaterConditionsDescription() {
        return waterConditionsDescription;
    }

    public void setWaterConditionsDescription(String waterConditionsDescription) {
        this.waterConditionsDescription = waterConditionsDescription;
    }

    public String getEquipmentSuggestion() {
        return equipmentSuggestion;
    }

    public void setEquipmentSuggestion(String equipmentSuggestion) {
        this.equipmentSuggestion = equipmentSuggestion;
    }

    @Override
    public String toString() {
        return "MeteoData{" +
                "temperature=" + temperature +
                ", windSpeed=" + windSpeed +
                ", date=" + date +
                ", windDirectionDescription='" + windDirectionDescription + '\'' +
                ", beaufortCategoryDescription='" + beaufortCategoryDescription + '\'' +
                ", temperatureConditionsDescription='" + temperatureConditionsDescription + '\'' +
                ", waterConditionsDescription='" + waterConditionsDescription + '\'' +
                ", equipmentSuggestion='" + equipmentSuggestion + '\'' +
                '}';
    }
}
