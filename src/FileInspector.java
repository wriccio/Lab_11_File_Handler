import javax.swing.JFileChooser;
import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileInspector
{
    public static void main(String[] args)
    {
        JFileChooser chooser = new JFileChooser();
        File workingDirectory =
                new File(System.getProperty("user.dir"));
        chooser.setCurrentDirectory(workingDirectory);
        if (chooser.showOpenDialog(null)

                != JFileChooser.APPROVE_OPTION)
        {
            System.out.println("No file selected. Exiting.");

            System.exit(0);
        }
        Path selectedPath = chooser.getSelectedFile().toPath();
        String fileName =
                selectedPath.getFileName().toString();
        int lineCount = 0;
        try (BufferedReader reader =
                     Files.newBufferedReader(selectedPath))
        {
            String line;

            System.out.println("File Contents");
            System.out.println("-------------");
            while ((line = reader.readLine()) != null)
            {
                System.out.println(line);

                lineCount++;
            }
            System.out.println();
            System.out.println("File Report");
            System.out.println("-----------");
            System.out.println("File Name: " + fileName);
            System.out.println("Total Lines: " + lineCount);
        }
        catch (IOException e)
        {
            System.out.println("An error occurred.");

            e.printStackTrace();
        }
    }
}
