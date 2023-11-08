package seminars.third.coverage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class SomeServiceTest {
    // 3.1.
    SomeService someService;

    @BeforeEach
    void setUp() {
        someService = new SomeService();
    }


    //    Создайте набор тестов, полностью покрывающих все ветви кода функции fizzBuzz. Эта
//функция принимает на вход число и возвращает "Fizz", если число делится на 3, "Buzz",
//если число делится на 5, и "FizzBuzz", если число делится на 15. Если число не делится ни
//на 3, ни на 5, ни на 15, функция возвращает входное число в виде строки
    @Test
    void multipleThreeNotFiveReturnsFizz() {
        assertEquals("Fizz", someService.fizzBuzz(3));
        // assertEquals...
    }

    @Test
    void multipleThreeNotFiveReturnsBuzz() {
        assertEquals("Buzz", someService.fizzBuzz(5));
        // assertEquals...
    }

    @Test
    void multipleThreeNotFiveReturnsFizzBuzz() {
        assertEquals("FizzBuzz", someService.fizzBuzz(15));
        // assertEquals...
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 7, 11, 17, 22})
    void multipleThreeNotFiveReturnsNumber(int i) {
        assertEquals(String.valueOf(i), someService.fizzBuzz(i));
        // assertEquals...
    }

    //  Разработайте тесты для метода firstLast6, где на вход подается массив чисел, а метод
//  возвращает true, если первое или последнее число в массиве равно 6, иначе false.
    @Test
    void checkFirstLast6isTrue() {
        assertTrue(someService.firstLast6(new int[]{6, 2, 3}));
        assertTrue(someService.firstLast6(new int[]{2, 3, 6}));
    }

    @Test
    void checkFirstLast6isFalse() {
        assertFalse(someService.firstLast6(new int[]{2, 6, 3}));
        assertFalse(someService.firstLast6(new int[]{2, 3}));
    }



    @ParameterizedTest
    @CsvSource({
            "2000.0, 50,1000",
            "2000.0,100,0",
            "2000.0,0,2000"
    })
    void insufficientCoverageTest(double i, int d, int r) {

        assertThat(someService.calculatingDiscount(i,d)).isEqualTo(r); // обычная скидка
//        assertThat(someService.calculatingDiscount(2000.0, 100))
//                .isEqualTo(0); // обычная скидка
//        assertThat(someService.calculatingDiscount(2000.0, 0))
//                .isEqualTo(2000); // обычная скидка
    }


    @Test
    void discountOverThat100() {
        assertThatThrownBy(() ->
                someService.calculatingDiscount(2000.0, 101))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100%"); // процент скидки больше 100%
    }

    @Test
    void discountSubZiro() {
        assertThatThrownBy(() ->
                someService.calculatingDiscount(2000.0, -10))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100%"); // процент скидки меньше 0
    }

//    Разработайте метод luckySum и напишите для него тесты. Этот метод принимает на вход три числа и возвращает
//    их сумму. Однако, если одно из чисел равно 13, то оно не учитывается при подсчете суммы.
//            Так, например, если b равно 13, то считается сумма только a и c.

    @Test
    void correctLuckySum() {
        assertThat(someService.luckySum(1,4,8)).isEqualTo(13);
    }

    @Test
    void correctLuckySumA() {
        assertThat(someService.luckySum(13,4,8)).isEqualTo(12);
    }

    @Test
    void correctLuckySumB() {
        assertThat(someService.luckySum(8,13,8)).isEqualTo(16);
    }

    @Test
    void correctLuckySumC() {
        assertThat(someService.luckySum(8,4,13)).isEqualTo(12);
    }
}