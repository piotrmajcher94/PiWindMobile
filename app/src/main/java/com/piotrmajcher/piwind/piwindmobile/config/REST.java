package com.piotrmajcher.piwind.piwindmobile.config;

public interface REST {
//    String BASE_URL = "http://192.168.0.110:8080";
//    String BASE_URL = "http://10.38.250.59:8080";
//    String BASE_URL = "http://10.0.2.2:8080";
    String BASE_URL = "https://piwind.herokuapp.com";
    String GET_STATIONS_LIST_ENDPOINT = "/stations/all";
    String STATISTIC_ENDPOINT = "/statistics";
    String REGISTER_USER_URL = "/register-user";
    String CONFIRM_EMAIL_URL = "/confirm/";
    String LOGIN_URL = "/login";
    String AUTH_HEADER_KEY = "Authorization";
    int UNAUTHORIZED = 401;
}