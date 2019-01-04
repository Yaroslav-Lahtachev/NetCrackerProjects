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

    public static void makeLocalCalc(Client client, String operation, double a, double b) {
        WebTarget webTarget = client.target("http://localhost:8080/rest/calc").path(operation).path(String.valueOf(a)).path(String.valueOf(b));
        Invocation.Builder builder = webTarget.request(MediaType.TEXT_PLAIN);
        Response response = builder.get();
        double res = response.readEntity(Double.class);
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Client client = ClientBuilder.newClient(new ClientConfig().register(LoggingFilter.class));

        makeLocalCalc(client, "add", 1, 2);
        //makeLocalCalc(client,"sub",1,2);
        //makeLocalCalc(client,"mult",1,2);
        //makeLocalCalc(client,"div",1,2);
    }

}

