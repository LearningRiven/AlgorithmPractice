package org.algomonster.spring.service;

import org.springframework.stereotype.Service;
import org.algomonster.algorithms.search.BinarySearch;
import org.algomonster.Utils;

import java.util.List;

@Service
public class BinarySearchService {
    public <T extends Comparable<? super T>> Utils.SearchResult<T> search(List<T> sortedList, T value) {
        return BinarySearch.searchListBinary(sortedList, value, null);
    }
}
