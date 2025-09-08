package com.in28minutes.mockito.Mockito_demo.Business;

public class SomeBusinessImpl {

    DataService dataService;

    public SomeBusinessImpl(DataService dataService) {
        this.dataService = dataService;
    }

    public int findGreatestValue(){
        int[] data = dataService.retriveAllData();

        int greatestVal = Integer.MIN_VALUE;

        for(int value: data){
            if(value>greatestVal){
                greatestVal = value;
            }
        }
        return greatestVal;
    }
}


