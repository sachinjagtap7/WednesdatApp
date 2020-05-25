package com.example.wednesdayapp.utils.models;

import java.util.List;

public class RootData {

    private int resultCount;

    private List<ItunesResultData> results;

    public void setResultCount(int resultCount) {
        this.resultCount = resultCount;
    }

    public int getResultCount() {
        return this.resultCount;
    }

    public void setResults(List<ItunesResultData> results) {
        this.results = results;
    }

    public List<ItunesResultData> getResults() {
        return this.results;
    }
}
