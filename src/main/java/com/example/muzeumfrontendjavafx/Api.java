package com.example.muzeumfrontendjavafx;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class Api {
    private static final String BASE_URL = "http://127.0.0.1:8000";
    private static final String PAINTING_API_URL = BASE_URL + "/api/paintings";
    private static final String STATUE_API_URL = BASE_URL + "/api/statues";

    public static List<Szobor> getSzobrok() throws IOException {
        Response response = RequestHandler.get(STATUE_API_URL);
        String json = response.getContent();
        Gson jsonConvert = new Gson();
        if (response.getResponseCode() >= 400){
            String message = jsonConvert.fromJson(json, ApiError.class).getMessage();
            throw new IOException(message);
        }
        Type type = new TypeToken<List<Szobor>>(){}.getType();
        return jsonConvert.fromJson(json,type);
    }

    public static List<Festmeny> getFestmenyek() throws IOException {
        Response response = RequestHandler.get(PAINTING_API_URL);
        String json = response.getContent();
        Gson jsonConvert = new Gson();
        if (response.getResponseCode() >= 400){
            String message = jsonConvert.fromJson(json, ApiError.class).getMessage();
            throw new IOException(message);
        }
        Type type = new TypeToken<List<Festmeny>>(){}.getType();
        return jsonConvert.fromJson(json,type);
    }

    public static Szobor addStatue(Szobor s) throws IOException {
        Gson jsonConvert = new Gson();
        String json = jsonConvert.toJson(s);
        Response response = RequestHandler.post(STATUE_API_URL, json);

        String jsonResponse = response.getContent();
        if (response.getResponseCode() >= 400){
            String message = jsonConvert.fromJson(jsonResponse, ApiError.class).getMessage();
            throw new IOException(message);
        }
        return jsonConvert.fromJson(jsonResponse, Szobor.class);
    }

    public static Festmeny addPainting(Festmeny f) throws IOException {
        Gson jsonConvert = new Gson();
        String json = jsonConvert.toJson(f);
        Response response = RequestHandler.post(PAINTING_API_URL, json);

        String jsonResponse = response.getContent();
        if (response.getResponseCode() >= 400){
            String message = jsonConvert.fromJson(jsonResponse, ApiError.class).getMessage();
            throw new IOException(message);
        }
        return jsonConvert.fromJson(jsonResponse, Festmeny.class);
    }
}
