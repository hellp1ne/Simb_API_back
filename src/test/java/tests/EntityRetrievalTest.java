package tests;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import models.Entity;
import org.junit.Test;
import services.EntityService;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@DisplayName("Тесты получения сущности")
public class EntityRetrievalTest extends BaseTest {
    @Test
    @DisplayName("Проверка получения сущности по ID")
    @Description("Тест проверяет корректность данных полученной сущности")
    public void singleEntityRetrieval() {
        Entity responseEntity = EntityService.getEntity(createdEntityId);
        assertEquals("Тестовая сущность", responseEntity.getTitle());
        assertTrue(responseEntity.getVerified());
        assertEquals(3, responseEntity.getImportantNumbers().size());
    }
}