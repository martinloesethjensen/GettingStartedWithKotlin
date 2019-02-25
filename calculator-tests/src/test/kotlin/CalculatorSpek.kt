import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.jupiter.api.Assertions

class CalculatorSpek : Spek({
    var calculator: Calculator? = null
    describe("The calculator") {
        beforeEachTest {
            calculator = Calculator(NullResult())
        }

        it("Should add two numbers") {
            val result = calculator?.add(12, 13)
            Assertions.assertEquals(25, result)
        }

        it("Should accumulate one number") {
            calculator?.accumulate(23)
            Assertions.assertEquals(23, calculator?.total)
        }

        it("should accumulate two numbers") {
            calculator?.accumulate(2)
            calculator?.accumulate(3)
            Assertions.assertEquals(3, calculator?.total)
        }
    }

    describe("The output should be written correctly"){
        var result : Result = mock()
        val calculator = Calculator(result)
        it("Should write the output amount"){
            calculator.accumulate(23)
            verify(result).write(23)
        }
    }
})