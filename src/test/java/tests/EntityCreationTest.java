package tests;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

@DisplayName("Тесты создания сущности")
public class EntityCreationTest extends BaseTest {
    @Test
    @DisplayName("Проверка создания сущности")
    @Description("Тест проверяет успешное создание новой сущности")
    public void entityCreation() {
        assertNotNull(createdEntityId);
    }
}