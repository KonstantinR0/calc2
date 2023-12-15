package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CalcTest {

    @BeforeAll
    public static void setUp(){
        System.out.println("before all");
    }

    @BeforeEach
    public  void setUpEach(){
        System.out.println("before Each");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("after all");
    }

    @AfterEach
    public  void afterAllEach(){
        System.out.println("after Each");
    }


    @Test
    @DisplayName("Сумирование")
    @Tag("plus")
    void summ() {
        Calc calc = new Calc();
        int result = calc.summ(12,25);
        Assertions.assertEquals(37, result);
    }

    @ParameterizedTest(name = "#{index} - сложение {0} и {1}, ожидаем {2}")
    @DisplayName("Сумирование Параметров")
    @CsvSource ({"1, 2, 3","-10, 15, 5","0, 0, 0"})
    @Tag("plus")
    void summ1(int a, int b, int expectedResult) {
        Calc calc = new Calc();
        int result = calc.summ(a, b);
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Вычитание")
    @Tag("minus")
    void subtraction() {
        Calc calc = new Calc();
        int result = calc.subtraction(12,25);
        Assertions.assertEquals(-13, result);
    }

    @ParameterizedTest(name = "#{index} - сложение {0} и {1}, ожидаем {2}")
    @DisplayName("Вычитание Параметров")
    @CsvSource ({"1, 2, -1","-10, 15, -25","0, 0, 0"})
    @Tag("minus")
    void subtraction1(int a, int b, int expectedResult) {
        Calc calc = new Calc();
        int result = calc.subtraction(a, b);
        Assertions.assertEquals(expectedResult, result);
    }
}