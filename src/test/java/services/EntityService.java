package services;

import config.RequestSpecificationConfig;
import constants.ApiEndpoints;
import io.restassured.response.Response;
import models.Entity;
import models.EntityResponse;

import static io.restassured.RestAssured.given;

public class EntityService {

    /**
     * Создает новую сущность
     * @param entity объект сущности для создания
     * @return ID созданной сущности в виде строки
     */
    public static String createEntity(Entity entity) {
        Response response = given()
                .spec(RequestSpecificationConfig.getRequestSpec())
                .body(entity)
                .when()
                .post(ApiEndpoints.CREATE_ENTITY);

        return response.asString();
    }

    /**
     * Удаляет сущность по ID
     * @param id ID сущности для удаления
     * @return Response объект с ответом сервера
     */
    public static Response deleteEntity(String id) {
        return given()
                .spec(RequestSpecificationConfig.getRequestSpec())
                .pathParam("id", id)
                .when()
                .delete(ApiEndpoints.DELETE_ENTITY);
    }

    /**
     * Получает сущность по ID
     * @param id ID сущности для получения
     * @return объект Entity с данными сущности
     */
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

    /**
     * Получает список всех сущностей
     * @return объект EntityResponse со списком сущностей
     */
    public static EntityResponse getAllEntities() {
        return given()
                .spec(RequestSpecificationConfig.getRequestSpec())
                .when()
                .get(ApiEndpoints.GET_ALL_ENTITIES)
                .then()
                .extract()
                .as(EntityResponse.class);
    }

    /**
     * Обновляет сущность по ID
     * @param id ID сущности для обновления
     * @param entity объект с обновленными данными
     * @return Response объект с ответом сервера
     */
    public static Response patchEntity(String id, Entity entity) {
        return given()
                .spec(RequestSpecificationConfig.getRequestSpec())
                .pathParam("id", id)
                .body(entity)
                .when()
                .patch(ApiEndpoints.PATCH_ENTITY);
    }

    /**
     * Получает статус код при создании сущности
     * @param entity объект сущности
     * @return статус код ответа
     */
    public static int getCreateEntityStatusCode(Entity entity) {
        return given()
                .spec(RequestSpecificationConfig.getRequestSpec())
                .body(entity)
                .when()
                .post(ApiEndpoints.CREATE_ENTITY)
                .then()
                .extract()
                .statusCode();
    }
}