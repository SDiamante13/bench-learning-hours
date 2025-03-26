# tdd-training-katas

## Refactoring Series

- [Intro to Code Smells](tennis-refactoring/src/main/java/tennisgame/TennisGame1.java)
- [Refactoring Misconceptions](tennis-refactoring/src/main/java/tennisgame/TennisGame3.java)
- [Keyboard Shortcuts](keyboard-shortcuts/README.md)
- [Intro to Ensemble Programming](tennis-refactoring/src/main/java/tennisgame/TennisGame1.java)
- [Naming as a Process](chart-smart/src/main/java/chartsmart/ChartWindow.java)

## How to create and apply git patches

### Typist creates the patch
> git diff > name.patch


### New Typist apply the patch (may want to clear changes first)
> git co . OR git reset --hard origin/main
> 
> git apply name.patch