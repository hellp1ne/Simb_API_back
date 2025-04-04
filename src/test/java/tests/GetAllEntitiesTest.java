package tests;

import base.BaseTest;
import models.EntityResponse;
import org.junit.Test;
import services.EntityService;
import static org.junit.Assert.assertTrue;

public class GetAllEntitiesTest extends BaseTest {
    @Test
    public void testGetAllEntities() {
        EntityResponse response = EntityService.getAllEntities();
        assertTrue(response.getEntities().size() > 0);

        // Проверяем, что наша тестовая сущность есть в списке
        boolean found = response.getEntities().stream()
                .anyMatch(e -> e.getId().toString().equals(createdEntityId));
        assertTrue(found);
    }
}