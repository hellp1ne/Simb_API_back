package base;

import config.RequestSpecificationConfig;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.specification.RequestSpecification;
import models.Entity;
import models.Addition;
import org.junit.After;
import org.junit.Before;
import services.EntityService;
import java.util.Arrays;

@DisplayName("Базовый тестовый класс для работы с сущностями")
public class BaseTest {
    protected static RequestSpecification requestSpec;
    protected String createdEntityId;
    protected boolean entityAlreadyDeleted = false;

    @Before
    @DisplayName("Инициализация теста")
    @Description("Настройка спецификации запроса и создание тестовой сущности")
    public void setUp() {
        requestSpec = RequestSpecificationConfig.getRequestSpec();
        createdEntityId = createTestEntity();
    }

    @After
    @DisplayName("Завершение теста")
    @Description("Удаление тестовой сущности, если она не была удалена в тесте")
    public void tearDown() {
        if (!entityAlreadyDeleted && createdEntityId != null && !createdEntityId.isEmpty()) {
            safeDeleteEntity(createdEntityId);
        }
    }

    @DisplayName("Создание тестовой сущности")
    @Description("Создает сущность с предопределенными значениями для тестирования")
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

    @DisplayName("Безопасное удаление сущности")
    @Description("Пытается удалить сущность с обработкой возможных ошибок")
    private void safeDeleteEntity(String entityId) {
        try {
            EntityService.getEntity(entityId);
            EntityService.deleteEntity(entityId);
        } catch (Exception e) {
            System.out.println("Сущность " + entityId + " уже удалена или недоступна: " + e.getMessage());
        }
    }

    @DisplayName("Пометка сущности как удаленной")
    @Description("Устанавливает флаг, что сущность была удалена в тесте")
    protected void markEntityAsDeleted() {
        this.entityAlreadyDeleted = true;
    }
}