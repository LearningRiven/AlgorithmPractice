package org.algomonster.spring.controller;

import org.algomonster.Utils;
import org.algomonster.spring.service.BinarySearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BinarySearchController {
    @Autowired
    private BinarySearchService service;

    @GetMapping("/search")
    public Utils.SearchResult<Integer> search(@RequestParam Integer value) {
        List<Integer> sample = Arrays.asList(1, 3, 6, 8, 9, 10);
        return service.search(sample, value);
    }
}
