package twitter;

import java.util.*;

class Twitter {
    private Map<Integer, User> users;
    private LinkedList<News> newsList;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        users = new HashMap<>();
        newsList = new LinkedList<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        User user = new User(userId);
        if (users.containsKey(userId)) {
            user = users.get(userId);
        } else {
            users.put(userId, user);
        }
        News news = new News(userId, tweetId);
        newsList.addFirst(news);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> list = new ArrayList<>();
        if (users.containsKey(userId)) {
            User user = users.get(userId);
            PriorityQueue<Integer> followees = user.getFollowees();
            for (int i = 0; i < newsList.size(); i++) {
                if (list.size() == 10) {
                    return list;
                }
                int newsUserId = newsList.get(i).getUserId();
                if (newsUserId == userId || followees.contains(newsUserId)) {
                    list.add(newsList.get(i).getNewsId());
                }
            }
        }
        return list;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        User follower = null;
        if (!users.containsKey(followeeId)) {
            User followee = new User(followeeId);
            users.put(followeeId, followee);
        }
        if (!users.containsKey(followerId)) {
            follower = new User(followerId);
            users.put(followerId, follower);
        } else {
            follower = users.get(followerId);
        }
        follower.addFollowee(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        User follower = null;
        if (!users.containsKey(followeeId)) {
            User followee = new User(followeeId);
            users.put(followeeId, followee);
        }
        if (!users.containsKey(followerId)) {
            follower = new User(followerId);
            users.put(followerId, follower);
        } else {
            follower = users.get(followerId);
        }
        follower.delFollowee(followeeId);
    }

}