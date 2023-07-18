package leetcode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Google_LeetCode_GuessTheWord {
        public void findSecretWord(String[] words, Master master) {
            Set<String> wordsGroup = new HashSet<>();

            for(String word : words) {
                wordsGroup.add(word);
            }

            int guessCount = 10;
            while(!wordsGroup.isEmpty() && guessCount > 0) {
                Iterator<String> iterator = wordsGroup.iterator();
                String guessWord = iterator.next();
                int numOfMatch = master.guess(guessWord);

                if(numOfMatch == 6) return ;

                iterator.remove();
                while(iterator.hasNext()) {
                    String nextWord = iterator.next();
                    if(hasPartialMatch(guessWord, nextWord, numOfMatch)) {
                        iterator.remove();
                    }
                }

                guessCount--;
            }
        }

        private boolean hasPartialMatch(String guessWord, String word, int numOfMatch) {
            int matchCount = 0;

            for(int idx = 0; idx < 6; idx++) {
                if(guessWord.charAt(idx) == word.charAt(idx)) {
                    matchCount++;
                }
            }

            return matchCount <= numOfMatch;
        }
}
