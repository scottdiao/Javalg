package leetcode;
/**
*
* @author Scott
*/
public class ReverseString  {
    public String reverseString(String s) {
       char[] word = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char temp = word[i];
            word[i] = word[j];
            word[j] = temp;
            i++;
            j--;
        }
        return new String(word);
    }
}
