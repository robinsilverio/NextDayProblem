import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;

public class Test_NextDate {

    @Test
    public void Should_ReturnTrue_When_AllFiveExceededNextDatesAreInvalid() {
        // Arrange
        NextDate[] testSubjectsExceededNextDates = new NextDate[] {
                new NextDate(2, 30, 1812),
                new NextDate(6, 31, 1912),
                new NextDate(6, 0, 1912),
                new NextDate(0, 16, 1912),
                new NextDate(15, 6, 1811),
        };
        int expectedErrorCount = 5;
        // Act
        int actualErrorCount = 0;
        for (NextDate date : testSubjectsExceededNextDates) {
            try {
                date.generateNewDay();
                fail();
            } catch (RuntimeException e) {
                actualErrorCount++;
            }
        }
        // Assert
        assertThat(actualErrorCount, is(expectedErrorCount));
    }

    // Test case voor het testen van blauwe balletjes, oftewel net aan de grens.
    @Test
    public void Should_ReturnTrue_When_GeneratingNewDayWithMinimumValuesWentSuccessful() {
        // Arrange
        NextDate[] testSubjectsminimumsNextDates = new NextDate[] {
                new NextDate(6, 1, 1912),
                new NextDate(1, 15, 1912),
                new NextDate(6, 15, 1812),
        };
        String[] expectedNewDates = new String[] {
            "June 2, 1912",
            "January 16, 1912",
            "June 16, 1812",
        };
        // Act
        String[] actualNextDates = new String[3];
        for (int i = 0; i < testSubjectsminimumsNextDates.length; i++) {
            testSubjectsminimumsNextDates[i].generateNewDay();
            actualNextDates[i] = testSubjectsminimumsNextDates[i].showNewDate();
        }
        // Assert
        assertThat(actualNextDates, is(expectedNewDates));
    }

    // Test case for het testen van het rode balletje, oftewel de normale/gemiddelde datum binnen het bereik
    @Test
    public void Should_ReturnTrue_When_GeneratingNextDateWithAverageValuesWentSuccessful() {
        // Arrange
        NextDate testSubjectNextDate = new NextDate(6, 16, 1912);
        String expectedNextDate = "June 17, 1912";
        // Act
        testSubjectNextDate.generateNewDay();
        String actualNextDate = testSubjectNextDate.showNewDate();
        // Assert
        assertThat(actualNextDate, is(expectedNextDate));
    }

}
