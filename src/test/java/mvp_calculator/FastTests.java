package mvp_calculator;
/*
 * @author Tooba Nadeem
 */
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

/**
 * Suite for fast, lightweight unit tests.
 */
@Suite
@SelectClasses({
    CalculatorModelTest.class,
    CalculatorViewTest.class
})
public class FastTests {
}
