package com.armando.addnumbers.services;

import com.armando.addnumbers.model.http.AddNumbersRequest;
import com.armando.addnumbers.model.http.AddNumbersResult;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * Created on 2020-10-13.
 */
@Service
public class DefaultAddNumbersService implements AddNumbersService {
    private final HistoryService historyService;

    public DefaultAddNumbersService(final HistoryService historyService) {
        this.historyService = historyService;
    }

    @Override
    public AddNumbersResult add(final AddNumbersRequest request) {
        int[] addend1 = request.getAddend1();
        int[] addend2 = request.getAddend2();
        int[] resultArray = sumArrays(addend1, addend2);

        AddNumbersResult result =  AddNumbersResult
                .builder()
                .addend1(addend1)
                .addend2(addend2)
                .result(resultArray)
                .build();

        historyService.saveToHistory(result);

        return result;
    }

    private int[] sumArrays(final int[] arr1, final int[] arr2){

        //Get the max length and add 1 to make sure the result array size can hold the resulting number
        int maxLength = Math.max(arr1.length, arr2.length) + 1;
        //Make the original array same size as the max length and fill the empty positions with zeros
        int[] addend1 = fillWithZeros(arr1, maxLength);
        int[] addend2 = fillWithZeros(arr2, maxLength);
        int[] result = new int[maxLength];

        int carryNumber = 0;

        for(int i = maxLength - 1 ; i > 0 ; i--){
            int currentResult = addend1[i] + addend2[i] + carryNumber;

            if(currentResult > 9) {
                result[i] = currentResult % 10;
                carryNumber = currentResult / 10;

            } else {
                result[i] = currentResult;
                carryNumber = 0;
            }
        }

        return removeLeadingZeros(result);
    }


    private int[] removeLeadingZeros(int[] arr){
        int firstNonZeroIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                firstNonZeroIndex = i;
                break;
            }
        }

        int[] result = new int[arr.length - firstNonZeroIndex];

        if (arr.length - firstNonZeroIndex >= 0)
            System.arraycopy(arr, firstNonZeroIndex + 0, result, 0, arr.length - firstNonZeroIndex);

        return result;

    }

    private int[] fillWithZeros(int[] arr, int maxLength){
        int[] result = new int[maxLength];

        for(int i = maxLength , j = 1; i > 0; i--, j++){
            int oldArrayIndex = arr.length - j;
            result[i-1] = oldArrayIndex < 0 ? 0 : arr[oldArrayIndex];
        }

        return result;
    }

}
