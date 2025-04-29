// Kaden Jain
// Module 14 lab

// import all the libraries using *
import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption.*;

import static java.nio.file.StandardOpenOption.CREATE;

public class FileScan {
    public static void main(String[] args) {

        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String line = ""; // line by line
        String [] words; // array of words in line
        int lineCount = 0;
        int wordCount = 0;
        int charCount = 0;
        Path file = null;

        try {
            File workingDirectory = new File(System.getProperty("user.dir"));
            if(args.length == 0){
                chooser.setCurrentDirectory(workingDirectory);
                if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    selectedFile = chooser.getSelectedFile();
                    file = selectedFile.toPath();
                }
                else {
                    System.out.println("No file selected!!");
                }
            }
            else{
                file = new File(args[0]).toPath();
            }

            InputStream in = new BufferedInputStream(Files.newInputStream(file, CREATE));
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            while (reader.ready())
            {
                line = reader.readLine();
                words = line.split(" ");
                lineCount++;
                charCount += line.length();
                wordCount += words.length;
            }
            reader.close();
            System.out.println("Lines: " + lineCount);
            System.out.println("Characters: " + charCount);
            System.out.println("Words: " + wordCount);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
    }
}