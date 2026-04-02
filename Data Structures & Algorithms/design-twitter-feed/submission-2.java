class Twitter {

    HashMap<Integer, HashSet<Integer>> following;
    HashMap<Integer, ArrayList<int[]>> tweets;
    int time;

    public Twitter() {
        following = new HashMap<>();
        tweets = new HashMap<>();
        time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        // tweets.putIfAbsent(userId, new ArrayList<>());
        // tweets.get(userId).add(new Pair<>(time++, tweetId));
        tweets.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[] {time, tweetId});
        if (tweets.get(userId).size() > 10) tweets.get(userId).remove(0);
        time--;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        // Go through user + All their followers tweets and place into PQ
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            // Comparator
            // Comparator.comparingInt((Pair<Integer, Integer> a) -> -1 * a.getKey())
            (a, b) -> Integer.compare(a[0], b[0])
        );
        List<Integer> ret = new ArrayList<>();

        following.computeIfAbsent(userId, k -> new HashSet<>()).add(userId); // To easily collect info on self

        // Algo: Instead of adding all at once, we just add the "frontiers"/last indices of each followee
            // Then, when we're adding them to res, we pop the value we want and go to the next index within that followee tweetList
            // Essentially, we aren't storing all tweets from all followees but just the tweets we need + only getting them when necessary
        
        if (following.get(userId).size() < 10) {
            for (int followeeId : following.get(userId)) {
                if (!tweets.containsKey(followeeId)) continue;

                List<int[]> tweetList = tweets.get(followeeId);
                int[] lastTweet = tweetList.get(tweetList.size() - 1); // Always want the end since that is the most recent
                minHeap.add(new int[] {lastTweet[0], lastTweet[1], followeeId, tweetList.size() - 2});
            }
        }
        else {
            PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(a[0], b[0])
            );

            for (int followeeId : following.get(userId)) {
                if (!tweets.containsKey(followeeId)) continue;

                List<int[]> tweetList = tweets.get(followeeId);
                int[] lastTweet = tweetList.get(tweetList.size() - 1);
                maxHeap.add(new int[] {-1 * lastTweet[0], lastTweet[1], followeeId, tweetList.size() - 2});

                if (maxHeap.size() > 10)
                    maxHeap.poll();
            }

            while (!maxHeap.isEmpty()) {
                int[] top = maxHeap.poll();
                minHeap.offer(new int[] {-1 * top[0], top[1], top[2], top[3]});
            }
        }

        while (!minHeap.isEmpty() && ret.size() < 10) {
            int[] top = minHeap.poll();
            ret.add(top[1]);
            int nextIndex = top[3];
            if (nextIndex >= 0) {
                List<int[]> tweetList = tweets.get(top[2]);
                int[] nextTweet = tweetList.get(nextIndex);
                minHeap.offer(new int[]{nextTweet[0], nextTweet[1], top[2], nextIndex - 1});
            }
        }

        return ret;



        // // 1. Get all user tweets
        // if (tweets.containsKey(userId))
        //     sol.addAll(tweets.get(userId));

        // // 2. Get all followees
        // if (following.containsKey(userId)) {
        //     for (int followee : following.get(userId)) {
        //         if (tweets.containsKey(followee))
        //             sol.addAll(tweets.get(followee));
        //     }
        // }

        // // 3. Return top 10
        // List<Integer> ret = new ArrayList<Integer>();
        // while(ret.size() < 10 && !sol.isEmpty()) {
        //     ret.add(sol.poll().getValue());
        // }
        // return ret;
    }
    
    public void follow(int followerId, int followeeId) {
        // following.putIfAbsent(followerId, new HashSet<>());
        // following.get(followerId).add(followeeId);
        following.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        // following.putIfAbsent(followerId, new HashSet<>());
        // following.get(followerId).remove(followeeId);
        if (following.containsKey(followerId))
            following.get(followerId).remove(followeeId);
    }
}
