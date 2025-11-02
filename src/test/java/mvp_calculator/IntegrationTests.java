package mvp_calculator;
/*
 * @author Tooba Nadeem
 */
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

/**
 * Suite for integration tests (Presenter + App).
 */
@Suite
@SelectClasses({
    CalculatorPresenterTest.class,
    CalculatorAppTest.class
})
public class IntegrationTests {
}
