import org.example.SecondService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RestParamTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/test_data.csv", numLinesToSkip = 1)
    void shouldCalculateAllConditionals(int income, int expenses, int threshold, int expected) {
        SecondService service = new SecondService();
        int actual = service.calculate(income, expenses, threshold);
        assertEquals(expected, actual);
    }
}