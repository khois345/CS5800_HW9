import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
	CharacterPropertiesTest.class,
	CharacterPropertiesFactoryTest.class,
	TextCharacterTest.class,
	DocumentTest.class
})
public class CompleteUnitTest {
}
