package com.lahtachev;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

public class CalculationRestClient {

    public static void makeLocalCalcTP(Client client, String operation, double a, double b) {
        WebTarget webTarget = client.target("http://localhost:8080/rest/calc").path(operation).path(String.valueOf(a)).path(String.valueOf(b));
        Invocation.Builder builder = webTarget.request(MediaType.TEXT_PLAIN);
        Response response = builder.get();
        System.out.println(response.readEntity(Double.class));
    }

    public static void makeLocalCalcTH(Client client, String operation, double a, double b) {
        WebTarget webTarget = client.target("http://localhost:8080/rest/calc").path(operation).path(String.valueOf(a)).path(String.valueOf(b));
        Invocation.Builder builder = webTarget.request(MediaType.TEXT_HTML);
        Response response = builder.get();
        System.out.println(response.readEntity(String.class));
    }

    public static void makeLocalCalcAJ(Client client, String operation, double a, double b) {
        WebTarget webTarget = client.target("http://localhost:8080/rest/calc").path(operation).path(String.valueOf(a)).path(String.valueOf(b));
        Invocation.Builder builder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = builder.get();
        System.out.println(response.readEntity(String.class));
    }

    public static void chooser(Client client, String operation, double a, double b) {
        if (operation.contains("TP"))
            makeLocalCalcTP(client, operation, a, b);
        else if (operation.contains("TH"))
            makeLocalCalcTH(client, operation, a, b);
        else if (operation.contains("AJ"))
            makeLocalCalcAJ(client, operation, a, b);
        else System.out.println("WRONG INPUT");
    }

    public static void main(String[] args) throws IOException {
        Client client = ClientBuilder.newClient(new ClientConfig().register(LoggingFilter.class));

        chooser(client, "addTP", 1, 2);
        //chooser(client,"subTP",1,2);
        //chooser(client,"multTP",1,2);
        //chooser(client,"divTP",1,2);
    }

}

