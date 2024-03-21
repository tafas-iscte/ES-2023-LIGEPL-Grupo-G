package pt.iscte.gestao_de_horarios;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;

public class script extends Thread {

    @Override
    public void run() {
        String folderPath = "C:\\Users\\tiago\\git\\ES-2023-LIGEPL-Grupo-G\\gestao_de_horarios\\uploads";

        // Create a File object representing the folder
        File folder = new File(folderPath);
        while (true) {

            // Check if the folder exists
            if (folder.exists() && folder.isDirectory()) {
                // Get the list of files and directories inside the folder
                File[] files = folder.listFiles();

                // Check if the array is not null and has elements
                if (files != null && files.length > 0) {
                    CsvReader file = new CsvReader();
                    String jsonFileName = file.convertToJson(files[0]);
                    openBrowserWindow("http://localhost:8080/index.html?fileName=" + jsonFileName);
                    break;
                } else {
                    System.out.println("The folder is empty.");
                }
            } else {
                System.out.println("The specified folder does not exist or is not a directory.");
            }
        }
    }

    private void openBrowserWindow(String url) {
        try {
            Desktop.getDesktop().browse(java.net.URI.create(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] Args) {
        new script().start();
    }
}