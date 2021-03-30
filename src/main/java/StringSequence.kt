class StringSequence : CharSequence {

    override val length: Int
    private val array: CharArray

    constructor(charSequence: CharSequence = "") {
        length = charSequence.length
        array = CharArray(length)
        for (i in 0 until length) {
            array[i] = charSequence[i]
        }
    }


    constructor(array: CharArray) {
        length = array.size
        this.array = array
    }

    override fun get(index: Int): Char {
        return array[index]
    }

    operator fun plus(sequence: StringSequence) = StringSequence(array + sequence.array)

    override fun subSequence(startIndex: Int, endIndex: Int): StringSequence {
        val size = endIndex - startIndex

        if (size == 0) {
            return this
        }

        val result = CharArray(size)

        for ((index, i) in (startIndex until endIndex).withIndex()) {
            result[index] = array[i]
        }
        return StringSequence(result)
    }

    fun trim(): StringSequence {
        var start = 0
        var end: Int = length - 1

        while (Character.isWhitespace(array[start]) && start < length) {
            start++
        }
        while (Character.isWhitespace(array[end]) && end > 0) {
            end--
        }
        return if (end > start) {
            subSequence(start, end + 1)
        } else
            this
    }

    fun find(sequence: StringSequence): Boolean {
        return toString().contains(sequence)
    }

    fun toFloat() = toString().toFloat()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as StringSequence

        if (length != other.length) return false
        if (!array.contentEquals(other.array)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = length
        result = 31 * result + array.contentHashCode()
        return result
    }


    override fun toString(): String {
        return String(array)
    }

}

fun Int.toMyString() = StringSequence(toString())