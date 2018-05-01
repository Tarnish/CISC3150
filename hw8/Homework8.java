/* Ryan Gadalkin : HW8
   Reference/Citation - https://www.computerhope.com/treehlp.htm
                      - https://stackoverflow.com/questions/1053467/how-do-i-save-a-string-to-a-text-file-using-java
                      - https://stackoverflow.com/questions/462110/acquiring-drive-names-as-opposed-to-drive-letters-in-java
                      - https://stackoverflow.com/questions/21985034/how-to-find-out-operating-system-drive-using-java
                      - https://docs.oracle.com/javase/7/docs/api/java/io/File.html
                      - https://stackoverflow.com/questions/1844688/how-to-read-all-files-in-a-folder-from-java
**/

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Homework8 {

    public static void main(String[] args) {
        try {
            PrintWriter output = new PrintWriter("dir_tree.txt");
            File startDirectory = new File(args[0]);

            output.printf("%s (%s):.\n", System.getenv("SystemDrive"), startDirectory.getCanonicalPath());
            printDirectoryContent(startDirectory.listFiles(), 3, output);
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printDirectoryContent(File[] fileList, int defaultSp, PrintWriter output) {
        for (File dirFile : fileList) {
            if (dirFile.isDirectory()) {
                setIndentation(defaultSp, output);
                output.printf("%s\n", dirFile.getName());
                printDirectoryContent(dirFile.listFiles(), defaultSp + 6, output); // If using normal characters use 4 to even out
            }
        }

        for (File singFile : fileList) {
            if (singFile.isFile()) {
                setIndentation(defaultSp, output);
                output.printf("%s\n", singFile.getName());
            }
        }
    }

    static void setIndentation(int sp, PrintWriter output) {
        // Non-top level directory needs initial pipe
        if (sp != 3) {
            output.print("│");
            sp--;
        }

        // Spacing before pipe
        for (int i = 0; i < sp-3; i++) {
            output.print(" ");
        }

        // Pipe from parent directory -> child file/directory
        output.print("│"); // special char (Not '|')

        // Space file/directory equal amount
        for (int i = sp-3; i < sp; i++) {
            output.print("─"); // special char (Not '-')
        }
    }
}