package numberrangesummarizer;

import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * @author Jason Kelderman
 *
 *         Assumptions made for this coding challenge:
 * 
 *         Any given String input shall be in the format of "number,number" It
 *         is expected that no alternate special characters nor letters will be
 *         presented
 * 
 *         Any given String shall not contain duplicate values It is expected
 *         that a given String of numbers shall contain only unique values
 * 
 *         A given String of numbers may not be presented in numerical order It
 *         is expected that a string may not be pre-sorted and sorting would
 *         form part of the desired input
 * 
 */

class NumberRangeSummarizerImplementationTest {

	NumberRangeSummarizerImplementation summarizer = new NumberRangeSummarizerImplementation();

	// Test to ensure that function "collect(String input)" returns a collection of
	// numbers
	@Test
	void testCollectReturnsCollection() {
		String testNumbers = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";

		ArrayList<Integer> testAnswerA = new ArrayList<>(
				Arrays.asList(1, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31));

		assertEquals(testAnswerA, summarizer.collect(testNumbers));

	}

	// Test to ensure that function "collect(String input)" returns an unordered
	// collection of numbers in numerical order
	@Test
	void testCollectOrdersNumbers() {
		String testNumbersUnordered = "31,3,6,23,7,24,8,12,13,14,1,15,21,22";

		ArrayList<Integer> testAnswerA = new ArrayList<>(
				Arrays.asList(1, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31));

		assertEquals(testAnswerA, summarizer.collect(testNumbersUnordered));

	}

	// Test to ensure that function "summarizeCollection(Collection<Integer> input)"
	// returns a String containing summarized numbers
	// Tests conducted check for beginning, middle and end of collection
	// summarizations
	@Test
	void testSummarizeCollection() {
		ArrayList<Integer> testArrayGiven = new ArrayList<>(
				Arrays.asList(1, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31));
		
		ArrayList<Integer> testArrayBeginningSummarization = new ArrayList<>(
				Arrays.asList(1, 2, 3, 4, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31));
		
		ArrayList<Integer> testArrayEndingSummarization = new ArrayList<>(
				Arrays.asList(1, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 29, 30, 31));

		String answerGiven = "1, 3, 6-8, 12-15, 21-24, 31";
		String BeginningSummarization = "1-4, 6-8, 12-15, 21-24, 31";
		String EndingSummarization = "1, 3, 6-8, 12-15, 21-24, 29-31";

		assertEquals(answerGiven, summarizer.summarizeCollection(testArrayGiven));
		assertEquals(BeginningSummarization, summarizer.summarizeCollection(testArrayBeginningSummarization));
		assertEquals(EndingSummarization, summarizer.summarizeCollection(testArrayEndingSummarization));

	}

}
