class PrefixTree {
    class TrieNode{
        boolean isEnd;
        TrieNode [] children;
        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }
    private TrieNode root;

    public PrefixTree() {
        this.root = new TrieNode();
         
    }

    public void insert(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(cur.children[ch -'a'] == null){
                cur.children[ch -'a'] = new TrieNode(); 
            }
            cur = cur.children[ch -'a'];
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(cur.children[ch -'a'] == null) return false;
            cur = cur.children[ch -'a'];
        }
        return cur.isEnd;

    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(int i = 0; i < prefix.length(); i++){
            char ch = prefix.charAt(i);
            if(cur.children[ch -'a'] == null) return false;
            cur = cur.children[ch -'a'];
        }
        return true;
    }
}
