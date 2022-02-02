package com.endava.petclinic.model.testData;

import com.endava.petclinic.model.owner.Owner;
import com.endava.petclinic.model.owner.Pet;
import com.endava.petclinic.model.owner.Type;
import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class TestDataProvider {

    private Faker faker = new Faker();

    public Owner getOwner() {
        Owner owner = new Owner();
        owner.setFirstName(faker.name().firstName());
        owner.setLastName(faker.name().lastName());
        owner.setAddress(faker.address().fullAddress());
        owner.setCity(faker.address().city());
        owner.setTelephone(getNumberWithDigits(1,11));
        return owner;
    }
    public Pet getPet(Owner owner, Type type) {
        Pet pet = new Pet();
        String birthDate=faker.date().birthday().toInstant().atZone(ZoneId.systemDefault())
                .format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        pet.setName(faker.artist().name());
        pet.setBirthDate(birthDate);
        pet.setOwner(owner);
        pet.setType(type);
        return pet;
    }
    public String getNumberWithDigits(int min, int max){
        return faker.number().digits(faker.number().numberBetween(min,max));
    }
}
