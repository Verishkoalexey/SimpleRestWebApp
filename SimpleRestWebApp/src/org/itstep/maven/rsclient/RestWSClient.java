package org.itstep.maven.rsclient;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;


public class RestWSClient {
	
	public static ClientResponse getClientResponse(String path, String mediaType, String restType){
		Client client = Client.create();
		
        WebResource webResource = client.resource(path);
        
        ClientResponse response = null;
        switch (restType) {
		case "get":
	        response = webResource.accept("application/" + mediaType)
            .get(ClientResponse.class);
			break;
		case "post":
	        response = webResource.accept("application/" + mediaType)
            .post(ClientResponse.class);
			break;
		case "put":
	        response = webResource.accept("application/" + mediaType)
            .put(ClientResponse.class);
			break;
		case "delite":
	        response = webResource.accept("application/" + mediaType)
            .delete(ClientResponse.class);
			break;
		}
     
		return response;
	}

	public static void main(String[] args) {
					 
			 ClientResponse response = getClientResponse("http://localhost:8080/wsapp/rest/persons/allj", "json", "get");

		        if (response.getStatus() != 200) {
		           throw new RuntimeException("Failed : HTTP error code : "
		            + response.getStatus());
		        }

		        String output = response.getEntity(String.class);

		        System.out.println("Output from Server .... \n");
		        System.out.println(output);


	}
}
