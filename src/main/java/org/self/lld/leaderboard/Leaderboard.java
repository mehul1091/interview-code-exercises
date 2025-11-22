package org.self.lld.leaderboard;

import java.util.*;

public class Leaderboard {

    Map<Integer, Integer> playerScoreMap;

    public Leaderboard(){
        playerScoreMap = new HashMap<>();
    }

    //addScore(playerId, score):
    // Update the leaderboard by adding score to the given player's score.
    //
    // If there is no player with such id in the leaderboard,
    // add him to the leaderboard with the given score.
    public void addScore(int playerId, int score){

        if(playerScoreMap.containsKey(playerId)){
            playerScoreMap.put(playerId, playerScoreMap.get(playerId) + score);
        }
        else
            playerScoreMap.put(playerId, score);
    }

    //top(K): Return the score sum of the top K players.
    public int top(int K){

        // sort all scores in the collection
        List<Integer> allScoresOnly = new ArrayList<>(playerScoreMap.values());
        Collections.sort(allScoresOnly, Collections.reverseOrder());
        //O(NlogN) - TC

        //O(K)
        int result = 0;
        //then fetch top K values
        for(int i=0; i<K; i++){
            result = result + allScoresOnly.get(i);
        }

        return result;
    }


    //reset(playerId): Reset the score of the player with the given id to 0 (in other words erase it from the leaderboard).
    // It is guaranteed that the player was added to the leaderboard before calling this function.
    public void reset(int playerId){
        playerScoreMap.put(playerId, 0);
    }
}
