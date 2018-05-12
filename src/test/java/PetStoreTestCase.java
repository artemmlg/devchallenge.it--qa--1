import config.AppProperties;
import controllers.PetController;
import model.PetModel;
import model.PetNotFound;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PetStoreTestCase {
    private static AppProperties appProperties = ConfigFactory.create(AppProperties.class);
    private SoftAssert softAssert = new SoftAssert();


    @Test (description = "2. Add a new Pet and check if your Pet was added")
    public void testAddNewPetToStore() {
        PetModel testPet = new PetModel(
                null,
                appProperties.petName(),
                Integer.parseInt(appProperties.petId()),
                null,
                null,
                null);
        PetModel petResponse = new PetController(testPet).createNewPet();
        softAssert.assertEquals(petResponse.getId(), testPet.getId(), "ID's are not similar");
        softAssert.assertEquals(petResponse.getName(), testPet.getName(), "Names are not similar");
        softAssert.assertAll();
    }

    @Test (description = "3. Change the name of your Pet and check if the name was changed")
    public void testUpdatePet() {
        String localName = "Agutin";
        PetModel testPet = new PetModel(
                null,
                appProperties.petName(),
                Integer.parseInt(appProperties.petId()),
                null,
                null,
                null);
        PetController petController = new PetController(testPet);
        petController.createNewPet();
        testPet.setName(localName);
        PetModel petResponse = petController.updateExistingPet();
        softAssert.assertEquals(petResponse, testPet, "Pet name wasn't changed");
        softAssert.assertAll();
    }

    @Test (description = "4. Delete your Pet from the list and check if the Pet was deleted")
    public void deletePetTest() {
        PetModel testPet = new PetModel(
                null,
                appProperties.petName(),
                Integer.parseInt(appProperties.petId()),
                null,
                null,
                null);
        PetController petController = new PetController(testPet);
        petController.createNewPet();
        petController.deletePet();
        PetNotFound petNotFound = (PetNotFound) petController.getPet();
        softAssert.assertEquals("Pet not found", petNotFound.getMessage());
        softAssert.assertEquals("error", petNotFound.getType());
        softAssert.assertAll();
    }
}
