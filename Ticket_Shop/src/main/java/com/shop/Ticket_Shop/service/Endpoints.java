package com.shop.Ticket_Shop.service;

import java.util.ArrayList;
import java.util.List;

public enum Endpoints
{
    HOME("/"),
    LOGIN("/login"),
    LOGOUT("/logout"),
    PLACE("/Place"),
    PLACE_CREATE("/Place/Create"),
    PLACE_DELETE("/Place/Delete"),
    PLACE_EDIT("/Place/Delete");

    private String endpoint;

    Endpoints(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getEndpoint() {
        return endpoint;
    }

    static public List<Endpoints> getEndpointForAllUsers() {
        List<Endpoints> endpoints = new ArrayList<>();
        endpoints.add(HOME);
        endpoints.add(LOGIN);
        endpoints.add(LOGOUT);
        return endpoints;
    }

    static public List<Endpoints> getEndpointsForAdmin(){
        List<Endpoints> endpoints = new ArrayList<>();
        endpoints.add(PLACE_CREATE);
        endpoints.add(PLACE_DELETE);
        endpoints.add(PLACE_EDIT);
        return endpoints;
    }
}
