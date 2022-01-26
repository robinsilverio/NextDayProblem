import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;

public class Test_NextDate {

    @Test
    public void Should_TriggerAnException_When_ExceededDateValuesAreOutsideTheBoundary() {
        // Arrange
        NextDate testSubjectNextDate = new NextDate(31,12,1912);
        String expectedErrorMessage = "error";
        try {
            // Act
            testSubjectNextDate.generateNewDay();
            fail();
        } catch (RuntimeException e) {
            String actualErrorMessage = e.getMessage();
            // Assert
            assertThat(actualErrorMessage, is(expectedErrorMessage));
        }
    }

}
