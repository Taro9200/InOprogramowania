import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    // Zadanie 1: Testowanie funkcji dodawania
    @Test
    public void testSumyDwochLiczbDodatnich() {
        assertThat(Calculator.add_numbers(5, 7)).isEqualTo(12);
    }

    @Test
    public void testSumyDodatniejIUjemnej() {
        assertThat(Calculator.add_numbers(10, -5)).isEqualTo(5);
    }

    @Test
    public void testSumyDwochLiczbUjemnych() {
        assertThat(Calculator.add_numbers(-7, -3)).isEqualTo(-10);
    }

    @Test
    public void testSumyZerowej() {
        assertThat(Calculator.add_numbers(0, 9)).isEqualTo(9);
        assertThat(Calculator.add_numbers(0, 0)).isEqualTo(0);
    }

    // Zadanie 2: Testowanie funkcji sprawdzającej parzystość
    @Test
    public void testLiczbaParzysta() {
        assertThat(Calculator.is_even(4)).isTrue();
        assertThat(Calculator.is_even(10)).isTrue();
        assertThat(Calculator.is_even(0)).isTrue(); // Testowanie zera jako liczby parzystej
    }

    @Test
    public void testLiczbaNieparzysta() {
        assertThat(Calculator.is_even(3)).isFalse();
        assertThat(Calculator.is_even(-1)).isFalse();
    }

    @Test
    public void testLiczbaZero() {
        assertThat(Calculator.is_even(0)).isTrue(); // Zero jest parzyste
    }

    @Test
    public void testDuzaLiczba() {
        assertThat(Calculator.is_even(1000000)).isTrue();
    }

    // Zadanie 3: Testowanie funkcji konwertującej temperaturę
    @Test
    public void testStandardowejTemperatury() {
        assertThat(Calculator.celsius_to_fahrenheit(0)).isEqualTo(32);
        assertThat(Calculator.celsius_to_fahrenheit(100)).isEqualTo(212);
    }

    @Test
    public void testTemperaturyUjemnej() {
        assertThat(Calculator.celsius_to_fahrenheit(-10)).isEqualTo(14);
    }

    @Test
    public void testTemperaturyZero() {
        assertThat(Calculator.celsius_to_fahrenheit(0)).isEqualTo(32); // Zero stopni Celsjusza
    }

    @Test
    public void testDuzychWartosci() {
        assertThat(Calculator.celsius_to_fahrenheit(1000)).isEqualTo(1832);
    }

    // Zadanie 4: Testowanie funkcji obliczającej silnię
    @Test
    public void testSilniDlaMalychLiczb() {
        assertThat(Calculator.factorial(0)).isEqualTo(1);
        assertThat(Calculator.factorial(1)).isEqualTo(1);
        assertThat(Calculator.factorial(2)).isEqualTo(2);
    }

    @Test
    public void testSilniDlaDuzychLiczb() {
        assertThat(Calculator.factorial(5)).isEqualTo(120);
        assertThat(Calculator.factorial(10)).isEqualTo(3628800);
    }

    @Test
    public void testSilniDlaLiczbUjemnych() {
        try {
            Calculator.factorial(-5);
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage()).isEqualTo("Silnia nie jest zdefiniowana dla liczb ujemnych");
        }
    }

    @Test
    public void testSilniDlaWydajnosci() {
        // Test wydajności dla dużych liczb
        assertThat(Calculator.factorial(20)).isEqualTo(2432902008176640000L);
    }

    // Zadanie 5: Testowanie funkcji sprawdzającej liczbę pierwszą
    @Test
    public void testLiczbPierwszych() {
        assertThat(Calculator.is_prime(2)).isTrue();
        assertThat(Calculator.is_prime(3)).isTrue();
        assertThat(Calculator.is_prime(5)).isTrue();
    }

    @Test
    public void testLiczbNiepierwszych() {
        assertThat(Calculator.is_prime(4)).isFalse();
        assertThat(Calculator.is_prime(9)).isFalse();
    }

    @Test
    public void testLiczbMniejszychNiz2() {
        assertThat(Calculator.is_prime(0)).isFalse();
        assertThat(Calculator.is_prime(1)).isFalse();
    }

    @Test
    public void testDuzychLiczbPierwszych() {
        assertThat(Calculator.is_prime(1000033)).isTrue(); // Przykład dużej liczby pierwszej
        assertThat(Calculator.is_prime(1000000)).isFalse(); // Przykład dużej liczby niepierwszej
    }
}
