package services;

import config.RequestSpecificationConfig;
import constants.ApiEndpoints;
import io.restassured.response.Response;
import models.Entity;
import models.EntityResponse;
import io.qameta.allure.Step;

import static io.restassured.RestAssured.given;

public class EntityService {

    @Step("Создание новой сущности")
    public static String createEntity(Entity entity) {
        Response response = given()
                .spec(RequestSpecificationConfig.getRequestSpec())
                .body(entity)
                .when()
                .post(ApiEndpoints.CREATE_ENTITY);

        return response.asString();
    }

    @Step("Удаление сущности с ID: {id}")
    public static Response deleteEntity(String id) {
        return given()
                .spec(RequestSpecificationConfig.getRequestSpec())
                .pathParam("id", id)
                .when()
                .delete(ApiEndpoints.DELETE_ENTITY);
    }

    @Step("Получение сущности по ID: {id}")
    public static Entity getEntity(String id) {
        return given()
                .spec(RequestSpecificationConfig.getRequestSpec())
                .pathParam("id", id)
                .when()
                .get(ApiEndpoints.GET_ENTITY)
                .then()
                .extract()
                .as(Entity.class);
    }

    @Step("Получение списка всех сущностей")
    public static EntityResponse getAllEntities() {
        return given()
                .spec(RequestSpecificationConfig.getRequestSpec())
                .when()
                .get(ApiEndpoints.GET_ALL_ENTITIES)
                .then()
                .extract()
                .as(EntityResponse.class);
    }

    @Step("Обновление сущности с ID: {id}")
    public static Response patchEntity(String id, Entity entity) {
        return given()
                .spec(RequestSpecificationConfig.getRequestSpec())
                .pathParam("id", id)
                .body(entity)
                .when()
                .patch(ApiEndpoints.PATCH_ENTITY);
    }
}