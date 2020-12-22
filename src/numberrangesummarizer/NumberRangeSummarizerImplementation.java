package numberrangesummarizer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Jason Kelderman
 *
 *         Implementation of given Interface to produce a comma delimited list
 *         of numbers, grouping the numbers into a range when they are
 *         sequential.
 *
 *
 *         Sample Input: "1,3,6,7,8,12,13,14,15,21,22,23,24,31 Result: "1, 3,
 *         6-8, 12-15, 21-24, 31"
 *
 *         Java 15 used for the code below
 * 
 */

public class NumberRangeSummarizerImplementation implements NumberRangeSummarizer {

	@Override
	public Collection<Integer> collect(String input) {
		if (input == null || input.equals("")) {
			return null;
		} else {
			Pattern validInputParameter = Pattern.compile("[^,0-9]");
			Matcher validInputCheck = validInputParameter.matcher(input);
			Boolean invalidInput = validInputCheck.find();

			if (invalidInput) {
				return null;
			} else {
				String[] splitString = input.split(",");
				ArrayList<Integer> numbers = new ArrayList<>();

				for (String element : splitString) {
					numbers.add(Integer.parseInt(element));
				}
				numbers.sort(null);

				return numbers;
			}
		}
	}

	@Override
	public String summarizeCollection(Collection<Integer> input) {
		int endRange;
		int currentNumber;
		String summarizedString = "";

		ArrayList<Integer> givenList = new ArrayList<>(input);

		for (int i = 0; i < givenList.size(); i++) {
			currentNumber = givenList.get(i);
			while ((i + 1 < givenList.size()) && (givenList.get(i + 1) - givenList.get(i) == 1)) {
				i++;
			}

			endRange = givenList.get(i);

			if (currentNumber == endRange) {
				summarizedString += String.valueOf(currentNumber);
			} else if (currentNumber != endRange) {
				summarizedString += String.valueOf(currentNumber) + "-" + String.valueOf(endRange);
			}

			if (givenList.size() - i > 1) {
				summarizedString += ", ";
			}
		}

		return summarizedString;
	}

}
