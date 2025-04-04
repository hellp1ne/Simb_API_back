package tests;

import base.BaseTest;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class CreateEntityTest extends BaseTest {
    @Test
    public void testCreateEntity() {
        // Сущность уже создана в BaseTest.setUp()
        assertNotNull(createdEntityId);
    }
}