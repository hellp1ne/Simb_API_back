package base;

import config.RequestSpecificationConfig;
import io.restassured.specification.RequestSpecification;
import models.Entity;
import models.Addition;
import org.junit.After;
import org.junit.Before;
import services.EntityService;
import java.util.Arrays;

public class BaseTest {
    protected static RequestSpecification requestSpec;
    protected String createdEntityId;
    protected boolean entityAlreadyDeleted = false;

    @Before
    public void setUp() {
        requestSpec = RequestSpecificationConfig.getRequestSpec();
        createdEntityId = createTestEntity();
    }

    @After
    public void tearDown() {
        if (!entityAlreadyDeleted && createdEntityId != null && !createdEntityId.isEmpty()) {
            safeDeleteEntity(createdEntityId);
        }
    }

    private String createTestEntity() {
        Addition addition = new Addition();
        addition.setAdditionalInfo("Дополнительные сведения");
        addition.setAdditionalNumber(123);

        Entity entity = new Entity();
        entity.setTitle("Тестовая сущность");
        entity.setVerified(true);
        entity.setImportantNumbers(Arrays.asList(42, 87, 15));
        entity.setAddition(addition);

        return EntityService.createEntity(entity);
    }

    private void safeDeleteEntity(String entityId) {
        try {
            // Проверяем существует ли сущность перед удалением
            EntityService.getEntity(entityId);
            EntityService.deleteEntity(entityId);
        } catch (Exception e) {
            // Сущность уже не существует или другая ошибка
            System.out.println("Сущность " + entityId + " уже удалена или недоступна: " + e.getMessage());
        }
    }

    protected void markEntityAsDeleted() {
        this.entityAlreadyDeleted = true;
    }
}