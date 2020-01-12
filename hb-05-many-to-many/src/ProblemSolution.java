import java.io.*;
import java.util.*;

public class ProblemSolution {
    public int findSubArraySum(int[] array)
    {
        HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
        int index=0;
        int numberOfEle=array.length;
        int jIndex;
        int sum=0;
        
        for(;index<numberOfEle;index++)
        {
            int res=0;
            for(jIndex=index;jIndex<numberOfEle;jIndex++)
            {
                res+=array[jIndex];
                if (hm.containsKey(res))  
                { 
                    hm.put(res, hm.get(res) + 1); 
                }  
                else
                { 
                    hm.put(res, 1); 
                } 
            }
            
        }
        for (Map.Entry<Integer,Integer> x : hm.entrySet()) 
                if (x.getValue() == 1) 
                    sum += x.getKey(); 
  
        return sum;
    }
        
    
    public int solution(int[] A, int N) {
        
        int res=findSubArraySum(A);
        System.out.println(res);
        return res;
    }
}
