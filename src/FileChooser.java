import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;
import javax.swing.JFileChooser;
//Import the libraries needed for this program, including the JFileChooser

public class FileChooser {
    public static void main(String[] args) {

        /*Initialize the chooser, scanner, line String, Path filename, target
        * along with ints for the countSymbols, countLines, and countWords; also initializes
        * a string for the wordList array*/
        JFileChooser chooser = new JFileChooser();
        Scanner inFile;
        String line;
        Path Filename;
        Path target = new File(System.getProperty("user.dir")).toPath();
        target = target.resolve("src");
        int countSymbols = 0;
        int countLines = 0;
        int countWords = 0;
        String wordlist[];

        //The chooser sets the current directory of the file
        chooser.setCurrentDirectory(target.toFile());

        //main operation
        try
        {

            //Starts dialog box for user to select a file
            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                //Assigns the target variable for the chosen file
                target = chooser.getSelectedFile().toPath();

                //Gets the name of the file
                inFile = new Scanner(target);
                int i = 5;
                Filename = target.getName(i);
                while(inFile.hasNextLine())
                {
                    //Scan file for words, lines, symbols
                    line = inFile.nextLine();
                    countLines = countLines + 1;
                    wordlist = line.split(" ");
                    countWords = wordlist.length +countWords;
                    countSymbols = line.length() + countSymbols;
                }
                //Prints out details of the selected file
                System.out.println("Name: "+Filename);
                System.out.println("Lines: "+countLines);
                System.out.println("Words: "+countWords);
                System.out.println("Characters: "+countSymbols);

                //Closes the file
                inFile.close();
            }
            else
            {
                //The user doesn't choose a file
                System.out.println("You did not choose a file. Quitting.");
                System.exit(0);
            }
        }
        catch (FileNotFoundException e)
        {
            //Error for file not found
            System.out.println("File Not Found Error");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            //error for input-output operation
            System.out.println("IOException Error");
            e.printStackTrace();
        }
    }
}
