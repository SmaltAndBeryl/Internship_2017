package com.skill.India.POC;

import org.apache.commons.collections.MultiMap;
import org.apache.commons.collections.map.MultiValueMap;

import java.util.ArrayList;

public class AlgoPoc {
    int call = 0;
    public String recommendedAgencyName(ArrayList<Integer> agencyIdShowInterest){

        System.out.println("Call = " + call++);
        //Values to compare to
        String stateCmp = "Bihar";
        String districtCmp = "Buxar";
//        NonAssignedBatchesService nonAssignedBatchesService = new NonAssignedBatchesService();
//
//        //Values to be compared

        // Printing the array list
        for(Object o: agencyIdShowInterest){
            System.out.println("The shown interest bodies are >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + o);
        }


        String state[] =     {"UP"  , "UP"   , "UP"     , "Bihar"           ,"Bihar"    ,"Bihar"     , "UP"       ,   "Bihar" ,   "Bihar", " UP"    , "Bihar", "Bihar"};
        String district[] = {"NOIDA", "NOIDA", "Lucknow", "Muzzafarpur"     ,"Patna"    ,"Samastipur", "Ghaziabad",   "Buxar" ,   "Betwa",  "Unnao" , "Buxar", "Buxar"};
        int agencyId[] =    {101    ,   101  ,  101     ,   102             , 103       ,    103     ,   142      ,     142   ,    142   ,  214     ,    214 ,   214 };
        String agencyName[] = {"JSS", "JSS"  , "JSS"    , "MGM"             ,"JAYPEE"   ,"JAYPEE"    , "AKG"      , "AKG"     ,"AKG"     , "RKGIT"  , "RKGIT", "RKGIT"};
        int totalAssessments[] = {1 ,   1    ,  1       ,    2              ,  1        ,    1       ,    4      ,      4     ,     4     ,  5      ,    5   ,    5   };

        MultiMap multiMap = new MultiValueMap();
        int key = 0;
        int rKey = 0;
        int sKey = 0;
        int highest = 10;
        int key1 = 0;
        int largestKey = 0;

        int largestAssessment = 0;

        int counter = 0;
        try{

            while(!state[counter].equals(null)){
                int marks = 0;
                int counter2 = 0;

                //Check if state is same

                if(state[counter].equalsIgnoreCase(stateCmp))
                    marks += 10;

                //Check if district is same

                if(district[counter].equalsIgnoreCase(districtCmp))
                    marks += 50;

                //Check if the body has shown interest


                for (Integer integer : agencyIdShowInterest){
                    if(integer == agencyId[counter]){
//                        System.out.println("Someone has shown interest-------------------------------------------");
                        marks += 100;
                    }

                    else{
//                        System.out.println("No interest shown-------------------------------------------");
                    }

                }

                //Store marks and agencyName in a multi map
//                System.out.println("Storing in a multi map " + counter);

                //Check for duplicate values

                multiMap.put(key, agencyName[counter]);
                //Below are values just for samp[AKG, Bihar, Buxar, 142, 4, 120]le purpose, remove in production
//                multiMap.put(key, state[counter]);
//                multiMap.put(key, district[counter]);
//                multiMap.put(key, agencyId[counter]);
//                multiMap.put(key, totalAssessments[counter]);

                if(marks >= highest){
                    largestKey = key;
                    highest = marks;
                }
                //Allot marks
//                multiMap.put(key, marks);
                //Increment and move to next iteration
                counter++;
                key++;

            }
        }
        catch (Exception e){
            System.out.println("Exception caught.........................................");
        }

//        System.out.println("Retrieving the multi map");
        while(multiMap.get(rKey) != null){
            System.out.println(multiMap.get(rKey));
            rKey++;
        }

        System.out.println("The Agency with the highest score is " + multiMap.get(largestKey));


        // return the agency with the highest score
        Object largestAgency = multiMap.get(largestKey);
        String recommendedAB = String.valueOf(largestAgency);
        // Remove leading and trailing square brackets
        recommendedAB = recommendedAB.substring(1,recommendedAB.length()-1);
        return recommendedAB;
//        return "AKG";
    }
}
