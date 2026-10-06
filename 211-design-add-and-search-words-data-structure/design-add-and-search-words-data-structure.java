class TrieNode {
    Map<Character, TrieNode> children;
    boolean isWord;
    
    public TrieNode() {
        children = new HashMap<>();
        isWord = false;
    }
}

class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        // Traverse the trie for each character in the word
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            // If the current node does not have a child with character c,
            // create a new node and add it as a child of the current node
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode());
            }
            // Move to the child node corresponding to character c
            node = node.children.get(c);
        }
        // Mark the last node as a word node
        node.isWord = true;
    }

    public boolean search(String word) {
        return searchHelper(root, word, 0);
    }

    private boolean searchHelper(TrieNode node, String word, int index) {
        // If we have reached the end of the word,
        // check if the current node is a word node
        if (index == word.length()) {
            return node.isWord;
        }
        char c = word.charAt(index);
        if (c == '.') {
            for (TrieNode child : node.children.values()) {
                if (searchHelper(child, word, index + 1)) {
                    return true;
                }
            }
            return false;
        } else {
            TrieNode child = node.children.get(c);
            if (child == null) {
                return false;
            }
            return searchHelper(child, word, index + 1);
        }
    }
}