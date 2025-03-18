public class Calculator {
    public Calculator() {
    }

    public long sum(long a, long b) {
        if ((b > 0 && a > Long.MAX_VALUE - b) || (b < 0 && a < Long.MIN_VALUE - b)) {
            throw new ArithmeticException("Long overflow occurred");
        }
        return a + b;
    }

    public double sum(double a, double b) {
        if (Double.isNaN(a) || Double.isNaN(b) || Double.isInfinite(a) || Double.isInfinite(b)) {
            throw new IllegalArgumentException("Invalid input: NaN or Infinity values are not allowed");
        }
        return a + b;
    }


    public long sub(long a, long b) {
        if (b > 0 && a < Long.MIN_VALUE + b) {
            throw new ArithmeticException("Long underflow");
        }
        if (b < 0 && a > Long.MAX_VALUE + b) {
            throw new ArithmeticException("Long overflow");
        }
        return a - b;
    }

    public double sub(double a, double b) {
        if (Double.isNaN(a) || Double.isNaN(b) || Double.isInfinite(a) || Double.isInfinite(b)) {
            throw new IllegalArgumentException("Invalid input: NaN or Infinity is not allowed");
        }
        return a - b;
    }

    public long mult(long a, long b) {
        if (a > 0 && b > 0 && a > Long.MAX_VALUE / b) {
            throw new ArithmeticException("Long overflow");
        }
        if (a < 0 && b < 0 && a < Long.MAX_VALUE / b) {
            throw new ArithmeticException("Long overflow");
        }
        if (a > 0 && b < 0 && b < Long.MIN_VALUE / a) {
            throw new ArithmeticException("Long underflow");
        }
        if (a < 0 && b > 0 && a < Long.MIN_VALUE / b) {
            throw new ArithmeticException("Long underflow");
        }
        return a * b;
    }

    public double mult(double a, double b) {
        if (Double.isNaN(a) || Double.isNaN(b) || Double.isInfinite(a) || Double.isInfinite(b)) {
            throw new IllegalArgumentException("Invalid input: NaN or Infinity values are not allowed");
        }
        return a * b;
    }

    public long div(long a, long b) {
        if (b == 0L) {
            throw new ArithmeticException("Attempt to divide by zero");
        }
        return a / b;
    }

    public double div(double a, double b) {
        if (Double.isNaN(a) || Double.isNaN(b) || Double.isInfinite(a) || Double.isInfinite(b)) {
            throw new IllegalArgumentException("Invalid input: NaN or Infinity");
        }
        if (b == 0.0) {
            throw new ArithmeticException("Division by zero");
        }
        return a / b;
    }


    public double pow(double a, double b) {
        if (Double.isNaN(a) || Double.isNaN(b) || Double.isInfinite(a) || Double.isInfinite(b)) {
            throw new IllegalArgumentException("Invalid input: NaN or Infinity");
        }
        return Math.pow(a, b);
    }


    public double sqrt(double a) {
        if (a < 0 || Double.isNaN(a) || Double.isInfinite(a) && a < 0) {
            throw new IllegalArgumentException("Cannot calculate square root of negative numbers, NaN, or negative infinity");
        }
        return Math.sqrt(Math.abs(a));
    }

    public double tg(double a) {
        if (Double.isNaN(a) || Double.isInfinite(a)) {
            throw new IllegalArgumentException("Invalid input: NaN or Infinity");
        }
        double sinValue = Math.sin(a);
        double cosValue = Math.cos(a);

        if (Math.abs(cosValue) < 1e-10) {
            throw new ArithmeticException("Tangent is undefined for angles π/2 + kπ");
        }

        return sinValue / cosValue;
    }


    public double ctg(double a) {
        if (Double.isNaN(a) || Double.isInfinite(a)) {
            throw new IllegalArgumentException("Input cannot be NaN or infinite");
        }
        if (Math.abs(Math.sin(a)) < 1e-10) { // Уникаємо проблем з точністю
            throw new ArithmeticException("Cotangent is undefined for angles where sin(a) == 0");
        }
        return 1.0 / Math.tan(a);
    }

    public double cos(double a) {
        if (Double.isNaN(a) || Double.isInfinite(a)) {
            throw new IllegalArgumentException("Invalid input: NaN or Infinity");
        }
        return Math.cos(a);
    }


    public double sin(double a) {
        if (Double.isNaN(a) || Double.isInfinite(a)) {
            throw new IllegalArgumentException("Invalid input: NaN or Infinity is not allowed");
        }
        return Math.sin(a);
    }

    public boolean isPositive(long val) {
        if (val == 0L) {
            return false;
        } else {
            return val > 0L;
        }
    }

    public boolean isNegative(long val) {
        return val < 0L;
    }
}