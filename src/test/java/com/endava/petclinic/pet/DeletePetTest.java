package com.endava.petclinic.pet;

import com.endava.petclinic.TestBaseClass;
import com.endava.petclinic.model.owner.Owner;
import com.endava.petclinic.model.owner.Pet;
import com.endava.petclinic.model.owner.Type;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

public class DeletePetTest extends TestBaseClass {
    @Test
    public void shouldDeletePetById() {
        //GIVEN
        Owner owner = testDataProvider.getOwner();
        Response createOwnerResponse = ownerClient.createOwners(owner);
        createOwnerResponse.then().statusCode(HttpStatus.SC_CREATED);
        long id = createOwnerResponse.body().jsonPath().getLong("id");
        owner.setId(id);

        Type petType = new Type();
        petType.setId(1L);
        Pet pet = testDataProvider.getPet(owner, petType);

        Response response = petClient.createPet(pet);
        petClient.createPet(pet);
        response.then().statusCode(HttpStatus.SC_CREATED);


        //WHEN

        Long petId = response.body().jsonPath().getLong("id");
        Response response1 = petClient.deletePetById(petId);
        //THEN
        response1.then().statusCode(HttpStatus.SC_NO_CONTENT);
    }
}
