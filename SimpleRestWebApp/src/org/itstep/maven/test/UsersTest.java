package org.itstep.maven.test;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import impl.UserDAOImpl;
import model.User;

public class UsersTest {
	
	private static Client client;
	private static String restURIBegin = "http://localhost:8080/wsapp/rest/users%s";
	
	private static String buildRESTURI(String wspath){
		return String.format(restURIBegin, wspath);
		
	}
	
    @BeforeClass
    public static void globalInit() {
       client = Client.create();
    }
    
    @Before
    public void init() {
        //before each test
    }
        
    @Test
    public void getAllUsersTest() {
        WebResource webResource = client.resource(buildRESTURI("/all"));
        ClientResponse response = webResource.accept(MediaType.APPLICATION_XML).get(ClientResponse.class);
        assertEquals(200, response.getStatus());
    }
    
//    @Test
//    public void createUserTest1() {
//        WebResource webResource = client.resource(buildRESTURI("/create"));
//        
//        String input = "<user>\r\n" + 
//                "<email>alex@gmail1.com</email>\r\n" + 
//                "<id>100</id>\r\n" + 
//                "<name>Johnson</name>\r\n" + 
//                "<pass>111</pass>\r\n" + 
//                "<role>\r\n" + 
//                "<descr> </descr>\r\n" + 
//                "<id>2</id>\r\n" + 
//                "<name>MANAGER</name>\r\n" + 
//                "</role>\r\n" + 
//                "</user>";
//
//        ClientResponse response = webResource.type(MediaType.APPLICATION_XML)
//           .post(ClientResponse.class, input);
//
//        assertEquals(200, response.getStatus());
//    }
//    
//    @Test
//    public void createUserTest2() {
//        WebResource webResource = client.resource(buildRESTURI("/create"));
//        
//        String input = "<user>\r\n" + 
//                "<email>alex@gmail1.com</email>\r\n" + 
//                "<id>-1</id>\r\n" + 
//                "<name>Johnson</name>\r\n" + 
//                "<pass>111</pass>\r\n" + 
//                "<role>\r\n" + 
//                "<descr> </descr>\r\n" + 
//                "<id>2</id>\r\n" + 
//                "<name>MANAGER</name>\r\n" + 
//                "</role>\r\n" + 
//                "</user>";
//
//        ClientResponse response = webResource.type(MediaType.APPLICATION_XML)
//           .post(ClientResponse.class, input);
//
//        assertEquals(304, response.getStatus());
//    }
//    
//    @Test ()
//    public void createUserTest3() {
//        WebResource webResource = client.resource(buildRESTURI("/erjifhergre"));
//        
//        String input = "<user>\r\n" + 
//                "<email>alex@gmail1.com</email>\r\n" + 
//                "<id>-1</id>\r\n" + 
//                "<name>Johnson</name>\r\n" + 
//                "<pass>111</pass>\r\n" + 
//                "<role>\r\n" + 
//                "<descr> </descr>\r\n" + 
//                "<id>2</id>\r\n" + 
//                "<name>MANAGER</name>\r\n" + 
//                "</role>\r\n" + 
//                "</user>";
//
//        ClientResponse response = webResource.type(MediaType.APPLICATION_XML)
//           .post(ClientResponse.class, input);
//
//        assertEquals(404, response.getStatus());
//    }
    
//    @Test
//    public void updateUserTest1() {
//        WebResource webResource = client.resource(buildRESTURI("/update"));
//        
//        String input = "<user>\r\n" + 
//                "<email>alex@gmail1.com</email>\r\n" + 
//                "<id>19</id>\r\n" + 
//                "<name>Bobson</name>\r\n" + 
//                "<pass>222</pass>\r\n" + 
//                "<role>\r\n" + 
//                "<descr> </descr>\r\n" + 
//                "<id>1</id>\r\n" + 
//                "<name>MANAGER</name>\r\n" + 
//                "</role>\r\n" + 
//                "</user>";
//
//        ClientResponse response = webResource.type(MediaType.APPLICATION_XML)
//           .put(ClientResponse.class, input);
//
//        assertEquals(200, response.getStatus());
//    }
//    
//    @Test
//    public void updateUserTest2() {
//        WebResource webResource = client.resource(buildRESTURI("/update"));
//        
//        String input = "<user>\r\n" + 
//                "<email>alex@gmail1.com</email>\r\n" + 
//                "<id>-1</id>\r\n" + 
//                "<name>Bobson</name>\r\n" + 
//                "<pass>222</pass>\r\n" + 
//                "<role>\r\n" + 
//                "<descr> </descr>\r\n" + 
//                "<id>1</id>\r\n" + 
//                "<name>MANAGER</name>\r\n" + 
//                "</role>\r\n" + 
//                "</user>";
//
//        ClientResponse response = webResource.type(MediaType.APPLICATION_XML)
//           .put(ClientResponse.class, input);
//
//        assertEquals(304, response.getStatus());
//    }
//    
//    @Test
//    public void updateUserTest3() {
//        WebResource webResource = client.resource(buildRESTURI("/uerguerbvueb"));
//        
//        String input = "<user>\r\n" + 
//                "<email>alex@gmail1.com</email>\r\n" + 
//                "<id>-1</id>\r\n" + 
//                "<name>Bobson</name>\r\n" + 
//                "<pass>222</pass>\r\n" + 
//                "<role>\r\n" + 
//                "<descr> </descr>\r\n" + 
//                "<id>1</id>\r\n" + 
//                "<name>MANAGER</name>\r\n" + 
//                "</role>\r\n" + 
//                "</user>";
//
//        ClientResponse response = webResource.type(MediaType.APPLICATION_XML)
//           .put(ClientResponse.class, input);
//
//        assertEquals(404, response.getStatus());
//    }
//    
    @Test
    public void deleteUserTest1() {
        WebResource webResource = client.resource(buildRESTURI("/delete"));
        
        String input = "<user>\r\n" + 
                "<email>alex@gmail1.com</email>\r\n" + 
                "<id>19</id>\r\n" + 
                "<name>Bobson</name>\r\n" + 
                "<pass>222</pass>\r\n" + 
                "<role>\r\n" + 
                "<descr> </descr>\r\n" + 
                "<id>1</id>\r\n" + 
                "<name>MANAGER</name>\r\n" + 
                "</role>\r\n" + 
                "</user>";

        ClientResponse response = webResource.type(MediaType.APPLICATION_XML)
           .delete(ClientResponse.class, input);

        assertEquals(200, response.getStatus());
    }
    
