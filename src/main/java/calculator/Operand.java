package calculator;

public class Operand {
    private int number;

    Operand(int number) {
        this.number = number;
    }

    Operand(String number) {
        if (!isDigit(number)) {
            throw new IllegalArgumentException("피연산자가 숫자가 아닙니다.");
        }
        this.number = Integer.parseInt(number);
    }

    private boolean isDigit(String number) {
        return number.chars().allMatch(Character::isDigit);
    }

    public int getNumber() {
        return this.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Operand operand = (Operand) o;

        return number == operand.number;
    }

    @Override
    public int hashCode() {
        return number;
    }
}
