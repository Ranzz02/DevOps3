package com.famebook;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class FamebookFriendFetcherTest {

    private final FamebookFriendFetcher fetcher = new FamebookFriendFetcher();


    // Positive test cases
    // Test to fetch user: Rasmus
    @Test
    void testValidProfileLinkRasmus() {
        String[] friends = fetcher.getFriends("http://famebook.com/rasmus");
        assertArrayEquals(new String[]{"Alice", "Bob", "Charlie"}, friends);
    }

    // Test to fetch user: Alice
    @Test
    void testValidProfileLinkAlice() {
        String[] friends = fetcher.getFriends("http://famebook.com/alice");
        assertArrayEquals(new String[]{"Bob", "Charlie"}, friends);
    }

    // Test to fetch user: Bob
    @Test
    void testValidProfileLinkBob() {
        String[] friends = fetcher.getFriends("http://famebook.com/bob");
        assertArrayEquals(new String[]{"Rasmus", "Alice"}, friends);
    }

    // Negative test cases
    // Test to fetch invalid link 
    @Test
    void testInvalidProfileLink() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            fetcher.getFriends("invalid_link");
        });
        assertEquals("Invalid famebook profile link", exception.getMessage());
    }

    // Test to fetch null link 
    @Test
    void testNullProfileLink() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            fetcher.getFriends(null);
        });
        assertEquals("Invalid famebook profile link", exception.getMessage());
    }

    // Test to fetch non-existing user 
    @Test
    void testNonExistentProfileLink() {
        String[] friends = fetcher.getFriends("http://famebook.com/nonexistentuser");
        assertArrayEquals(new String[0], friends);
    }

    // Performance test proposal
    @Test
    void testPerformance() {
        long startTime = System.currentTimeMillis();
        fetcher.getFriends("http://famebook.com/rasmus");
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        
        assertTrue(duration < 100, "Performance test failed: took too long!");
    }
}
