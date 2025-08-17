package org.algomonster;

//Sorting algorithms

import com.fasterxml.jackson.databind.ObjectMapper;
import org.algomonster.algorithms.sort.MergeSort;
import org.algomonster.algorithms.sort.QuickSort;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import software.amazon.awssdk.auth.credentials.EnvironmentVariableCredentialsProvider;
import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class S3AlgorithmTest {

    private static final String BUCKET_NAME = "lr-algorithm-practice-repo-test-data";
    private static final String[] KEYS = {"bestCase.json", "averageCase.json", "worstCase.json"};
    private static final Map<String, TestData> testDataMap = new HashMap<>();

    private static class TestData {
        List<Integer> unsorted;
        List<Integer> sorted;
    }

    @BeforeAll
    public static void loadAWSDataFiles() throws IOException {
        S3Client s3 = S3Client.builder()
                .region(Region.of(System.getenv("AWS_REGION")))
                .credentialsProvider(EnvironmentVariableCredentialsProvider.create())
                .build();

        ObjectMapper mapper = new ObjectMapper();
        for (String key : KEYS) {
            GetObjectRequest getRequest = GetObjectRequest.builder()
                    .bucket(BUCKET_NAME)
                    .key(key)
                    .build();
            ResponseInputStream<GetObjectResponse> s3Object = s3.getObject(getRequest);

            @SuppressWarnings("unchecked")
            Map<String, List<Integer>> data = mapper.readValue(s3Object, Map.class);

            TestData testData = new TestData();
            testData.unsorted = data.get("unsorted");
            testData.sorted = data.get("sorted");
            testDataMap.put(key.split("\\.")[0], testData); // e.g., "bestCase"
        }
    }

    @Test
    void testMergeBestCase(){
        TestData data = testDataMap.get("bestCase");
        List<Integer> actual = new java.util.ArrayList<>(data.unsorted);
        List<Integer> solution = MergeSort.sortListMerge(actual);
        assertIterableEquals(data.sorted, solution);
    }

    @Test
    void testMergeAverageCase(){
        TestData data = testDataMap.get("averageCase");
        List<Integer> actual = new java.util.ArrayList<>(data.unsorted);
        List<Integer> solution = MergeSort.sortListMerge(actual);
        assertIterableEquals(data.sorted, solution);
    }

    @Test
    void testMergeWorstCase(){
        TestData data = testDataMap.get("worstCase");
        List<Integer> actual = new java.util.ArrayList<>(data.unsorted);
        List<Integer> solution = MergeSort.sortListMerge(actual);
        assertIterableEquals(data.sorted, solution);
    }


    @Test
    void testQuickSortBestCase() {
        TestData data = testDataMap.get("bestCase");
        List<Integer> actual = new java.util.ArrayList<>(data.unsorted);
        QuickSort.sortListQuickSort(actual,"MedianOf3");
        assertIterableEquals(data.sorted, actual);
    }

    @Test
    void testQuickSortAverageCase() {
        TestData data = testDataMap.get("averageCase");
        List<Integer> actual = new java.util.ArrayList<>(data.unsorted);
        QuickSort.sortListQuickSort(actual,"MedianOf3");
        assertIterableEquals(data.sorted, actual);
    }

    @Test
    void testQuickSortWorstCase() {
        TestData data = testDataMap.get("worstCase");
        List<Integer> actual = new java.util.ArrayList<>(data.unsorted);
        QuickSort.sortListQuickSort(actual,"MedianOf3");
        assertIterableEquals(data.sorted, actual);
    }

}
