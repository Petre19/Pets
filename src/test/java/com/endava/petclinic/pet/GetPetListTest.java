package com.endava.petclinic.pet;

import com.endava.petclinic.model.client.OwnerClient;
import com.endava.petclinic.model.client.PetClient;
import com.endava.petclinic.model.owner.Owner;
import com.endava.petclinic.model.owner.Pet;
import com.endava.petclinic.model.owner.Type;
import com.endava.petclinic.model.testData.TestDataProvider;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;


import java.util.List;

import static io.restassured.RestAssured.withArgs;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GetPetListTest {
    @Test
    public void shouldGetOwnerList() {

      /*  PetClient petClient = new PetClient();
        OwnerClient ownerClient=new OwnerClient();
        TestDataProvider testDataProvider = new TestDataProvider();

        Owner owner = testDataProvider.getOwner();
        Response createOwnerResponse = ownerClient.createOwners(owner);

        createOwnerResponse.then().statusCode(HttpStatus.SC_CREATED);

        Long ownerID = createOwnerResponse.body().jsonPath().getLong("id");

        //Type type=new Type(5L,"bird");
        owner.setId(ownerID);

        Pet pet = testDataProvider.getPet();
        pet.setType(type);
        pet.setOwner(owner);
        Response createPetResponse = petClient.createPet(pet);
        Response responsePet = petClient.createPet(pet);


        createPetResponse.then().statusCode(HttpStatus.SC_CREATED);



        Long petId = createPetResponse.body().jsonPath().getLong("id");
        Response response = petClient.getPetList(petId,pet);//----

        response.then().statusCode(HttpStatus.SC_OK)
                .body("find{it -> it.id == %s}.name", withArgs(petId), is(pet.getName()));*/


    }
}
