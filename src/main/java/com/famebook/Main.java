package com.famebook;

import java.util.Scanner;

public class Main {
    static private final Scanner scanner = new Scanner(System.in);
    static private final FamebookFriendFetcher fetcher = new FamebookFriendFetcher();

    public static void main(String[] args) {
        do {
            System.out.println("Choose your action: \n1. Get friends\n2. Exit program");
            System.out.print("Option: ");
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    System.out.println("Please provide a valid famebook link: 'http://famebook.com/{user}'");
                    System.out.print("Link: ");
                    String link = scanner.nextLine();
                    try {
                        String[] friends = fetcher.getFriends(link);
                        if (friends.length == 0) {
                            System.out.println("\nProfile doesn't exist.\n");
                        } else {
                            System.out.println("\nFound friends:");
                            int index = 0;
                            for (String friend : friends) {
                                System.out.printf("%d: %s%n", index+1, friend);
                                index++;
                            }
                            System.out.println("End of list:\n");
                        }
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case "2":
                    System.out.println("Exiting program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
        while (true);
    }
}
