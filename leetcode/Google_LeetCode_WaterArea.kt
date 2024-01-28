fun waterArea(heights: List<Int>): Int {
    var totalWaterSurfaceArea = 0

    var leftMaxArray = Array(heights.size) { 0 }

    for (i in 1 until heights.size) {
        leftMaxArray[i] = Math.max(leftMaxArray[i - 1], heights[i - 1])
    }

    var rightMaxArray = Array(heights.size) { 0 }

    for (i in heights.size - 2 downTo 0) {
        rightMaxArray[i] = Math.max(rightMaxArray[i + 1], heights[i + 1])
    }

    var heightDiffArray = Array(heights.size) { 0 }

    for (i in heights.indices) {
        val minHeight = Math.min(leftMaxArray[i], rightMaxArray[i])
        if (heights[i] < minHeight) {
            heightDiffArray[i] = minHeight - heights[i]
        }
    }

    for (i in heights.indices) {
        totalWaterSurfaceArea += heightDiffArray[i]
    }

    return totalWaterSurfaceArea
}