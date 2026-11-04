import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ChanceTest {
    Game g;
    Player p;
    Field chanceField;

    @BeforeEach
    void setUp() {
        // Create assets and initialize fields.
        g = new Game("testGame", 2);
        g.createAssets();
        g.createPlayer("testPlayer", 100);
        Board b = g.getBoard();
        p = g.getPlayers().getFirst();
        chanceField = b.getField(3);
    }

    @Test
    void onLandShouldNotReturnNull() {
        assertNotNull(chanceField.onLand(p));
    }

    @Test
    void onLandReturnShouldContainSuperClassMessage() {
        String msg = chanceField.onLand(p);
        assertTrue(msg.startsWith("testPlayer er landet på " + chanceField + "\n"));
    }

    @Test
    void onLandReturnShouldContainCardMessage() {
        String msg = Chance.cardDeck.getNext().getMessage();
        Chance.cardDeck.resetCounter();
        assertTrue(chanceField.onLand(p).endsWith(msg));
    }
}
