public enum Type {
    Two(2), Three(3), Four(4), Five(5), Six(6), Seven(7), Eight(8),
    Nine(9), Ten(10), J(11), Q(12), K(13), A(14);
    final int value;

    Type(int val) {
        this.value = val;
    }
    int getValue() {
        return this.value;
    }
}
