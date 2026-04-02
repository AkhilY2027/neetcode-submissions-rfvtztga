class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;
        int numGroups = hand.length / groupSize;

        // int[] startPointers = new int[numGroups];
        // startPointers[0] = hand[0];
        // Arrays.sort(hand);

        // int curPointer = 0;
        // int curGroupsFound = 1;
        // int sameOnLevel = 1;
        // while (curPointer < hand.length - 1) {
        //     // Go through each card one by one
        //     int card = hand[curPointer];
        //     int nextCard = hand[curPointer + 1];

        //     // Check the next card - if consecutive, move, if not check how many groups we have left
        //     if (nextCard == card + 1) {
        //         // Next card is consecutive
        //         sameOnLevel = 1;

        //         // Check all cards if we can jump?
        //         for (int i = 0; i < startPointers.length; i++) {
        //             if (nextCard - startPointers[i] > groupSize) return false;
        //         }
        //     }
        //     else if (nextCard == card) {
        //         // Next card is the same
        //         if (sameOnLevel < curGroupsFound) {
        //             sameOnLevel++;

        //             // Check all startPointers
        //             for (int i = 0; i < startPointers.length; i++) {
        //                 if (card - startPointers[i] > groupSize) return false;
        //             }
        //         }
        //         else {
        //             // If there's space in curGroupsFound, make space there
        //             if (curGroupsFound < numGroups) {
        //                 startPointers[curGroupsFound] = nextCard;
        //                 curGroupsFound++;
        //                 sameOnLevel++;
        //             }
        //             else {
        //                 return false; // No groups should be formed - Non-consecutive
        //             }
        //         }
        //     }
        //     else {
        //         // Next card is guarenteed to be non-consecutive - Must check all current startPointers and see if they stop
        //         for (int i = 0; i < startPointers.length; i++) {
        //             if (card - startPointers[i] != groupSize) return false;
        //         }
        //         startPointers[0] = nextCard;
        //         curGroupsFound = 1;
        //         sameOnLevel = 1;
        //     }
        //     curPointer++;
        // }
        // return true;

        HashMap<Integer, Integer> cardCount = new HashMap<>();
        for (int card: hand) {
            cardCount.put(card, cardCount.getOrDefault(card, 0) + 1);
        }

        // Arrays.sort(hand); //Don't even need to sort - Just find the corresponding consecutive card
        for (int card : hand) {
            // Basically, each card should have a corresponding hand
            int actualCard = card;
            while (cardCount.getOrDefault(actualCard, 0) > 0) {
                actualCard--;
            }
            // Treat this actualCard as if its the only time we'll get it - That's why we while loop
            while (actualCard <= card) {
                while (cardCount.getOrDefault(actualCard, 0) != 0) {
                    // Then, we're going to remove those cards from the count - that's why this check is here
                    for (int i = actualCard; i < actualCard + groupSize; i++) {
                        if (cardCount.getOrDefault(i, 0) == 0) return false;
                        cardCount.put(i, cardCount.getOrDefault(i, 0) - 1);
                    }
                }
                actualCard++;
            }
        }
        return true;
    }
}
