class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Basically, wordList holds the stages of transformation
            // Algo: Make it a graph - have what words the word can connect to at each stage
        if (!wordList.contains(endWord) || beginWord.equals(endWord)) return 0;

        // First, have an list of lists that show the connections each word has
        ArrayList<ArrayList<String>> connections = new ArrayList<>();
        for (int i = 0; i < wordList.size(); i++) {
            connections.add(new ArrayList<>());
        }

        // Also, a map of words to their indexes for easier lookup
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++) {
            map.put(wordList.get(i), i);
        }

        // For each word in the list, find the possible combinations and add them to the parents/children
        for (int i = 0; i < wordList.size(); i++) {
            for (int j = i + 1; j < wordList.size(); j++) {
                int count = 0;
                String word1 = wordList.get(i);
                String word2 = wordList.get(j);
                // Go through the words and check if its only one off
                for (int k = 0; k < wordList.get(0).length(); k++) {
                    if (word1.charAt(k) != word2.charAt(k)) count++;
                }
                if (count == 1) {
                    connections.get(i).add(word2);
                    connections.get(j).add(word1);
                }
            }
        }

        // BFS
        Queue<String> q = new LinkedList<>();
        int sol = 1;
        HashSet<String> visited = new HashSet<>();

        // Add all possible connections from the beginWord to the queue
        for (int i = 0; i < wordList.get(0).length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == beginWord.charAt(i)) continue;

                String potentialWord = beginWord.substring(0, i) + c + beginWord.substring(i + 1);
                if (wordList.contains(potentialWord) && !visited.contains(potentialWord)) {
                    // Add it to the queue
                    q.add(potentialWord);
                    visited.add(potentialWord);
                }
            }
        }

        // Now, BFS start
        while (!q.isEmpty()) {
            sol++; //New step
            int curSize = q.size();

            // On each step, add every possible connection within the current level
            for (int i = 0; i < curSize; i++) {
                String word = q.poll();
                if (word.equals(endWord)) return sol;
                for (String nei : connections.get(map.get(word))) {
                    if (!visited.contains(nei)) {
                        visited.add(word);
                        q.add(nei);
                    }
                }
            }
        }

        return 0;
    }
}
