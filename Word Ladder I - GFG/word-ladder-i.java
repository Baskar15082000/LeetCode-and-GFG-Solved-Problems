//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            int ans = obj.wordLadderLength(startWord, targetWord, wordList);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends






class Solution {
    class pair{
        String word;
        int stp;
        pair(String word,int stp){
            this.word=word;
            this.stp=stp;
        }
    }
    public int wordLadderLength(String beginWord, String endWord, String[] wordList) {
        HashSet<String> st=new HashSet<>();
        for(int i=0;i<wordList.length;i++){
            st.add(wordList[i]);
        }
        st.remove(beginWord);
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(beginWord,1));
        while(q.size()>0){
            pair p=q.remove();
            if(p.word.equals(endWord))return p.stp;
            for(int i=0;i<p.word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char rch[]=(p.word).toCharArray();
                    rch[i]=ch;
                     String str=new String(rch);
                if(st.contains(str)){
                    st.remove(str);
                    q.add(new pair(str,p.stp+1));
                }
                }
               
            }
        }
        return 0;
    }
}

