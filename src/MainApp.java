import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class MainApp {



    public static final String delimiter = ",";

    public static void main(String[] args)  throws Exception
    {

        int userChoice = getUserChoiceMCQSet();
        double accumulatedScore = 0;


        // File file = new File(listOfFiles[userChoice-1].getAbsoluteFile());
        File file = new File("C:\\Users\\DevUser\\Documents\\Masteral\\Assignments\\IU3\\src\\questionnaires\\MCQ_Set_1.csv");
        //File file = new File("C:\Users\\DevUser\\Documents\\Masteral\\Assignments\\IU3\\src\\questionnaires\\MCQ_Set_1.csv");
        //File file = new File("src\questionnaires\MCQ_Set_1.csv");
        //System.out.println(listOfFiles[userChoice-1].getAbsoluteFile());

        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line = "";
        String[] questions;

        // use to get user answer
        Scanner sc = new Scanner(System.in);
        while ((line = br.readLine()) != null) {
            questions = line.split(delimiter);

            System.out.println(questions);
            String[] options = {};
            List<String> list = new ArrayList<>();
            for(int i=2; i <= 5; i++ ){
                list.add(questions[i]);
            }

            Question questionItem = new Question(questions[1], list , questions[6] );
            questionItem.display();

            System.out.println("Enter your answer: ");

            int userInput = sc.nextInt();

            System.out.println("Your selected answer: "+userInput);
            String selectedAnswer = questionItem.getAnswer(userInput);

            if(questionItem.isAnswerCorrect(selectedAnswer)){
                accumulatedScore += 1;
                System.out.println("You are correct!");

            }else{
                System.out.println("Incorrect answer");
            }

        }
        System.out.println("Total Score "+ accumulatedScore);
        sc.close();

        br.close();

    }

    public static int getUserChoiceMCQSet()
    {
        Scanner sc = new Scanner(System.in);

        File folder = new File("C:\\Users\\DevUser\\Documents\\Masteral\\Assignments\\IU3\\src\\questionnaires");
        File[] listOfFiles = folder.listFiles();
        System.out.println("---------------------------");
        System.out.println("                            |");
        System.out.println("                            |");
        System.out.println("                            |");
        System.out.println("Select from MCQ Set below   |");
        for (File file: listOfFiles){
            if (file.isFile()){
                System.out.println(file.getName()+"     |");
                System.out.println(file.getAbsoluteFile()+ "     |");
            }
        }
        System.out.println("                            |");
        System.out.println("                            |");
        System.out.println("                            |");
        System.out.println("----------------------------|");
        System.out.print("Enter your choice: ");
        int selected = sc.nextInt();
        //sc.close();
        return selected;
    }
}
