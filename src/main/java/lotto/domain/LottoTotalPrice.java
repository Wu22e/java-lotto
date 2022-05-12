package lotto.domain;

import lotto.util.StringNumberUtils;

public class LottoTotalPrice {
    public static final int UNIT_LOTTO_PRICE = 1000;
    private static final int ZERO = 0;

    private final int totalPrice;

    public LottoTotalPrice(int totalPrice) {
        validateTotalPriceRange(totalPrice);
        this.totalPrice = totalPrice;
    }

    public static LottoTotalPrice create(String stringTotalPrice) {
        return new LottoTotalPrice(StringNumberUtils.parse(stringTotalPrice));
    }

    public int getTotalPrice() {
        return this.totalPrice;
    }

    public int getPurchaseLottoCount() {
        return this.totalPrice / UNIT_LOTTO_PRICE;
    }

    public boolean lessThan(int totalPrice) {
        return this.totalPrice < totalPrice;
    }

    private void validateTotalPriceRange(int totalPrice) {
        if (totalPrice < ZERO) {
            throw new IllegalArgumentException(String.format("구매금액(입력 받은 구매 금액 : %d)은 음수일 수 없습니다.", totalPrice));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LottoTotalPrice that = (LottoTotalPrice) o;

        return totalPrice == that.totalPrice;
    }

    @Override
    public int hashCode() {
        return totalPrice;
    }
}
