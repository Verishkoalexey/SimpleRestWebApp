package org.itstep.maven.restws;

import java.util.Locale;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//import org.json.JSONObject;

import com.ibm.icu.text.RuleBasedNumberFormat;



@Path("/math")
public class MathRestService {
    
    @GET
    @Path("/rand")   // -> http://localhost:8080/wsapp/rest/math/default
    @Produces(MediaType.APPLICATION_JSON)
    public Response randomVal(){
        int x = (int)(Math.random()* 100);
        return Response.ok(x, MediaType.APPLICATION_JSON).build();
    }
    
    @GET
    @Path("/rand/{b}")   // -> http://localhost:8080/wsapp/rest/math/default?b=50
    @Produces(MediaType.APPLICATION_JSON)
    public Response randomVal(@PathParam("b") int b){
        int x = (int)(Math.random()* b);
//        JSONObject jsonObj = new JSONObject();
//        
//        RuleBasedNumberFormat nf = new RuleBasedNumberFormat(Locale.forLanguageTag("en"),
//                RuleBasedNumberFormat.SPELLOUT);
//        
//        jsonObj.put("NAME", nf.format(x));
//        jsonObj.put("VALUE", x);
        return Response.ok(null + "", MediaType.APPLICATION_JSON).build();
    }
    
    @GET
    @Path("/pow/{n}/{x}")   // -> http://localhost:8080/wsapp/rest/math/default
    @Produces(MediaType.APPLICATION_XML)
    public Response pow(@PathParam("n") int n, @PathParam("x") int x){
        double result = Math.pow(x, n);
        String xmlContent = "<main><base>%s</base><exponent>%s</exponent><result>%s</result></main>";
        return Response.ok (String.format(xmlContent, x, n, result), MediaType.APPLICATION_XML).build();
    }
}