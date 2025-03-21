# Expand Selection

Place the cursor somewhere in the block of code you want to extract as a function. Use 'expand selection' NOT THE MOUSE! Lookup the keyboard shortcut for your tool, it's often Alt-⬆

## Refactor TennisGame1

Go to [TennisGame1](../tennis-refactoring/src/main/java/tennisgame/TennisGame1.java)

Use expand selection to select the piece of code shown, then use 'extract method' or 'extract variable' or 'extract constant' with the name given. Do not use the mouse! Lookup the keyboard shortcuts for your tool.

Keep these instructions at the side of the window somewhere. Run the tests after each refactoring: [TennisTest](../tennis-refactoring/src/test/java/tennisgame/TennisTest.java)

## isTie
variable
<pre> 
m_score1 == m_score2 
</pre>


## scoreWhenTied
method
<pre>
switch (m_score1)
{
    case 0:
        score = "Love-All";
        break;
    case 1:
        score = "Fifteen-All";
        break;
    case 2:
        score = "Thirty-All";
        break;
    default:
        score = "Deuce";
        break;

}
</pre>

## ALL
constant
<pre>
"All"
</pre>

## Separator
constant
<pre>
"-"
</pre>

## isAdvantageOrWin
method
<pre>
m_score1 >= 4 || m_score2 >= 4
</pre>

## scoreName
method
<pre>
switch (tempScore)
{
    case 0:
        score += "Love";
        break;
    case 1:
        score += "Fifteen";
        break;
    case 2:
        score += "Thirty";
        break;
    case 3:
        score += "Forty";
        break;
}
</pre>

## Use your imagination
Extract any more functions, constants, variables or fields that you want to. Continue to use Expand Selection and don't use the mouse!