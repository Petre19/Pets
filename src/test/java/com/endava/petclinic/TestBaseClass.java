package com.endava.petclinic;

import com.endava.petclinic.model.client.OwnerClient;
import com.endava.petclinic.model.client.PetClient;
import com.endava.petclinic.model.extension.TestReporterExtension;
import com.endava.petclinic.model.testData.TestDataProvider;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(TestReporterExtension.class)
public class TestBaseClass {
    protected OwnerClient ownerClient = new OwnerClient();
    protected PetClient petClient = new PetClient();
    protected TestDataProvider testDataProvider = new TestDataProvider();

}
