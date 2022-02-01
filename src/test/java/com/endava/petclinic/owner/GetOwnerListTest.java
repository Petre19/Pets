package com.endava.petclinic.owner;

import com.endava.petclinic.TestBaseClass;
import com.endava.petclinic.model.owner.Owner;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.withArgs;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GetOwnerListTest extends TestBaseClass {
    @Test
    public void shouldGetOwnerList() {
        //GIVEN
        Owner owner = testDataProvider.getOwner();
        Response createOwnerResponse = ownerClient.createOwners(owner);
        createOwnerResponse.then().statusCode(HttpStatus.SC_CREATED);
        Long ownerId = createOwnerResponse.body().jsonPath().getLong("id");
        //WHEN
        Response response = ownerClient.getOwnerList();

        //THEN
        //ex1
        response.then().statusCode(HttpStatus.SC_OK)
                .body("find{it -> it.id == %s}.firstName", withArgs(ownerId), is(owner.getFirstName()));

        //ex2
        Owner actualOwner = response.body().jsonPath()
                .param("id", ownerId).getObject("find{it -> it.id == id}", Owner.class);
        assertThat(actualOwner, is(owner));

        //ex3
        List<Owner> ownerList = response.body().jsonPath().getList("", Owner.class);
        assertThat(ownerList, hasItem(owner));
    }
}
