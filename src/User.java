import java.util.Scanner;

public class User {
    public String name;
    private double score;

    public User(){}

    public void greetUser()
    {
        this.showIntroMessage();
        this.askUserName();
    }

    private void showIntroMessage()
    {
        System.out.println("Welcome to Silent Library MCQ System");
        System.out.println("You will be given series of questions based on your set selected.");
        System.out.println("First we will need to get your name.");
    }

    private void askUserName()
    {
        System.out.print("Please type your name: ");
        Scanner sc = new Scanner(System.in);
        String username = sc.nextLine();
        this.name = username;
        System.out.print("Thank you " + username);
        System.out.println(". You can proceed to the next step.");
    }
    public void congratulate()
    {
        System.out.println("Congratulations " + this.name + "!");
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
    public void setScore(double score){
        this.score = score;
    }
}
