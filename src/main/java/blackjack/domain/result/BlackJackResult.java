package blackjack.domain.result;

import blackjack.domain.player.Gamer;
import java.util.Map;

public class BlackJackResult {

    private static final int DEALER_CALCULATE_UNIT = -1;

    private final Map<Gamer, Integer> result;

    public BlackJackResult(final Map<Gamer, Integer> result) {
        this.result = result;
    }

    public int calculateDealerReturn() {
        return result.values()
                .stream()
                .mapToInt(value -> value)
                .sum() * DEALER_CALCULATE_UNIT;
    }

    public Map<Gamer, Integer> getResult() {
        return result;
    }
}
