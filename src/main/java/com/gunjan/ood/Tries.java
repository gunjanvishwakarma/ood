package com.gunjan.ood;

import java.util.ArrayList;

public class Tries {

    static TrieNode root;
    static final int ALPHABET_SIZE = 26;
    public ArrayList<String> prefix(ArrayList<String> A) {
        root = new TrieNode();
        for (int i = 0; i < A.size() ; i++)
            insert(A.get(i));

        ArrayList<String> prefixs = new ArrayList<String>();

        for (int i = 0; i < A.size() ; i++){
            String prefix = search(A.get(i));
            prefixs.add(prefix);
        }
        return  prefixs;
    }

    // Returns true if key presents in trie, else false
    static String search(String key)
    {
        String prefix = "";
        int mark = 0;
        int length = key.length();
        TrieNode pCrawl = root;
        int index;
        for (int level = 0; level < length; level++)
        {
            index = key.charAt(level) - 'a';

            if (pCrawl.children[index] == null)
                return "";

            if(pCrawl.childNo > 1)  mark = level + 1;

            pCrawl = pCrawl.children[index];

            prefix = prefix + key.charAt(level);
        }

        return prefix.substring(0,mark);
    }

    // trie node
    static class TrieNode
    {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];

        // isEndOfWord is true if the node represents
        // end of a word
        boolean isEndOfWord;

        int childNo = 0;

        TrieNode(){
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null;
        }
    };



    // If not present, inserts key into trie
    // If the key is prefix of trie node,
    // just marks leaf node
    static void insert(String key)
    {
        int level;
        int length = key.length();
        int index;

        TrieNode pCrawl = root;

        for (level = 0; level < length; level++)
        {
            index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null)
                pCrawl.children[index] = new TrieNode();
            pCrawl.childNo++;

            pCrawl = pCrawl.children[index];
        }

        // mark last node as leaf
        pCrawl.isEndOfWord = true;
    }
}
