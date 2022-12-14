package com.example.weatheralert.Model;

public class Weather {

    private int cod;
    private int weather;

    public Weather(){

    }

    public Weather(int cod, int weather){
        this.cod = cod;
        this.weather = weather;
    }

//    public Weather(int cod, String string) {
//    }

    public Weather(int weather){
        this.weather = weather;
    }


    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public int getWeather() {
        return weather;
    }

    public void setWeather(int weather) {
        this.weather = weather;
    }
}
