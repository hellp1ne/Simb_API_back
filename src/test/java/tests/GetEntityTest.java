package tests;

import base.BaseTest;
import models.Entity;
import org.junit.Test;
import services.EntityService;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GetEntityTest extends BaseTest {
    @Test
    public void testGetEntity() {
        Entity responseEntity = EntityService.getEntity(createdEntityId);

        assertEquals("Тестовая сущность", responseEntity.getTitle());
        assertTrue(responseEntity.getVerified());
        assertEquals(3, responseEntity.getImportantNumbers().size());
    }
}