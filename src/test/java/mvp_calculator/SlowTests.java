package mvp_calculator;
/*
 * @author Tooba Nadeem
 */
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

/**
 * Suite for slow, data-driven tests (CSV-based).
 */
@Suite
@SelectClasses({
    CalculatorModelDataDrivenTest1.class,
    CalculatorModelDataDrivenTest2.class
})
public class SlowTests {
}
