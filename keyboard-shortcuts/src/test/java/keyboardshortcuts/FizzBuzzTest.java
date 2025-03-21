package keyboardshortcuts;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class FizzBuzzTest {

    // Rules:
    // - Usually just prints the number itself
    // - For multiples of three print Fizz instead of the number
    // - For the multiples of five print Buzz instead of the number
    // - For numbers which are multiples of both three and five print FizzBuzz instead of the number

    @ParameterizedTest
    @CsvSource({
            "1,1",
            "2,2",
            "3,Fizz",
            "99,Fizz",
            "5,Buzz",
            "100,Buzz",
            "15,FizzBuzz",
            "90,FizzBuzz",
    })
    void rulesOfFizzBuzz(int number, String expected) {
        String actual = fizzbuzz(number);

        assertThat(actual).isEqualTo(expected);
    }

    private String fizzbuzz(int number) {
        if (number % 3 == 0 && number % 5 == 0) {
            return "FizzBuzz";
        }
        if (number % 3 == 0) {
            return "Fizz";
        }
        if (number % 5 == 0) {
            return "Buzz";
        }
        return String.valueOf(number);
    }
}
