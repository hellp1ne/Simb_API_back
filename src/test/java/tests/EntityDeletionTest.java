package tests;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.apache.http.HttpStatus;
import org.junit.Test;
import services.EntityService;
import static org.junit.Assert.assertEquals;

@DisplayName("Тесты удаления сущности")
public class EntityDeletionTest extends BaseTest {
    @Test
    @DisplayName("Проверка удаления сущности")
    @Description("Тест проверяет успешное удаление сущности по ID")
    public void entityDeletion() {
        EntityService.deleteEntity(createdEntityId)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NO_CONTENT);
        markEntityAsDeleted();
    }
}