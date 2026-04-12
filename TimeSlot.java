package university.model;

public enum Grade {
    A(4.0), A_MINUS(3.7), B_PLUS(3.3), B(3.0), B_MINUS(2.7),
    C_PLUS(2.3), C(2.0), C_MINUS(1.7), D(1.0), F(0.0),
    I(null), W(null);

    private final Double points;

    Grade(Double points) { this.points = points; }

    public Double getPoints() { return points; }

    public boolean hasNumericValue() { return points != null; }
}
