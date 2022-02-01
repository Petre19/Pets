package com.endava.petclinic.pet;

import com.endava.petclinic.TestBaseClass;
import com.endava.petclinic.model.client.OwnerClient;
import com.endava.petclinic.model.client.PetClient;
import com.endava.petclinic.model.owner.Owner;
import com.endava.petclinic.model.owner.Pet;
import com.endava.petclinic.model.owner.Type;
import com.endava.petclinic.model.testData.TestDataProvider;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class CreatePetTest extends TestBaseClass {
    @Test
    public void shouldCreatePetGivenValidData() {
        //Given
        Owner owner = testDataProvider.getOwner();
        Response createOwnerResponse = ownerClient.createOwners(owner);
        createOwnerResponse.then().statusCode(HttpStatus.SC_CREATED);
        long id = createOwnerResponse.body().jsonPath().getLong("id");
        owner.setId(id);

        Type petType = new Type();
        petType.setId(1L);
        Pet pet = testDataProvider.getPet(owner, petType);

        //When
        Response response = petClient.createPet(pet);
        response.then().statusCode(HttpStatus.SC_CREATED);
    }
}
