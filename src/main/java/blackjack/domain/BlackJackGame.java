package blackjack.domain;

import blackjack.domain.card.Card;
import blackjack.domain.card.Deck;
import blackjack.domain.player.Gamer;
import blackjack.domain.player.Gamers;
import blackjack.domain.player.Player;
import blackjack.domain.result.BlackJackResult;
import java.util.List;

public class BlackJackGame {

    private final Player dealer;
    private final Gamers gamers;

    public BlackJackGame(final Player dealer, final Gamers gamers) {
        this.dealer = dealer;
        this.gamers = gamers;
    }

    public void handOutStartingCards(final Deck deck) {
        dealStartingCards(dealer, deck);
        for (Gamer gamer : gamers.getGamers()) {
            dealStartingCards(gamer, deck);
        }
    }

    private void dealStartingCards(final Player player, final Deck deck) {
        for (int i = 0; i < Card.START_CARD_COUNT; i++) {
            player.receiveCard(deck.draw());
        }
    }

    public BlackJackResult calculateBlackJackResult() {
        return new BlackJackResult(gamers.compareResult(dealer.calculateResult()));
    }

    public Player getDealer() {
        return dealer;
    }

    public List<Gamer> getGamers() {
        return gamers.getGamers();
    }
}
