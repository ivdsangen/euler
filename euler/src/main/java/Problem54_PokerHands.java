import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Problem54_PokerHands {

    enum ScoreType {
        HIGH_CARD,
        ONE_PAIR,
        TWO_PAIRS,
        THREE_OF_A_KIND,
        STRAIGHT,
        FLUSH,
        FULL_HOUSE,
        FOUR_OF_A_KIND,
        STRAIGHT_FLUSH,
        ROYAL_FLUSH
    }

    enum CardType {
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        JACK,
        QUEEN,
        KING,
        ACE;
    }

    enum CardColor {
        HEARTS,
        CLUBS,
        SPADES,
        DIAMONDS
    }

    private static class Card {

        private CardType cardType;
        private CardColor cardColor;

        public Card(CardType cardType, CardColor cardColor) {
            this.cardType = cardType;
            this.cardColor = cardColor;
        }

        public CardType getCardType() {
            return cardType;
        }

        public CardColor getCardColor() {
            return cardColor;
        }
    }

    private static class Score {

        private CardType highCard5;

        private CardType highCard4;

        private CardType highCard3;
        private CardType highCard2;
        private CardType highCard1;

        private ScoreType scoreType;

        public Score() {

        }

        public void setScoreType(ScoreType scoreType) {
            this.scoreType = scoreType;
        }

        public ScoreType getScoreType() {
            return scoreType;
        }

        public void setHighCard1(CardType highCard1) {
            this.highCard1 = highCard1;
        }

        public CardType getHighCard1() {
            return highCard1;
        }

        public CardType getHighCard2() {
            return highCard2;
        }

        public void setHighCard2(CardType highCard2) {
            this.highCard2 = highCard2;
        }

        public CardType getHighCard3() {
            return highCard3;
        }

        public void setHighCard3(CardType highCard3) {
            this.highCard3 = highCard3;
        }

        public CardType getHighCard4() {
            return highCard4;
        }

        public void setHighCard4(CardType highCard4) {
            this.highCard4 = highCard4;
        }

        public CardType getHighCard5() {
            return highCard5;
        }

        public void setHighCard5(CardType highCard5) {
            this.highCard5 = highCard5;
        }
    }

    private static Score score(List<Card> hand) {
        Score score = new Score();
        if (royalFlush(hand)) {
            score.setScoreType(ScoreType.ROYAL_FLUSH);
            return score;
        } else if (straightFlush(hand)) {
            score.setScoreType(ScoreType.STRAIGHT_FLUSH);
            CardType highCardType = null;
            for (Card card : hand) {
                if (highCardType == null || card.getCardType().compareTo(highCardType) > 0) {
                    highCardType = card.getCardType();
                }
            }
            score.setHighCard1(highCardType);
            return score;
        } else if (fourOfAKind(hand)) {
            score.setScoreType(ScoreType.FOUR_OF_A_KIND);
            CardColor cardColor = hand.get(0).getCardColor();
            CardType cardType = hand.get(0).getCardType();
            CardType highCardType = null;
            int count = 1;
            for (int i = 1; i < hand.size(); i++) {
                if (cardColor == hand.get(i).getCardColor()) {
                    count++;
                    if (cardColor == hand.get(i).getCardColor() && hand.get(i).getCardType().compareTo(cardType) > 1) {
                        highCardType = hand.get(i).getCardType();
                    }
                }
            }
            if (count != 4) {
                highCardType = null;
                cardColor = hand.get(hand.size() - 1).getCardColor();
                cardType = hand.get(hand.size() - 1).getCardType();
                count = 1;
                for (int i = 1; i < hand.size(); i++) {
                    if (cardColor == hand.get(i).getCardColor()) {
                        count++;
                        if (cardColor == hand.get(i).getCardColor() && hand.get(i).getCardType().compareTo(cardType) > 1) {
                            highCardType = hand.get(i).getCardType();
                        }
                    }
                }
            }
            score.setHighCard1(highCardType);
            for (Card card : hand) {
                if (card.getCardColor() != cardColor) {
                    score.setHighCard2(card.getCardType());
                    break;
                }
            }
            return score;
        } else if (fullHouse(hand)) {
            score.setScoreType(ScoreType.FULL_HOUSE);
            hand.sort(Comparator.comparing(Card::getCardType));
            if (hand.get(0).getCardType() == hand.get(2).getCardType()) {
                score.setHighCard1(hand.get(0).getCardType());
                score.setHighCard2(hand.get(3).getCardType());
            } else {
                score.setHighCard1(hand.get(2).getCardType());
                score.setHighCard2(hand.get(0).getCardType());
            }
            return score;
        } else if (flush(hand)) {
            score.setScoreType(ScoreType.FLUSH);
            hand.sort(Comparator.comparing(Card::getCardType));
            for (int i = hand.size() - 1; i >= 0; i--) {
                if (i == 4) {
                    score.setHighCard1(hand.get(i).getCardType());
                } else if (i == 3) {
                    score.setHighCard2(hand.get(i).getCardType());
                } else if (i == 2) {
                    score.setHighCard3(hand.get(i).getCardType());
                } else if (i == 1) {
                    score.setHighCard4(hand.get(i).getCardType());
                } else if (i == 0) {
                    score.setHighCard5(hand.get(i).getCardType());
                }
            }
            return score;
        } else if (straight(hand)) {
            score.setScoreType(ScoreType.STRAIGHT);
            hand.sort(Comparator.comparing(Card::getCardType));
            for (int i = hand.size() - 1; i >= 0; i--) {
                if (i == 4) {
                    score.setHighCard1(hand.get(i).getCardType());
                } else if (i == 3) {
                    score.setHighCard2(hand.get(i).getCardType());
                } else if (i == 2) {
                    score.setHighCard3(hand.get(i).getCardType());
                } else if (i == 1) {
                    score.setHighCard4(hand.get(i).getCardType());
                } else if (i == 0) {
                    score.setHighCard5(hand.get(i).getCardType());
                }
            }
            return score;
        } else if (threeOfAKind(hand)) {
            score.setScoreType(ScoreType.THREE_OF_A_KIND);
            hand.sort(Comparator.comparing(Card::getCardType));
            if (hand.get(0).getCardType() == hand.get(2).getCardType()) {
                score.setHighCard1(hand.get(0).getCardType());
                score.setHighCard2(hand.get(3).getCardType());
            } else {
                score.setHighCard1(hand.get(3). getCardType());
                score.setHighCard2(hand.get(0).getCardType());
            }
            return score;
        } else if (twoPair(hand)) {
            score.setScoreType(ScoreType.TWO_PAIRS);
            hand.sort(Comparator.comparing(Card::getCardType));
            if (hand.get(0).getCardType() == hand.get(1).getCardType() && hand.get(2).getCardType() == hand.get(3).getCardType()) {
                if (hand.get(0).getCardType().compareTo(hand.get(2).getCardType()) > 0) {
                    score.setHighCard1(hand.get(0).getCardType());
                    score.setHighCard2(hand.get(2).getCardType());
                    score.setHighCard3(hand.get(4).getCardType());
                } else {
                    score.setHighCard1(hand.get(2).getCardType());
                    score.setHighCard2(hand.get(0).getCardType());
                    score.setHighCard3(hand.get(4).getCardType());
                }
            } else if (hand.get(0).getCardType() == hand.get(1).getCardType() && hand.get(3).getCardType() == hand.get(4).getCardType()) {
                if (hand.get(0).getCardType().compareTo(hand.get(3).getCardType()) > 0) {
                    score.setHighCard1(hand.get(0).getCardType());
                    score.setHighCard2(hand.get(3).getCardType());
                    score.setHighCard3(hand.get(2).getCardType());
                } else {
                    score.setHighCard1(hand.get(3).getCardType());
                    score.setHighCard2(hand.get(0).getCardType());
                    score.setHighCard3(hand.get(2).getCardType());
                }
            } else if (hand.get(1).getCardType() == hand.get(2).getCardType() && hand.get(3).getCardType() == hand.get(4).getCardType()) {
                if (hand.get(1).getCardType().compareTo(hand.get(3).getCardType()) > 0) {
                    score.setHighCard1(hand.get(1).getCardType());
                    score.setHighCard2(hand.get(3).getCardType());
                    score.setHighCard3(hand.get(0).getCardType());
                } else {
                    score.setHighCard1(hand.get(3).getCardType());
                    score.setHighCard2(hand.get(1).getCardType());
                    score.setHighCard3(hand.get(0).getCardType());
                }
            }
            return score;
        } else if (onepair(hand)) {
            score.setScoreType(ScoreType.ONE_PAIR);
            hand.sort(Comparator.comparing(Card::getCardType));
            CardType follow = hand.get(0).getCardType();
            boolean state;
            int skipIndex = -1;
            for (int i = 1; i < hand.size(); i++) {
                state = follow == hand.get(i).getCardType();
                if (state) {
                    score.setHighCard1(hand.get(i).getCardType());
                    skipIndex = i;
                    break;
                }
                follow = hand.get(i).getCardType();
            }
            if (skipIndex == 1) {
                score.setHighCard2(hand.get(4).getCardType());
                score.setHighCard3(hand.get(3).getCardType());
                score.setHighCard4(hand.get(2).getCardType());
            } else if (skipIndex == 2) {
                score.setHighCard2(hand.get(4).getCardType());
                score.setHighCard3(hand.get(3).getCardType());
                score.setHighCard4(hand.get(0).getCardType());
            } else if (skipIndex == 3) {
                score.setHighCard2(hand.get(4).getCardType());
                score.setHighCard3(hand.get(1).getCardType());
                score.setHighCard4(hand.get(0).getCardType());
            } else if (skipIndex == 4) {
                score.setHighCard2(hand.get(2).getCardType());
                score.setHighCard3(hand.get(1).getCardType());
                score.setHighCard4(hand.get(0).getCardType());
            }
            return score;
        } else {
            score.setScoreType(ScoreType.HIGH_CARD);
            score.setHighCard1(hand.get(4).getCardType());
            score.setHighCard2(hand.get(3).getCardType());
            score.setHighCard3(hand.get(2).getCardType());
            score.setHighCard4(hand.get(1).getCardType());
            score.setHighCard5(hand.get(0).getCardType());
            return score;
        }
    }

    private static boolean onepair(List<Card> hand) {
        for (int i = 0; i < hand.size(); i++) {
            CardType cardType = hand.get(i).getCardType();
            for (int j = i + 1; j < hand.size(); j++) {
                if (hand.get(j).getCardType() == cardType) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean twoPair(List<Card> hand) {
        hand.sort(Comparator.comparing(Card::getCardType));
        if (hand.get(0).getCardType() == hand.get(1).getCardType() && hand.get(2).getCardType() == hand.get(3).getCardType()) {
            return true;
        } else if (hand.get(0).getCardType() == hand.get(1).getCardType() && hand.get(3).getCardType() == hand.get(4).getCardType()) {
            return true;
        } else if (hand.get(1).getCardType() == hand.get(2).getCardType() && hand.get(3).getCardType() == hand.get(4).getCardType()) {
            return true;
        }
        return false;
    }

    private static boolean threeOfAKind(List<Card> hand) {
        hand.sort(Comparator.comparing(Card::getCardType));
        int state = 0;
        CardType follow = null;
        for (int i = 0; i < hand.size(); i++) {
            if (state == 3)
                return true;
            if (follow == null) {
                state++;
                follow = hand.get(i).getCardType();
                continue;
            }
            if (follow == hand.get(i).getCardType()) {
                state++;
                continue;
            }
            state = 1;
            follow = hand.get(i).getCardType();
        }
        return false;
    }

    private static boolean straight(List<Card> hand) {
        hand.sort(Comparator.comparing(Card::getCardType));
        CardType cardType = hand.get(0).getCardType();
        int lastIndex = -1;
        for (int i = 0; i < CardType.values().length; i++) {
            if (CardType.values()[i] == cardType) {
                lastIndex = i;
            }
        }
        for (int i = 1; i < hand.size(); i++) {
            cardType = hand.get(i).getCardType();
            for (int j = 0; j < CardType.values().length; j++) {
                if (CardType.values()[j] == cardType) {
                    if (j != lastIndex + 1)
                        return false;
                    lastIndex = j;
                }
            }
        }
        return true;
    }

    private static boolean flush(List<Card> hand) {
        CardColor cardColor = hand.get(0).getCardColor();
        for (Card card : hand) {
            if (card.getCardColor() != cardColor)
                return false;
        }
        return true;
    }

    private static boolean fullHouse(List<Card> hand) {
        int count = 1;
        CardType cardType = hand.get(0).getCardType();
        for (Card card : hand.subList(1, hand.size())) {
            if (cardType == card.getCardType()) {
                count++;
            }
        }
        boolean threeOfAKind = false;
        boolean twopair = false;
        if (count == 2) {
            twopair = true;
        } else if (count == 3) {
            threeOfAKind = true;
        }
        for (Card card : hand) {
            if (card.getCardType() != cardType) {
                cardType = card.getCardType();
            }
        }
        count = 0;
        for (Card card : hand) {
            if (cardType == card.getCardType()) {
                count++;
            }
        }
        if (count == 2) {
            twopair = true;
        } else if (count == 3) {
            threeOfAKind = true;
        }
        return threeOfAKind && twopair;
    }

    private static boolean fourOfAKind(List<Card> hand) {
        hand.sort(Comparator.comparing(Card::getCardType));
        return (hand.get(0).getCardType() == hand.get(1).getCardType()
                && hand.get(0).getCardType()== hand.get(2).getCardType()
                && hand.get(0).getCardType() == hand.get(3).getCardType())
                || (hand.get(1).getCardType() == hand.get(2).getCardType()
                && hand.get(1).getCardType() == hand.get(3).getCardType()
                && hand.get(1).getCardType() == hand.get(4).getCardType());
    }

    private static boolean straightFlush(List<Card> hand) {
        return straight(hand) && flush(hand);
    }

    private static boolean royalFlush(List<Card> hand) {
        boolean ace = false;
        for (Card card : hand) {
            if (card.getCardType() == CardType.ACE) {
                ace = true;
                break;
            }
        }
        if (!ace)
            return false;
        return straightFlush(hand);
    }

    public static void main(String[] args) {
        File pokerFile = new File(Objects.requireNonNull(
                Problem54_PokerHands.class.getClassLoader().getResource("p054_poker.txt")).getFile());
        Scanner scanner = null;
        try {
            scanner = new Scanner(pokerFile);
        } catch (FileNotFoundException e) {
            System.err.println("File p054_poker.txt not found");
            System.exit(1);
        }
        int count = 0;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] cards = line.split(" ");
            List<String> player1 = Arrays.stream(cards).toList().subList(0, 5);
            List<String> player2 = Arrays.stream(cards).toList().subList(5, 10);
            List<Card> player1Cards = new ArrayList<>();
            List<Card> player2Cards = new ArrayList<>();
            for (String card : player1) {
                Card c = createCard(card);
                player1Cards.add(c);
            }
            for (String card : player2) {
                Card c = createCard(card);
                player2Cards.add(c);
            }
            Score score1 = score(player1Cards);
            Score score2 = score(player2Cards);
            if (compareScore(score1, score2) > 0) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static int compareScore(Score score1, Score score2) {
        int compare = Comparator.comparing(Score::getScoreType).compare(score1, score2);
        if (compare > 0) {
            return 1;
        } else if (compare < 0) {
            return -1;
        }
        if (score1.getScoreType().equals(ScoreType.ROYAL_FLUSH)) {
            return 0;
        } else if (score1.getScoreType().equals(ScoreType.STRAIGHT_FLUSH)) {
            compare = Comparator.comparing(Score::getHighCard1).compare(score1, score2);
            if (compare > 0) {
                return 1;
            } else if (compare < 0) {
                return -1;
            }
            return 0;
        } else if (score1.getScoreType().equals(ScoreType.FOUR_OF_A_KIND)) {
            compare = Comparator.comparing(Score::getHighCard1).compare(score1, score2);
            if (compare > 0) {
                return 1;
            } else if (compare < 0) {
                return -1;
            }
            compare = Comparator.comparing(Score::getHighCard2).compare(score1, score2);
            if (compare > 0) {
                return 1;
            } else if (compare < 0) {
                return -1;
            }
            return 0;
        } else if (score1.getScoreType().equals(ScoreType.FULL_HOUSE)) {
            compare = Comparator.comparing(Score::getHighCard1).compare(score1, score2);
            if (compare > 0) {
                return 1;
            } else if (compare < 0) {
                return -1;
            }
            compare = Comparator.comparing(Score::getHighCard2).compare(score1, score2);
            if (compare > 0) {
                return 1;
            } else if (compare < 0) {
                return -1;
            }
            return 0;
        } else if (score1.getScoreType().equals(ScoreType.FLUSH)) {
            compare = Comparator.comparing(Score::getHighCard1).compare(score1, score2);
            if (compare > 0) {
                return 1;
            } else if (compare < 0) {
                return -1;
            }
            compare = Comparator.comparing(Score::getHighCard2).compare(score1, score2);
            if (compare > 0) {
                return 1;
            } else if (compare < 0) {
                return -1;
            }
            compare = Comparator.comparing(Score::getHighCard3).compare(score1, score2);
            if (compare > 0) {
                return 1;
            } else if (compare < 0) {
                return -1;
            }
            compare = Comparator.comparing(Score::getHighCard4).compare(score1, score2);
            if (compare > 0) {
                return 1;
            } else if (compare < 0) {
                return -1;
            }
            compare = Comparator.comparing(Score::getHighCard5).compare(score1, score2);
            if (compare > 0) {
                return 1;
            } else if (compare < 0) {
                return -1;
            }
            return 0;
        } else if (score1.getScoreType().equals(ScoreType.STRAIGHT)) {
            compare = Comparator.comparing(Score::getHighCard1).compare(score1, score2);
            if (compare > 0) {
                return 1;
            } else if (compare < 0) {
                return -1;
            }
            return 0;
        } else if (score1.getScoreType().equals(ScoreType.THREE_OF_A_KIND)) {
            compare = Comparator.comparing(Score::getHighCard1).compare(score1, score2);
            if (compare > 0) {
                return 1;
            } else if (compare < 0) {
                return -1;
            }
            compare = Comparator.comparing(Score::getHighCard2).compare(score1, score2);
            if (compare > 0) {
                return 1;
            } else if (compare < 0) {
                return -1;
            }
            compare = Comparator.comparing(Score::getHighCard3).compare(score1, score2);
            if (compare > 0) {
                return 1;
            } else if (compare < 0) {
                return -1;
            }
            return 0;
        } else if (score1.getScoreType().equals(ScoreType.TWO_PAIRS)) {
            compare = Comparator.comparing(Score::getHighCard1).compare(score1, score2);
            if (compare > 0) {
                return 1;
            } else if (compare < 0) {
                return -1;
            }
            compare = Comparator.comparing(Score::getHighCard2).compare(score1, score2);
            if (compare > 0) {
                return 1;
            } else if (compare < 0) {
                return -1;
            }
            compare = Comparator.comparing(Score::getHighCard3).compare(score1, score2);
            if (compare > 0) {
                return 1;
            } else if (compare < 0) {
                return -1;
            }
            return 0;
        } else if (score1.getScoreType().equals(ScoreType.ONE_PAIR)) {
            compare = Comparator.comparing(Score::getHighCard1).compare(score1, score2);
            if (compare > 0) {
                return 1;
            } else if (compare < 0) {
                return -1;
            }
            compare = Comparator.comparing(Score::getHighCard2).compare(score1, score2);
            if (compare > 0) {
                return 1;
            } else if (compare < 0) {
                return -1;
            }
            compare = Comparator.comparing(Score::getHighCard3).compare(score1, score2);
            if (compare > 0) {
                return 1;
            } else if (compare < 0) {
                return -1;
            }
            compare = Comparator.comparing(Score::getHighCard4).compare(score1, score2);
            if (compare > 0) {
                return 1;
            } else if (compare < 0) {
                return -1;
            }
            return 0;
        } else {
            compare = Comparator.comparing(Score::getHighCard1).compare(score1, score2);
            if (compare > 0) {
                return 1;
            } else if (compare < 0) {
                return -1;
            }
            compare = Comparator.comparing(Score::getHighCard2).compare(score1, score2);
            if (compare > 0) {
                return 1;
            } else if (compare < 0) {
                return -1;
            }
            compare = Comparator.comparing(Score::getHighCard3).compare(score1, score2);
            if (compare > 0) {
                return 1;
            } else if (compare < 0) {
                return -1;
            }
            compare = Comparator.comparing(Score::getHighCard4).compare(score1, score2);
            if (compare > 0) {
                return 1;
            } else if (compare < 0) {
                return -1;
            }
            compare = Comparator.comparing(Score::getHighCard5).compare(score1, score2);
            if (compare > 0) {
                return 1;
            } else if (compare < 0) {
                return -1;
            }
            return 0;
        }
    }

    private static Card createCard(String card) {
        CardType cardType = stringToCardType(card);
        CardColor cardColor = stringToCardColor(card);
        return new Card(cardType, cardColor);
    }

    private static CardColor stringToCardColor(String card) {
        if ('H' == card.charAt(1)) {
            return CardColor.HEARTS;
        } else if ('C' == card.charAt(1)) {
            return CardColor.CLUBS;
        } else if ('S' == card.charAt(1)) {
            return CardColor.SPADES;
        } else {
            return CardColor.DIAMONDS;
        }
    }

    private static CardType stringToCardType(String card) {
        if ('A' == card.charAt(0)) {
            return CardType.ACE;
        } else if ('K'  == card.charAt(0)) {
            return CardType.KING;
        } else if ('Q' == card.charAt(0)) {
            return CardType.QUEEN;
        } else if ('J' == card.charAt(0)) {
            return CardType.JACK;
        } else if ('T' == card.charAt(0)) {
            return CardType.TEN;
        } else if ('9' == card.charAt(0)) {
            return CardType.NINE;
        } else if ('8' == card.charAt(0)) {
            return CardType.EIGHT;
        } else if ('7' == card.charAt(0)) {
            return CardType.SEVEN;
        } else if ('6' == card.charAt(0)) {
            return CardType.SIX;
        } else if ('5' == card.charAt(0)) {
            return CardType.FIVE;
        } else if ('4' == card.charAt(0)) {
            return CardType.FOUR;
        } else if ('3' == card.charAt(0)) {
            return CardType.THREE;
        } else {
            return CardType.TWO;
        }
    }
}
