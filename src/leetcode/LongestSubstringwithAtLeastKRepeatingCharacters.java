package leetcode;

import java.util.Arrays;

/**
*
* @author Scott
*/
public class LongestSubstringwithAtLeastKRepeatingCharacters  {
    // Divide and conquer
    public int longestSubstring(String s, int k) {
        char[] str = s.toCharArray();
        return helper(str,0,s.length(),k);
    }
    private int helper(char[] str, int start, int end,  int k){
        if(end-start<k) return 0;//substring length shorter than k.
        int[] count = new int[26];
        for(int i = start;i<end;i++){
            count[str[i]-'a']++;
        }
        for(int i = 0;i<26;i++){
            if(count[i]<k&&count[i]>0){ //count[i]=0 => i+'a' does not exist in the string, skip it.
                for(int j = start;j<end;j++){
                    if(str[j]==i+'a'){  // find all those character do not meet k time
                        int left = helper(str,start,j,k);
                        int right = helper(str,j+1,end,k);
                        return Math.max(left,right);
                    }
                }
            }
        }
        return end-start;
    }
    
    //Two Pointer Sliding Window
    public int longestSubstring(String s, int k) {
        char[] str = s.toCharArray();
        int[] counts = new int[26];
        int h, i, j, idx, max = 0, unique, noLessThanK;
        // h=1 means there is only 1 char
        // h=2  aaabb   2 distinct char
        for (h = 1; h <= 26; h++) {
            Arrays.fill(counts, 0);
            i = 0; 
            j = 0;
            unique = 0;
            noLessThanK = 0;
            while (j < str.length) {
                if (unique <= h) {
                    idx = str[j] - 'a';
                    if (counts[idx] == 0)
                        unique++;
                    counts[idx]++;
                    if (counts[idx] == k)
                        noLessThanK++;
                    j++;
                }
                else {
                    idx = str[i] - 'a';
                    if (counts[idx] == k)
                        noLessThanK--;
                    counts[idx]--;
                    if (counts[idx] == 0)
                        unique--;
                    i++;
                }
                if (unique == h && unique == noLessThanK)
                    max = Math.max(j - i, max);
            }
        }
        
        return max;
    }
}
