package Buoi7;

public class StoredFilesTestDrive {
    public static void main(String[] args) {
        StoredFiles storedFiles = new StoredFiles("accounts.json");

        int index = storedFiles.search("email", "phu@gmail.com");

        System.out.println("");
    }
}
