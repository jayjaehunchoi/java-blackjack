package blackjack.domain.result;

import static org.assertj.core.api.Assertions.assertThat;

import blackjack.domain.player.Bet;
import blackjack.domain.player.Gamer;
import blackjack.domain.player.Gamers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BlackJackResultTest {

    @Test
    @DisplayName("최초의 블랙잭 결과판을 만들 수 있다.")
    void createInitialBlackJackResult() {
        Gamer huni = new Gamer("huni", new Bet(1000));
        Gamer hani = new Gamer("hani", new Bet(1000));

        Gamers gamers = new Gamers(List.of(huni, hani));

        Map<Gamer, Integer> map = gamers.getGamers().stream()
                .collect(Collectors.toMap(gamer -> gamer,
                        gamer -> 1000));

        BlackJackResult result = new BlackJackResult(map);
        assertThat(result.getResult().keySet()).contains(new Gamer("huni", new Bet(1000)),
                new Gamer("hani", new Bet(1000)));
    }

    @Test
    @DisplayName("딜러의 이익 총합을 계산한다.")
    void calculateReturnOfDealer() {
        Gamer huni = new Gamer("huni", new Bet(1000));

        Map<Gamer, Integer> map = new HashMap<>();
        map.put(huni, 1000);

        BlackJackResult result = new BlackJackResult(map);
        assertThat(result.calculateDealerReturn()).isEqualTo(-1000);
    }
}
