package com.suareztorella.dockerizedapi.pagination;

import java.util.List;

import com.suareztorella.dockerizedapi.directory.Directory;

public class Paginable {

    int count = 0;
    String next = "";
    String previous = "";
    List<Directory> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<Directory> getResults() {
        return results;
    }

    public void setResults(List<Directory> result) {
        this.results = result;
    }

}
