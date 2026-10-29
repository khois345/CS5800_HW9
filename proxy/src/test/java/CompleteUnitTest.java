import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
	SongTest.class,
	SongServerTest.class,
	SongServiceProxyTest.class
})
public class CompleteUnitTest {
}
