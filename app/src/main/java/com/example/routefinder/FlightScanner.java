package com.example.routefinder;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class FlightScanner {
    HttpResponse<JsonNode> response;
    String airportIn;
    String airportOut;
    String date;
    String cityIn;
    String cityOut;
    ArrayList<String> carriers;
    ArrayList<Integer> minPrices;
    ArrayList<String> times;

    public FlightScanner(String airOut, String airIn, String d) {
        try {
            response = Unirest.get("https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/browseroutes/v1.0/US/USD/en-US/"+airOut+"-sky/"+airIn+"-sky/"+d)
                    .header("X-RapidAPI-Key", "844b564143mshad6cb7df47572fap1f7c5fjsn458ed7cc48b1")
                    .asJson();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        String responseString = response.getBody().getArray().toString();
        System.out.println(responseString);
        airportIn = airIn;
        airportOut = airOut;
        date = d;
        carriers = new ArrayList<String>();
        minPrices = new ArrayList<Integer>();
        times = new ArrayList<String>();

        int lastIndex = 0;
        ArrayList<String> names = new ArrayList<String>();
        while (responseString.indexOf("\"Name\"", lastIndex) != -1) {
            int index = responseString.indexOf("\"Name\"", lastIndex);
            names.add(responseString.substring(index+8,responseString.indexOf('"',index+8)));
            //System.out.println(responseString.substring(index+8,responseString.indexOf('"',index+8)));
            lastIndex = index+1;
        }
        System.out.println(names);
        for (int i = 0; i < names.size() - 2; i++) {
            System.out.println(names.get(i));
            carriers.add(names.get(i));
            System.out.println(carriers);
        }
        cityOut = names.get(names.size()-2);
        cityIn = names.get(names.size()-1);

        lastIndex = 0;
        while (responseString.indexOf("MinPrice", lastIndex) != -1) {
            int index = responseString.indexOf("MinPrice", lastIndex);
            minPrices.add(Integer.parseInt(responseString.substring(index+10,responseString.indexOf(',',index+7))));
            lastIndex = index+1;
        }
        lastIndex = 0;
        while (responseString.indexOf("QuoteDateTime", lastIndex) != -1) {
            int index = responseString.indexOf("QuoteDateTime", lastIndex);
            times.add(responseString.substring(index+27,responseString.indexOf(',',index+27)-1));
            lastIndex = index+1;
        }


    }

    public HttpResponse<JsonNode> getResponse() {
        return response;
    }

    public String getAirportIn() {
        return airportIn;
    }

    public String getAirportOut() {
        return airportOut;
    }

    public String getDate() {
        return date;
    }

    public String getCityIn() {
        return cityIn;
    }

    public String getCityOut() {
        return cityOut;
    }

    public ArrayList<String> getCarriers() {
        return carriers;
    }

    public ArrayList<Integer> getMinPrices() {
        return minPrices;
    }

    public ArrayList<String> getTimes() {
        return times;
    }
}