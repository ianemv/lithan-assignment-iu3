import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;


/**
 * @author Ian Villanueva
 * @version 0.0.1
 * ListFiles class for accessing the system assigned directory.
 * Shall display all the files under the directory and let user select what file to be used for the quiz.
 *
 */
public class ListFiles {
    private List<String> files;
    //private File fileSelected;
    private String fileSelected;
    private File[] folderFiles;
    private String ext;
    private String directoryPath;

    ListFiles(String directoryPath, String ext) throws IOException{

        File folder = new File(directoryPath);
        this.folderFiles = folder.listFiles();
        this.directoryPath = directoryPath;
        this.ext = ext;
    }

    public void getUserFileChoice() throws IOException{
        displayMenu();
        selectFile();
    }
    private void displayMenu() throws IOException
    {
        System.out.println("---------------------------");
        System.out.println("                            |");
        System.out.println("                            |");
        System.out.println("                            |");
        System.out.println("Choose your multiple choice question below.   |");
        System.out.println("Type the number of your choice.   |");
        String filename = "";
        for (int i=0; i < this.folderFiles.length; i++){
            filename = this.folderFiles[i].getName();
            System.out.println( (i+1) + ") "+filename.substring(0, filename.length() - 4 ));
        }
        System.out.println("                            |");
        System.out.println("                            |");
        System.out.println("----------------------------|");
    }

    private void selectFile()
    {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter your choice: ");
            int selected = sc.nextInt();
            //if (selected )
            this.fileSelected = this.folderFiles[selected -1].getName();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public String getSelectedFile(){
        return this.directoryPath + "/"+ this.fileSelected.toString();
    }
}
