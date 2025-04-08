package tests;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import models.EntityResponse;
import org.junit.Test;
import services.EntityService;
import static org.junit.Assert.assertTrue;

@DisplayName("Тесты получения списка сущностей")
public class EntitiesListTest extends BaseTest {
    @Test
    @DisplayName("Проверка получения списка сущностей")
    @Description("Тест проверяет получение списка всех сущностей и наличие тестовой сущности в списке")
    public void entitiesListRetrieval() {
        EntityResponse response = EntityService.getAllEntities();
        assertTrue(response.getEntities().size() > 0);
        boolean found = response.getEntities().stream()
                .anyMatch(e -> e.getId().toString().equals(createdEntityId));
        assertTrue(found);
    }
}