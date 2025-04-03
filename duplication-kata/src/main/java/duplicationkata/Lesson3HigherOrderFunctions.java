package duplicationkata;

import java.util.function.IntFunction;

public class Lesson3HigherOrderFunctions extends Song
{
  public void singCheers()
  {
    singTag(n -> n + 2, 2, "Who do we appreciate?");
    singTag(this::getNextPrime, 17, "These are the primes, that we find fine!");
  }

  private void singTag(IntFunction<Integer> function, int number, String tagLine) {
    sing(number + "! ");
    number = function.apply(number);
    sing(number + "! ");
    number = function.apply(number);
    sing(number + "! ");
    number = function.apply(number);
    sing(number + "! ");
    sing(tagLine);
  }

  private int getNextPrime(int number)
  {
    switch (number)
    {
      case 13 :
        return 17;
      case 17 :
        return 19;
      case 19 :
        return 23;
      case 23 :
        return 29;
    }
    return 0;
  }
}
