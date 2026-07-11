class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set= new HashSet<>(wordList);
        Queue<Pair<String,Integer>> q= new LinkedList<>();
        q.add(new Pair<>(beginWord,1));
        int stage=0;
        char[] alphabets = {'a','b','c','d','e','f','g','h','i','j', 'k','l','m','n','o','p','q','r','s','t', 'u','v','w','x','y','z'};
        set.remove(beginWord);
        while(!q.isEmpty()){
            Pair<String,Integer> p=q.poll();
            String word=p.getKey();
            stage=p.getValue();
            char[] ch = word.toCharArray();
            for(int i=0;i<ch.length;i++){
                char old=ch[i];
                for(char alpha:alphabets){
                    ch[i]=alpha;
                    String str=new String(ch);
                    if(set.contains(str)){
                        if(str.equals(endWord))return stage+1;
                        q.add( new Pair<>(str,stage+1));
                        set.remove(str);
                    }
                }
                ch[i]=old;
            }
        }
        return 0;
    }
}