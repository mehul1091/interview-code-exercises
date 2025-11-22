package org.self.lld.cloudstorage;

public class Runner {

    public static void main(String[] args) {

        CloudStorageImpl cloudStorage = new CloudStorageImpl();

        cloudStorage.addFile("/dir/file1.txt", 5); // returns true
        cloudStorage.addFile("/dir/file2", 20); // returns true
        cloudStorage.addFile("/dir/deeper/file3.mov", 9); //returns true

        cloudStorage.getNLargest("/dir", 2);
        //returns ["/dir/file2(20)", "/dir/deeper/file3.mov(9)"]

        cloudStorage.getNLargest("/dir/file", 3);
        //returns ["/dir/file2(20)", "/dir/file1.txt(5)"]

        cloudStorage.getNLargest("/another_dir", 10);
        //returns Optional.empty(); there are no files with the prefix "/another_dir"

        cloudStorage.addFile("/big_file.mp4", 20);
        //returns true

        cloudStorage.getNLargest("/", 2);
        //returns ["/big_file.mp4(20)", "/dir/file2(20)"];
        // sizes of files are equal, so returned names are sorted lexicographically
        //Lexicographically means in a manner relating to the alphabetical order used in dictionaries
    }
}
