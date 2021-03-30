import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ClassTest {
    private val helloString: StringSequence = StringSequence("Hello")
    private val onixString: StringSequence = StringSequence(" Onix")

    @Test
    fun testString() {
        assertTrue(helloString.toString() == "Hello")
    }

    @Test
    fun testPlus() {
        assertTrue(helloString + onixString == StringSequence("Hello Onix"))
    }

    @Test
    fun testSubSequence() {
        assertTrue(StringSequence("Hello Onix").subSequence(0, 4) == StringSequence("Hell"))
        assertFalse(StringSequence("Hello Onix").subSequence(0, 4) == StringSequence("Onix"))
    }

    @Test
    fun testTrim() {
        val beforeTrim = StringSequence(" ") + helloString + StringSequence(" ")
        assertTrue(beforeTrim == StringSequence(" Hello "))

        val trimmed = beforeTrim.trim()
        assertTrue(trimmed == helloString)
    }

    @Test
    fun testFind() {
        val stringFind = helloString + onixString
        assertTrue(stringFind.find(StringSequence(" Onix")))
    }

    @Test
    fun testToFloat() {
        val float = StringSequence("1.5")
        assertTrue(float.toFloat() == 1.5f)
    }

    @Test
    fun testIntToMyString() {
        val int = 9
        assertTrue(int.toMyString() == StringSequence("9"))
    }


}