    @Test
    public void deleteUserTest2() {
        WebResource webResource = client.resource(buildRESTURI("/delete"));
        
        String input = "<user>\r\n" + 
                "<email>alex@gmail1.com</email>\r\n" + 
                "<id>-1</id>\r\n" + 
                "<name>Bobson</name>\r\n" + 
                "<pass>222</pass>\r\n" + 
                "<role>\r\n" + 
                "<descr> </descr>\r\n" + 
                "<id>1</id>\r\n" + 
                "<name>MANAGER</name>\r\n" + 
                "</role>\r\n" + 
                "</user>";

        ClientResponse response = webResource.type(MediaType.APPLICATION_XML)
           .delete(ClientResponse.class, input);

        assertEquals(304, response.getStatus());
    }
    
    @Test
    public void deleteUserTest3() {
        WebResource webResource = client.resource(buildRESTURI("/wufvefuegfyu"));
        
        String input = "<user>\r\n" + 
                "<email>alex@gmail1.com</email>\r\n" + 
                "<id>-1</id>\r\n" + 
                "<name>Bobson</name>\r\n" + 
                "<pass>222</pass>\r\n" + 
                "<role>\r\n" + 
                "<descr> </descr>\r\n" + 
                "<id>1</id>\r\n" + 
                "<name>MANAGER</name>\r\n" + 
                "</role>\r\n" + 
                "</user>";

        ClientResponse response = webResource.type(MediaType.APPLICATION_XML)
           .delete(ClientResponse.class, input);

        assertEquals(404, response.getStatus());
    }
    
}