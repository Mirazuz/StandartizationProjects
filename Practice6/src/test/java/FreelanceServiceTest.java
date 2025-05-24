
import org.example.FreelanceService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class FreelanceServiceTest {

    @ParameterizedTest
    @CsvSource({
            "10000, 3000, 20000, 3",
            "100000, 60000, 150000, 2"
    })
    public void testCalculateRestMonths(int income, int expenses, int threshold, int expected) {
        FreelanceService service = new FreelanceService();
        int actual = service.calculateRestMonths(income, expenses, threshold);
        Assertions.assertEquals(expected, actual);
    }
}