package tests;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import models.Entity;
import org.apache.http.HttpStatus;
import org.junit.Test;
import services.EntityService;
import static org.junit.Assert.assertEquals;

@DisplayName("Тесты обновления сущности")
public class EntityUpdateTest extends BaseTest {
    @Test
    @DisplayName("Проверка обновления сущности")
    @Description("Тест проверяет возможность обновления данных сущности")
    public void entityDataUpdate() {
        Entity entity = EntityService.getEntity(createdEntityId);
        entity.setTitle("Обновленный заголовок");
        EntityService.patchEntity(createdEntityId, entity)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NO_CONTENT);
        Entity updatedEntity = EntityService.getEntity(createdEntityId);
        assertEquals("Обновленный заголовок", updatedEntity.getTitle());
    }
}