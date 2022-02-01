package com.endava.petclinic.model.client;

import com.endava.petclinic.model.filters.AuthenticationFilter;
import com.endava.petclinic.model.filters.LogFilter;
import com.endava.petclinic.model.owner.Owner;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static com.endava.petclinic.model.util.EnvReader.*;
import static io.restassured.RestAssured.given;

public class OwnerClient {
    public Response createOwners(Owner owner){
        return given().filters(new AuthenticationFilter(),new LogFilter())
                .baseUri(getBaseUri())
                .port(getPort())
                .basePath(getBasePath())
                .contentType(ContentType.JSON)
                .body(owner)
                
                .post("api/owners");
    }
    public Response getOwnerById(Long ownerId){
        return given().filters(new AuthenticationFilter(),new LogFilter()).baseUri(getBaseUri())
                .port(getPort())
                .basePath(getBasePath())
                .pathParams("ownerId",ownerId)
                .get("api/owners/{ownerId}");
    }
    public Response getOwnerList(){
        return given().filters(new AuthenticationFilter(),new LogFilter()).baseUri(getBaseUri())
                .port(getPort())
                .basePath(getBasePath())
                .get("api/owners");
    }
    public Response deleteOwnerById(Long ownerId){
        return given().filters(new AuthenticationFilter(),new LogFilter()).baseUri(getBaseUri())
                .port(getPort())
                .basePath(getBasePath())
                .pathParams("ownerId",ownerId)
                .delete("api/owners/{ownerId}");
    }
    public Response updateOwnerById(Long ownerId,Owner owner){
        return given().filters(new AuthenticationFilter(),new LogFilter()).baseUri(getBaseUri())
                .port(getPort())
                .basePath(getBasePath())
                .pathParams("ownerId",ownerId)
                .body(owner)
                .contentType(ContentType.JSON)
                .put("api/owners/{ownerId}");
    }
}
