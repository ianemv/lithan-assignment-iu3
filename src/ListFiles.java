import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListFiles {
    private List<String> files;
    //private File fileSelected;
    private String fileSelected;

    ListFiles(String directoryPath, String ext) throws IOException{
        Path folderPath = Paths.get(directoryPath);

        try (Stream<Path> stream = Files.walk(folderPath, 0)) {
            this.files = stream
                            .map(String::valueOf)
                            .filter(file -> file.contains(ext))
                            .sorted()
                            .collect(Collectors.toList());
        }

        //File folder = new File(directoryPath);
        System.out.println(folderPath);
        System.out.println(this.files);
        //File[] listOfFiles = folder.listFiles();
        //this.files = listOfFiles;
       // System.out.println(listOfFiles);
        System.out.println(directoryPath);
    }

    public void displayFiles() throws IOException
    {
        System.out.println("---------------------------");
        System.out.println("                            |");
        System.out.println("                            |");
        System.out.println("                            |");
        System.out.println("Select from MCQ Set below   |");
        for (String file: this.files){
            System.out.println(file);
        }
        System.out.println("                            |");
        System.out.println("                            |");
        System.out.println("                            |");
        System.out.println("----------------------------|");
    }

    public void selectFile()
    {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter your choice: ");
            int selected = sc.nextInt();
            this.fileSelected = this.files.get(selected -1);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public String getSelectedFile(){
        return this.fileSelected.toString();
    }
}
