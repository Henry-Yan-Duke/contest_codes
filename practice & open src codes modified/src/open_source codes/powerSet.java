package interviewQ;

import java.util.Arrays;

public class powerSet {

	
	
	
	static void combine(char[] arr, int k, int startId, char[] branch, int numElem)
	{
	    if (numElem == k)
	    {
	        System.out.println(Arrays.toString(branch));
	        return;
	    }
	    
	    for (int i = startId; i < arr.length; ++i)
	    {
	        branch[numElem++] = arr[i];
	        combine(arr, k, ++startId, branch, numElem);
	        --numElem;
	    }
	}
	
	static void generatePermutations(char[] arr, int size, char[] branch, int level, boolean[] visited)
	{
	    if (level >= size-1)
	    {
	        System.out.println(branch);
	        return;
	    }
	    
	    for (int i = 0; i < size; i++)
	    {
	        if (!visited[i])
	        {
	            branch[++level] = arr[i];
	            visited[i] = true;
	            generatePermutations(arr, size, branch, level, visited);
	            visited[i] = false;
	            level--;
	        }
	    }
	}
	
	static void powerSet(char[] arr)
	{
	    for (int i = 0; i < arr.length; ++i)
	    {
	        char[] branch = new char[i];
	        combine(arr, i, 0, branch, 0);
	    }    
	}
	static void main(String[] args){
		
		String str = "ABCD";
		int n = str.length();
		char[] arr = str.toCharArray();
		boolean[] visited = new boolean[n];
		for (int i = 0; i < n; i++)
		    visited[i] = false;
		char[] branch = new char[n];
		generatePermutations(arr, n, branch, -1, visited);
	}
}
