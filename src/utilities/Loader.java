/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 *
 * @author Administrator
 */
public class Loader {

    private final static String SYSPATH = new File("").getAbsolutePath() + "\\src\\";

    /**
     * Initializes the path by concatenating the provided path with the system
     * path.
     *
     * @param path The path to be initialized.
     * @return The initialized path, which is the concatenation of the system
     * path and the provided path.
     */
    public static String initPath(String path) {
        return SYSPATH + path;
    }

    /**
     * Reads data from a file and returns it as an ArrayList of strings.
     *
     * @param filePath The path to the file to read.
     * @return An ArrayList of strings containing the data read from the file.
     */
    public static ArrayList<String> readFromFile(String filePath) {
        String path = initPath(filePath);
        File file = new File(path);
        ArrayList<String> dta = new ArrayList<>();
        try {
            try (FileInputStream fis = new FileInputStream(file); ObjectInputStream ois = new ObjectInputStream(fis)) {
                dta = (ArrayList<String>) ois.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
        }
        return dta;
    }

    /**
     * Writes the given data to a file.
     *
     * @param filePath The path to the file to write.
     * @param dta The data to write to the file.
     */
    public static void writeToFile(String filePath, ArrayList<String> dta) {
        String path = initPath(filePath);
        File file = new File(path);
        try {
            file.createNewFile();
            try (FileOutputStream fos = new FileOutputStream(file); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(dta);
            }
        } catch (IOException e) {
        }
    }

    /**
     * Retrieves the filenames of all files in the specified package.
     *
     * @param packageName The name of the package.
     * @return An ArrayList of filenames.
     * @throws IOException If an I/O error occurs while retrieving the
     * filenames.
     */
    public static ArrayList<String> getFilenameInPackage(String packageName) throws IOException {
        ArrayList<String> filenames = new ArrayList<>();
        String packagePath = packageName.replace('.', '/');
        URL url = Thread.currentThread().getContextClassLoader().getResource(packagePath);
        if (url != null) {
            String protocol = url.getProtocol();
            if (protocol.equals("file")) {
                String directoryPath = url.getPath();
                filenames.addAll(getFilenamesInDirectory(directoryPath));

            } else if (protocol.equals("jar")) {
                JarURLConnection jarConnection = (JarURLConnection) url.openConnection();
                try (JarFile jarFile = jarConnection.getJarFile()) {
                    Enumeration<JarEntry> entries = jarFile.entries();
                    while (entries.hasMoreElements()) {
                        JarEntry entry = entries.nextElement();
                        String entryName = entry.getName();
                        
                        if (!entry.isDirectory() && entryName.startsWith(packagePath)) {
                            filenames.add(entryName);
                        }
                    }
                }
            }
        }
        return filenames;
    }

    /**
     * Retrieves the filenames of all files in the specified directory.
     *
     * @param directoryPath The path of the directory.
     * @return An ArrayList of filenames.
     */
    private static ArrayList<String> getFilenamesInDirectory(String directoryPath) {
        ArrayList<String> filenames = new ArrayList<>();
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    filenames.add(file.getName());
                }
            }
        }
        return filenames;
    }
}
