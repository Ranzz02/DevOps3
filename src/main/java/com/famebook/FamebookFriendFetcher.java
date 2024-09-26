package com.famebook;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FamebookFriendFetcher {
    private final Map<String, List<String>> friendData;

    public FamebookFriendFetcher() {
        friendData = new HashMap<>();

        friendData.put("http://famebook.com/rasmus", List.of("Alice", "Bob", "Charlie"));
        friendData.put("http://famebook.com/alice", List.of("Bob", "Charlie"));
        friendData.put("http://famebook.com/bob", List.of("Rasmus", "Alice"));
        friendData.put("http://famebook.com/charlie", List.of("Alice", "Bob", "Rasmus"));
    }

    public String[] getFriends(String profileLink) {
        if (profileLink == null || !profileLink.contains("famebook.com")) {
            throw new IllegalArgumentException("Invalid famebook profile link");
        }

        // Return an empty array if the profile is not found
        return friendData.getOrDefault(profileLink, List.of()).toArray(new String[0]);
    }
}
