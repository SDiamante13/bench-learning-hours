package duplicationkata;

public class Lesson1Straight extends Song
{
  public void singCatSong()
  {
    singChorus("We gave the cat to a little kid");
    singChorus("We sent the cat out on a boat");
  }

  private void singChorus(String startLine) {
    sing(startLine);
    sing("But the cat came back");
    sing("The very next day");
    sing("Oh the cat came back");
    sing("We thought he was a goner");
    sing("But the cat came back, he just wouldn't go away");
  }
}
