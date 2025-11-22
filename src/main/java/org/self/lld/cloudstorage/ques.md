Implement an operation for retrieving some statistics about files with a specific prefix.

List<String> getNLargest(String prefix, int n) 
— should return the list of strings representing the names of the top n largest files with names starting with prefix 
in the following format: ["<name1>(<size1>)", ..., "<nameN>(<sizeN>)"]. 

- Returned files should be sorted by size in descending order, or in case of a tie, sorted in lexicographical order of the names.
- If there are no such files, return an empty list. 
- If the number of such files is less than n, all of them should be returned in the specified format.
