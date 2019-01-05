package com.lahtachev;

import org.json.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/calc")
public class CalculationRestService {
    @GET
    @Path("/addTP/{a}/{b}")
    @Produces(MediaType.TEXT_PLAIN)
    public double addTP(@PathParam("a") double a, @PathParam("b") double b) {
        return a + b;
    }

    @GET
    @Path("addAJ/{a}/{b}")
    @Produces(MediaType.APPLICATION_JSON)
    public String addAJ(@PathParam("a") double a, @PathParam("b") double b) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", a + b);
        return jsonObject.toString();
    }

    @GET
    @Path("/addTH/{a}/{b}")
    @Produces(MediaType.TEXT_HTML)
    public String addTH(@PathParam("a") double a, @PathParam("b") double b) {
        double res = a + b;
        return "<html><body>result = " + res + "</body></html>";
    }


    @GET
    @Path("/subTP/{a}/{b}")
    @Produces(MediaType.TEXT_PLAIN)
    public double subTP(@PathParam("a") double a, @PathParam("b") double b) {
        return a - b;
    }

    @GET
    @Path("subAJ/{a}/{b}")
    @Produces(MediaType.APPLICATION_JSON)
    public String subAJ(@PathParam("a") double a, @PathParam("b") double b) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", a - b);
        return jsonObject.toString();
    }

    @GET
    @Path("/subTH/{a}/{b}")
    @Produces(MediaType.TEXT_HTML)
    public String subTH(@PathParam("a") double a, @PathParam("b") double b) {
        double res = a - b;
        return "<html><body>result = " + res + "</body></html>";
    }


    @GET
    @Path("/multTP/{a}/{b}")
    @Produces(MediaType.TEXT_PLAIN)
    public double multTP(@PathParam("a") double a, @PathParam("b") double b) {
        return a * b;
    }

    @GET
    @Path("multAJ/{a}/{b}")
    @Produces(MediaType.APPLICATION_JSON)
    public String multAJ(@PathParam("a") double a, @PathParam("b") double b) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", a * b);
        return jsonObject.toString();
    }

    @GET
    @Path("/multTH/{a}/{b}")
    @Produces(MediaType.TEXT_HTML)
    public String multTH(@PathParam("a") double a, @PathParam("b") double b) {
        double res = a * b;
        return "<html><body>result = " + res + "</body></html>";
    }


    @GET
    @Path("/divTP/{a}/{b}")
    @Produces(MediaType.TEXT_PLAIN)
    public double divTP(@PathParam("a") double a, @PathParam("b") double b) {
        if (b == 0)
            return 0;
        return a / b;
    }

    @GET
    @Path("divAJ/{a}/{b}")
    @Produces(MediaType.APPLICATION_JSON)
    public String divAJ(@PathParam("a") double a, @PathParam("b") double b) {
        if (b == 0)
            return "wrong input";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", a / b);
        return jsonObject.toString();
    }

    @GET
    @Path("/divTH/{a}/{b}")
    @Produces(MediaType.TEXT_HTML)
    public String divTH(@PathParam("a") double a, @PathParam("b") double b) {
        if (b == 0)
            return "<html><body> wrong input </body></html>";
        double res = a / b;
        return "<html><body>result = " + res + "</body></html>";
    }

}
