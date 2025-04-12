
import org.example.SecondService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RestServiceTest {  // Лучше называть тест в соответствии с тестируемым классом

    @Test
    void shouldCalculateMonthsOfRest() {
        SecondService service = new SecondService();

        // Пример 1: income=10_000, expenses=3_000, threshold=20_000 → 3 месяца отдыха
        assertEquals(3, service.calculate(10_000, 3_000, 20_000));

        // Пример 2: income=100_000, expenses=60_000, threshold=150_000 → 2 месяца отдыха
        assertEquals(2, service.calculate(100_000, 60_000, 150_000));
    }
}
