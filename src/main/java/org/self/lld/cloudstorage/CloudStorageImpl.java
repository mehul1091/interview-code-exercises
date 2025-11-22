package org.self.lld.cloudstorage;

import java.util.*;


public class CloudStorageImpl {

    private static Map<String, FileInfo> fileMap;

    public CloudStorageImpl(){
        fileMap = new HashMap<>();
    }

    public boolean addFile(String name, int size) {
        return false;
    }

    public Optional<Integer> getFileSize(String name) {
        return Optional.empty();
    }

    public Optional<Integer> deleteFile(String name) {
        return Optional.empty();
    }


    // should return the list of strings
    // representing the names of the top n largest files with names starting with prefix
    // in the following format:
    //
    // ["<name1>(<size1>)", ..., "<nameN>(<sizeN>)"].
    public List<String> getNLargest(String prefix, int n){

        return new ArrayList<>();
    }

}
