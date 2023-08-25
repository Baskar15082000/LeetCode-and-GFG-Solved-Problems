class Solution {
    class pair{
        String word;
        int stp;
        pair(String word,int stp){
            this.word=word;
            this.stp=stp;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> st=new HashSet<>();
        for(int i=0;i<wordList.size();i++){
            st.add(wordList.get(i));
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