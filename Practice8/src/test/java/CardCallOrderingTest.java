import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class CallCallOrderingTest {
    private WebDriver driver;

    @BeforeAll
    static void setUpAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.get("http://localhost:9999");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    void shouldTestHappyPath() throws InterruptedException {
        //Отправка сообщений
        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Осконбаев Миразиз");
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+79692802752");
        //Нажали на галочку
        driver.findElement(By.cssSelector("[data-test-id=agreement]")).click();
        //Задержка браузера
        Thread.sleep(3000);
        //Нажатие на кнопку "Продолжить"
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/form/div[4]/button")).click();
        //Проверка на согласованность
        String actualText = driver.findElement(By.cssSelector("[data-test-id=order-success]")).getText();
        String expectedText = "  Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";

        Assertions.assertEquals(expectedText, actualText);
    }

    @Test
    void shouldTestEmptyName() throws InterruptedException {

        //Отправка сообщений
        //driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Осконбаев Миразиз");
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+79692802752");
        //Нажали на галочку
        driver.findElement(By.cssSelector("[data-test-id=agreement]")).click();
        //Задержка браузера
        Thread.sleep(3000);
        //Нажатие на кнопку "Продолжить"
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/form/div[4]/button")).click();
        Thread.sleep(5000);
        //Проверка на согласованность
        String actualText = driver.findElement(By.className("input__sub")).getText().trim();
        String expectedText = "Поле обязательно для заполнения";

        Assertions.assertEquals(expectedText, actualText);
    }

    @Test
    void shouldTestNoValid() throws InterruptedException {
        //Отправка сообщений
        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Miraziz");
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+79692802752");
        //Нажали на галочку
        driver.findElement(By.cssSelector("[data-test-id=agreement]")).click();
        //Задержка браузера
        Thread.sleep(3000);
        //Нажатие на кнопку "Продолжить"
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/form/div[4]/button")).click();
        Thread.sleep(5000);
        //Проверка на согласованность
        String actualText = driver.findElement(By.className("input__sub")).getText().trim();
        String expectedText = "Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.";

        Assertions.assertEquals(expectedText, actualText);
    }
}
