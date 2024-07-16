package com.fernan.gt.Literature.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
public class ApiConsumerService {

    public String getData(String url){
        
        try{
            HttpClient clientHttp = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

            HttpResponse<String> response = clientHttp.send(request, BodyHandlers.ofString());
            
            return response.body(); //here return the json of the request http

        }catch(IOException e){
            throw new RuntimeException(e);
            
        }
        catch(Exception ex){
            System.out.println("Hubo una excepcion al hacer la peticion");
        }
        return null;



    }
    
}
