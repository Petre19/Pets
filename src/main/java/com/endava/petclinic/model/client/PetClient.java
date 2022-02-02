package com.endava.petclinic.model.client;

import com.endava.petclinic.model.filters.AuthenticationFilter;
import com.endava.petclinic.model.filters.LogFilter;
import com.endava.petclinic.model.owner.Owner;
import com.endava.petclinic.model.owner.Pet;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static com.endava.petclinic.model.util.EnvReader.*;
import static io.restassured.RestAssured.given;

public class PetClient {

    public Response createPet(Pet pet){
        return given().filters(new AuthenticationFilter(),new LogFilter()).baseUri(getBaseUri())
                .port(getPort())
                .basePath(getBasePath())
                .contentType(ContentType.JSON)
                .body(pet)
                .post("api/pets");
    }
    public Response getPetList(Long petId,Pet pet){
        return given().filters(new AuthenticationFilter(),new LogFilter()).baseUri(getBaseUri())
                .port(getPort())
                .basePath(getBasePath())
                .pathParams("petId",petId)
                .body(pet)
                .contentType(ContentType.JSON)
                .put("api/pets/{petId}");
    }
    public Response deletePetById(Long petId){
        return given().filters(new AuthenticationFilter(),new LogFilter()).baseUri(getBaseUri())
                .port(getPort())
                .basePath(getBasePath())
                .pathParams("petId",petId)
                .delete("api/pets/{petId}");
    }

}
