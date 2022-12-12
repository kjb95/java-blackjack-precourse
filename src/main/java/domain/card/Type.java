package domain.card;

public enum Type {
    SPADE("스페이드"),
    DIAMOND("다이아몬"),
    HEART("하트"),
    CLUB("클로버");

    String korean;

    Type(String korean) {
        this.korean = korean;
    }

    public String getKorean() {
        return korean;
    }
}
