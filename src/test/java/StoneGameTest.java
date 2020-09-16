import com.miueon.leetcode.editor.en.StoneGame;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoneGameTest {
    @Test
    void testStoneGam() {
        int[] piles = new int[]{1, 2, 3, 4, 5, 6};
        StoneGame stoneGame = new StoneGame();

        assertEquals(true, stoneGame.proxy(piles));
    }
}
