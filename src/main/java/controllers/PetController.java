package controllers;

import config.AppProperties;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.PetModel;
import model.PetNotFound;
import org.aeonbits.owner.ConfigFactory;

import static io.restassured.RestAssured.given;

public class PetController {
    private static AppProperties appProperties = ConfigFactory.create(AppProperties.class);
    private RequestSpecification requestSpecification;
    private PetModel petModel;

    public PetController(PetModel petModel) {
        this.petModel = petModel;

        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(appProperties.baseUrl())
                .setBasePath(appProperties.basePath())
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL).build();

        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .build();

        RestAssured.defaultParser = Parser.JSON;
    }

    public PetModel createNewPet() {
        return given(requestSpecification)
                .body(petModel)
                .post()
                .as(PetModel.class);
    }

    public PetModel updateExistingPet() {
        return given(requestSpecification)
                .body(petModel)
                .put().as(PetModel.class);
    }

    public void deletePet() {
        given(requestSpecification).delete(appProperties.petId());
    }

    public Object getPet() {
        Response response = given(requestSpecification).get(appProperties.petId());
        if (response.statusCode() == 200) {
            return response.as(PetModel.class);
        } else {
            return response.as(PetNotFound.class);
        }
    }

    public PetNotFound getDeletedPet() {
        return given(requestSpecification)
                .get(appProperties.petId())
                .then()
                .statusCode(404)
                .and()
                .extract().response().as(PetNotFound.class);

    }
}
