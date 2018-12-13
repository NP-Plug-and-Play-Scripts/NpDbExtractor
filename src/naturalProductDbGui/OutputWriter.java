/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naturalProductDbGui;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Outputwriter is able to create a file and write to it. has 3 methods.
 * OpenFile opens a new file writeLine takes a input string and writes it in the
 * file, closeFile closes the file.
 *
 * @author ozing003
 */
public class OutputWriter {

    private BufferedWriter bw;

    /**
     * takes a line and writes it in the opened file.
     *
     * @param line
     * @throws IOException
     */
    public void writeLine(String line) throws IOException {
        String editedLine = line.trim() + "\n";
        bw.write(editedLine);

    }

    /**
     * opens a file with the File saveFile given to it.
     * in case the file doesnt end with .csv it changes it to .csv
     * @param saveFile
     */
    public void openCsvFile(File saveFile) {
        FileWriter fw;
        String filePath = saveFile.toString();
        if (!filePath.endsWith(".csv")) {
            String[] splittedPath = filePath.split("\\.");
            String adjustedFile = splittedPath[0]+ ".csv";
            File csvFile = new File(adjustedFile);
            try {
                if (!csvFile.exists()) {
                    csvFile.createNewFile();
                }
                fw = new FileWriter(csvFile);
                bw = new BufferedWriter(fw);
            } catch (IOException e) {
            }
        } else {
            try {
                if (!saveFile.exists()) {
                    saveFile.createNewFile();
                }
                fw = new FileWriter(saveFile);
                bw = new BufferedWriter(fw);
            } catch (IOException e) {
            }
        }

    }

    ;
    /**
     * closes the file
     * @throws IOException 
     */
    public void closeFile() throws IOException {
        bw.close();
    }

}
