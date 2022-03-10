package blackjack.domain.player;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import blackjack.domain.Result;
import blackjack.domain.card.Card;
import blackjack.domain.card.Denomination;
import blackjack.domain.card.Suit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GamersTest {

    @Test
    @DisplayName("중복된 게이머 이름으로 에러가 발생한다.")
    void duplicateGamerNameException() {
        assertThatThrownBy(() -> new Gamers(List.of(new Gamer("huni"), new Gamer("huni"))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 중복된 이름은 입력할 수 없습니다.");
    }

    @Test
    @DisplayName("딜러와 결과를 비교한다")
    void compareResultWithDealer() {
        Gamer gamer = new Gamer("huni");
        gamer.receiveCard(new Card(Suit.DIAMOND, Denomination.JACK));
        Gamers gamers = new Gamers(List.of(gamer));

        Map<Player, Result> expected = new HashMap<>();
        expected.put(gamer, Result.LOSE);

        assertThat(gamers.compareResult(11)).isEqualTo(expected);


    }
}
