import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class MainApp {

    double accumulatedScore;

    public static final String delimiter = ",";

    public static void main(String[] args)  throws Exception
    {

        int userChoice = getUserChoice();

        // File file = new File(listOfFiles[userChoice-1].getAbsoluteFile());
        File file = new File("C:\\Users\\DevUser\\Documents\\Masteral\\Assignments\\IU3\\src\\questionnaires\\MCQ Set 1.csv");

        // System.out.print("\033[H\033[2J");

        //System.out.println(listOfFiles[userChoice-1].getAbsoluteFile());
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line = " ";
        String[] tempArr;
        while ((line = br.readLine()) != null) {
            tempArr = line.split(delimiter);

            System.out.println(tempArr);
            String[] options = {};
            List<String> list = new ArrayList<>();
            for(int i=2; i <=5; i++ ){
                list.add(tempArr[i]);
            }

            Question questionItem = new Question(tempArr[1], list , tempArr[5] );
            questionItem.display();
            System.out.print("Enter your answer: ");
            selected = sc.nextLine();
            System.out.println("Your selected answer: "+selected);

        }
        br.close();

    }

    public static int getUserChoice()
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
            }
        }
        System.out.println("                            |");
        System.out.println("                            |");
        System.out.println("                            |");
        System.out.println("----------------------------|");
        System.out.print("Enter your choice: ");
        String selected = sc.nextLine();
        int userChoice = parseInt(selected);
        return userChoice;
    }
}
