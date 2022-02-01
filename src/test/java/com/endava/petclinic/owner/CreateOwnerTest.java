package com.endava.petclinic.owner;

import com.endava.petclinic.TestBaseClass;
import com.endava.petclinic.model.owner.Owner;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class CreateOwnerTest extends TestBaseClass {

    @Test
    public void shouldCreateOwnerGivenValidData() {
        //GIVEN
        Owner owner = testDataProvider.getOwner();
        //WHEN
        Response response = ownerClient.createOwners(owner);
        //THEN
        response.then().statusCode(HttpStatus.SC_CREATED)
                .body("id", is(notNullValue()));

    }

    @Test
    public void shouldFailToCreateOwnerEmptyFirstName() {
        //GIVEN
        Owner owner = testDataProvider.getOwner();
        owner.setFirstName("");
        //WHEN
        Response response = ownerClient.createOwners(owner);
        //THEN
        response.then().statusCode(HttpStatus.SC_BAD_REQUEST);
    }
    @Test
    public void shouldFailtoCreateOwnerGivenFewDigitsTelephone(){
        //GIVEN
        Owner owner = testDataProvider.getOwner();
        owner.setTelephone(testDataProvider.getNumberWithDigits(0,0));
        //WHEN
        Response response = ownerClient.createOwners(owner);
        //THEN
        response.then().statusCode(HttpStatus.SC_BAD_REQUEST);
    }
    @Test
    public void shouldFailtoCreateOwnerGivenManyDigitsTelephone(){
        //GIVEN
        Owner owner = testDataProvider.getOwner();
        owner.setTelephone(testDataProvider.getNumberWithDigits(11,100));
        //WHEN
        Response response = ownerClient.createOwners(owner);
        //THEN
        response.then().statusCode(HttpStatus.SC_BAD_REQUEST);
    }
}
