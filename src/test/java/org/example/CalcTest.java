package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CalcTest {
/*
    @BeforeAll
    public static void beforeAll(){
        System.out.println("before all");
    }

    @BeforeEach
    public void beforeEach(){
        System.out.println("before each");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("after all");
    }

    @AfterEach
    public void afterEach(){
        System.out.println("after each");
    }
*/
    @Test
    @DisplayName("Проверка суммирования")
    @Timeout(10)
    @Tag("addition")
    @Tag("regression")
    void addition1() {
        Calc calc = new Calc();
        int result = calc.addition(1, 6);
        Assertions.assertEquals(7, result, "Не верно работает суммирование");
    }

    @ParameterizedTest(name = "#{index} - сложение {0} и {1}, ожидаем: {2}")
    @DisplayName("Проверка суммирования")
    @CsvSource({"1,2,3", "4,5,9", "5,7,12"})
    @Tag("addition")
    @Tag("regression")
    void addition2(int a, int b, int expectedResult) {
        Calc calc = new Calc();
        int result = calc.addition(a, b);
        Assertions.assertEquals(expectedResult, result, "Не верно работает суммирование");
    }

    @Test
    @DisplayName("Проверка вычитания")
    @Tag("subtraction")
    @Tag("regression")
    void subtraction1() {
        Calc calc = new Calc();
        int result = calc.subtraction(1, 1);
        Assertions.assertEquals(0, result, "Не верно работает вычитание");
    }

    @ParameterizedTest(name = "#{index} - вычитание {0} и {1}, ожидаем: {2}")
    @DisplayName("Проверка вычитания")
    @CsvSource({"0,1,-1", "1,0,1", "0,0,0"})
    @Tag("subtraction")
    @Tag("regression")
    void subtration2(int a, int b, int expectedResult) {
        Calc calc = new Calc();
        int result = calc.subtraction(a, b);
        Assertions.assertEquals(expectedResult, result, "Не верно работает вычитание");
    }
}