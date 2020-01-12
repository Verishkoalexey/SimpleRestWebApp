package org.itstep.maven.restws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.itstep.maven.model.Person;

import com.sun.jersey.api.client.ClientResponse.Status;

import dao.UserDAO;
import impl.UserDAOImpl;
import model.User;

@Path("/users")
public class UserWebServices {
	@GET
	@Path("/all") // -> http://localhost:8080/wsapp/rest/users/all
	@Produces(MediaType.APPLICATION_XML)
	public List<User> getUsers() {
		UserDAO dao = new UserDAOImpl();
		return dao.getAllUsers();
	}

	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_XML)
	public Response createUser(User user) {
		try {
			if (user == null || user.getName() == null) { // ...
				return Response.status(Status.BAD_REQUEST).entity("INVALID USER DATA").build();
			}
			UserDAO dao = new UserDAOImpl();

			boolean isCreated = dao.createUser(user);
			if (isCreated) {
				return Response.ok("INSERTED").build(); // 200
			} else {
				return Response.notModified("NOT INSERTED").build(); // 304
			}
		} catch (Exception e) {
			return Response.serverError().build(); // 500
		}
	}

	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_XML)
	public Response updateUser(User user) {
		try {
			if (user == null || user.getName() == null) { // ...
				return Response.status(Status.BAD_REQUEST).entity("INVALID USER DATA").build();
			}
			UserDAO dao = new UserDAOImpl();
			boolean isUpdated = dao.updateUser(user);
			if (isUpdated) {
				return Response.ok("UPDATED").build(); // 200
			} else {
				return Response.notModified("NOT UPDATED").build(); // 304
			}
		} catch (Exception e) {
			return Response.serverError().build(); // 500
		}

	}

	@DELETE
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_XML)
	public Response deleteUser(User user) {
		try {
			if (user == null || user.getName() == null) { // ...
				return Response.status(Status.BAD_REQUEST).entity("INVALID USER DATA").build();
			}
			UserDAO dao = new UserDAOImpl();
			boolean isDelited = dao.deleteUser(user);
			if (isDelited) {
				return Response.ok("DELITED").build(); // 200
			} else {
				return Response.notModified("NOT DELITED").build(); // 304
			}
		} catch (Exception e) {
			return Response.serverError().build(); // 500
		}

	}

}
