# Duplicate Lines

Instead of copying and pasting code with two separate keyboard shortcuts, you can also duplicate one or more lines. This is often convenient for example when creating parameterized tests.

Aim to create this additional test case in [FizzBuzzTest](src/test/java/keyboardshortcuts/FizzBuzzTest.java). Begin with just one line:

    "2,2",

Duplicate it and edit it as needed to get 8 test cases. Don't forget you can duplicate two or four lines at a time, and use multiple cursors to edit them.

Aim for this:

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
