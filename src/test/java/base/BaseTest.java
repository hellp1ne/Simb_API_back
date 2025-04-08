package base;

import config.RequestSpecificationConfig;
import io.restassured.specification.RequestSpecification;
import models.Entity;
import models.Addition;
import org.junit.After;
import org.junit.Before;
import services.EntityService;
import java.util.Arrays;

/**
 * Базовый тестовый класс для работы с сущностями.
 * Содержит общую логику для всех тестов: создание, удаление сущностей и конфигурацию запросов.
 */
public class BaseTest {
    protected static RequestSpecification requestSpec;
    protected String createdEntityId;
    protected boolean entityAlreadyDeleted = false;

    /**
     * Инициализация теста.
     * Настраивает спецификацию запроса и создает тестовую сущность.
     */
    @Before
    public void setUp() {
        requestSpec = RequestSpecificationConfig.getRequestSpec();
        createdEntityId = createTestEntity();
    }

    /**
     * Завершение теста.
     * Удаляет тестовую сущность, если она не была удалена в тесте.
     */
    @After
    public void tearDown() {
        if (!entityAlreadyDeleted && createdEntityId != null && !createdEntityId.isEmpty()) {
            safeDeleteEntity(createdEntityId);
        }
    }

    /**
     * Создает тестовую сущность с предопределенными значениями для тестирования.
     * @return ID созданной сущности
     */
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

    /**
     * Безопасно удаляет сущность с обработкой возможных ошибок.
     * @param entityId ID сущности для удаления
     */
    private void safeDeleteEntity(String entityId) {
        try {
            EntityService.getEntity(entityId);
            EntityService.deleteEntity(entityId);
        } catch (Exception e) {
            System.out.println("Сущность " + entityId + " уже удалена или недоступна: " + e.getMessage());
        }
    }

    /**
     * Помечает сущность как удаленную.
     * Устанавливает флаг, что сущность была удалена в тесте.
     */
    protected void markEntityAsDeleted() {
        this.entityAlreadyDeleted = true;
    }
}