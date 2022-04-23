import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class MainApp {



    public static final String delimiter = ",";
    public ListFiles listFile;

    public static void main(String[] args)  throws Exception
    {

        User activeUser = new User();
        activeUser.greetUser();

        ListFiles fileLister = new ListFiles("./src/questionnaires", ".csv");
        fileLister.getUserFileChoice();

        File file = new File(fileLister.getSelectedFile());
        MCQSet selectedMCQ = new MCQSet(file, delimiter);
        selectedMCQ.startQuiz();

        activeUser.setScore(selectedMCQ.getAccumulatedScore());
        activeUser.congratulate();

        selectedMCQ.showResult();
    }

}
