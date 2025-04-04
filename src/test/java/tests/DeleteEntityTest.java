package tests;

import base.BaseTest;
import org.junit.Test;
import services.EntityService;
import static org.junit.Assert.assertEquals;

public class DeleteEntityTest extends BaseTest {
    @Test
    public void testDeleteEntity() {
        // Удаляем сущность
        int statusCode = EntityService.deleteEntity(createdEntityId).getStatusCode();
        assertEquals(204, statusCode);

        // Помечаем, что сущность уже удалена, чтобы @After не пытался удалить ее снова
        markEntityAsDeleted();
    }
}