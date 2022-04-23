import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * CLass for the MCQ Set.
 *
 */

public class MCQSet {
    File selectedFile;
    private double accumulatedScore = 0;
    private double total = 0;
    String delimiter;

    /*
    * @selectedFile file selected by the user;
    * @delimeter
    * */
    public MCQSet(File selectedFile, String delimiter){
        this.selectedFile = selectedFile;
        this.delimiter = delimiter;
    }

    public void startQuiz() throws IOException
    {
        FileReader fr = new FileReader(this.selectedFile);
        BufferedReader br = new BufferedReader(fr);
        String line = "";
        String[] questions;

        // use to get user answer
        Scanner sc = new Scanner(System.in);
        while ((line = br.readLine()) != null) {

            questions = line.split(this.delimiter);

            if (line.equals("")) {
                continue;
            }

            System.out.println(questions);
            String[] options = {};
            List<String> list = new ArrayList<>();
            for(int i=2; i <= 5; i++ ){
                list.add(questions[i]);
            }

            Question questionItem = new Question(questions[1], list , questions[6] );
            printLineDiv();
            questionItem.display();
            printLineDiv();

            System.out.println("Enter your answer: ");

            int userInput = sc.nextInt();

            System.out.println("Your selected answer: "+userInput);
            String selectedAnswer = questionItem.getAnswer(userInput);

            if(questionItem.isAnswerCorrect(selectedAnswer)){
                this.accumulatedScore += 1;
                System.out.println("You are correct!");
            }else{
                System.out.println("Incorrect answer");
            }
            this.total += 1;
        }
        br.close();
    }

    private void printLineDiv()
    {
        System.out.println("======================================");
        System.out.println("");
        System.out.println("");
        System.out.println("");
    }

    private double calculateRate()
    {
        double rate = this.accumulatedScore/this.total * 100;
        return rate;
    }

    public void showResult()
    {
        System.out.println("======================================");
        System.out.println("Your total score is: " + this.accumulatedScore);
        System.out.println("Your wrong answer is: " + (this.total - this.accumulatedScore));
        System.out.println("Your rate is: " + this.calculateRate());

    }

    public double getAccumulatedScore()
    {
        return this.accumulatedScore;
    }
}
