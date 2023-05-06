import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class FindSecondMaxTest {
    private fun search(nums: List<Int>): Int {
        var max: Int
        var prevMax: Int

        if (nums.get(0).compareTo(nums.get(1)) > 0) {
            max = nums.get(0)
            prevMax = nums.get(1)
        } else {
            max = nums.get(1)
            prevMax = nums.get(0)
        }

        for (i in nums) {
            if (i.compareTo(max) > 0) {
                prevMax = max
                max = i
            }
        }
//        println(String.format("max=%d prevMax=%d", max, prevMax))
        return prevMax
    }

    @Test
    fun searchPrevMaxTest() {
        var nums = listOf<Int>(50, 40, 30, 20)
        Assertions.assertEquals(40, search(nums))

        nums = listOf<Int>(20, 30, 40, 50)
        Assertions.assertEquals(40, search(nums))
    }
}