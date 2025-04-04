package tests;

import base.BaseTest;
import models.Entity;
import org.junit.Test;
import services.EntityService;
import static org.junit.Assert.assertEquals;

public class PatchEntityTest extends BaseTest {
    @Test
    public void testPatchEntity() {
        // Получаем текущую сущность
        Entity entity = EntityService.getEntity(createdEntityId);

        // Обновляем данные
        entity.setTitle("Обновленный заголовок");
        int statusCode = EntityService.patchEntity(createdEntityId, entity).getStatusCode();

        assertEquals(204, statusCode);

        // Проверяем обновление
        Entity updatedEntity = EntityService.getEntity(createdEntityId);
        assertEquals("Обновленный заголовок", updatedEntity.getTitle());
    }
}