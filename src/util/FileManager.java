package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileManager {

    // Create a directory if it does not already exist
    public static void createDirectory(String directoryName)
            throws IOException {

        Path path = Path.of(directoryName);

        if (!Files.exists(path)) {
            Files.createDirectories(path);
            System.out.println(
                    "Directory created: " + path
            );
        } else {
            System.out.println(
                    "Directory already exists: " + path
            );
        }
    }

    // Check whether a file or directory exists
    public static boolean exists(String fileName) {

        Path path = Path.of(fileName);

        return Files.exists(path);
    }

    // Write text into a file
    public static void writeFile(
            String fileName,
            String content) throws IOException {

        Path path = Path.of(fileName);

        Files.writeString(
                path,
                content,
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING
        );

        System.out.println(
                "File written successfully."
        );
    }

    // Read all lines from a file
    public static void readFile(
            String fileName) throws IOException {

        Path path = Path.of(fileName);

        if (!Files.exists(path)) {
            System.out.println(
                    "File does not exist."
            );
            return;
        }

        List<String> lines =
                Files.readAllLines(path);

        System.out.println("\nFile Content:");

        for (String line : lines) {
            System.out.println(line);
        }
    }

    // Copy a file
    public static void copyFile(
            String source,
            String destination) throws IOException {

        Path sourcePath = Path.of(source);
        Path destinationPath = Path.of(destination);

        Files.copy(
                sourcePath,
                destinationPath
        );

        System.out.println(
                "File copied successfully."
        );
    }

    // Move a file
    public static void moveFile(
            String source,
            String destination) throws IOException {

        Path sourcePath = Path.of(source);
        Path destinationPath = Path.of(destination);

        Files.move(
                sourcePath,
                destinationPath
        );

        System.out.println(
                "File moved successfully."
        );
    }

    // Delete a file or empty directory
    public static void deleteFile(
            String fileName) throws IOException {

        Path path = Path.of(fileName);

        if (Files.exists(path)) {

            Files.delete(path);

            System.out.println(
                    "File or directory deleted successfully."
            );

        } else {

            System.out.println(
                    "File or directory does not exist."
            );
        }
    }
}
