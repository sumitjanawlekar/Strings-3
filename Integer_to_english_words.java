// Time Complexity :O(1), Atmost for a 2^32 (has max 10 digits) number we would need 9 Steps 
// Space Complexity :O(1), Space used for thousands, under_20 and tens is constant
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


//Three Liner explanation of your code in plain English
//1. Create 3 arrays housands, under_20 and tens (Pre data)
//2. Proccess the numbers in a triplet (num/1000), Adding suffixes to a triplet group depending on the index of thousands array
//3. Process triplets for 3 cases (for num 1-->19 , for num 20-->99 and for num 100-->999)

// Your code here along with comments explaining your approach

class Solution {
    //Pre-required data
    String[] thousands;
    String[] under_20;
    String[] tens;
    public String numberToWords(int num) {
        //edge cae
        if(num == 0) return "Zero";
        
        //Intilialise the pre required data
        thousands = new String[]{"", "Thousand", "Million", "Billion"};
        under_20 = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        tens = new String[]{"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        
        //to keep track of the positions of the triplets
        int i=0;
        String result ="";
        while(num != 0){
            //don't process triplets of all 0's
            if(num%1000 != 0){
                result = helper(num%1000) + thousands[i]+ " " + result;
            }
            //process the numbers in triplet
            num = num/1000;
            //move to the next triplet position in the thousansds array to get the correct suffix
            i++;
        }
        //trim the unnecessary spaces
        return result.trim();
    }
    
    private String helper(int num){
        if(num == 0) return "";
        if(num < 20){ //numbers from 1-->19 have exculsive names
            return under_20[num%100] + " ";
        }else if(num < 100){ //numbers from 20--> 99
            return tens[num/10] + " " + helper(num%10);
        }else{ //nums from 100--> 999
            return under_20[num/100] + " " + "Hundred" + " " + helper(num%100);
        }
    }
}