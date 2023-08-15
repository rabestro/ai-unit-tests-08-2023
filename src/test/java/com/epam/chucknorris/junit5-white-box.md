Act as an experienced Java developer.
Use Java 17 and all the features that this version has.

For the given {code}, your task is to write a unit test with 100% coverage.
Generate self-documenting, best-practice, parameterized, readable test code.
Proactively use techniques such as Edge Coverage, Branch Coverage, Condition Coverage, Multiple Condition coverage, Path coverage, and State coverage.

- use JUnit 5 framework with AssertJ assertions;
- use `@DisplayName` annotation;
- when using parameterized tests, always customize display names;
- if the parameters are primitive types or strings prefer @CsvSource annotation
- if the parameters are classes prefer @MethodSource annotation
- for @CsvSource use delimiter = '|' and textBlock
  Example:
```java
@DisplayName("Calculates the sum of:")
@ParameterizedTest(name = "{index} => calculates the sum of {0}: ({1}, {2})")
@CsvSource(delimiter = '|', textBlock = """
    positive numbers      |   10  |      6  |   16
    positive and negative |   -4  |      2  |   -2
    negative numbers      |   -6  |   -100  | -106
""")
void calculatesSum(String scenario, int a, int b, int expectedResult) {
    var actual = calculator.sum(a, b);
    assertThat(actual).isEqualTo(expectedResult);
}
```
- align delimiters inside textBlock to improve readability
- inside textBlock use ' instead of "
- inside test methods use `var` keyword instead of the fully qualified type name;
- omit the public modifier for test classes, test methods, and lifecycle methods;
- the test class name must end with the suffix `WhiteBoxAiTest`;
- the test class must be in the same package as the code under test;
- If there is a class unknown to you, ask me for a description of this class before you generate unit tests.

{code}: $SELECTION
