import kotlin.math.round

open class BST(value: Int) {
    var value = value
    var left: BST? = null
    var right: BST? = null

    fun insert(value: Int) {
        if (value < this.value) {
            if (this.left == null) {
                this.left = BST(value)
            } else {
                this.left!!.insert(value)
            }
        } else {
            if (this.right == null) {
                this.right = BST(value)
            } else {
                this.right!!.insert(value)
            }
        }
    }
}

fun minHeightBst(array: List<Int>): BST {
    val result = constructMinHeightBst(array, null, 0, array.size - 1) ?: return BST(-1)
    return result
}


// O(NlogN) Time | O(N) Space
// fun constructMinHeightBst(array: List<Int>, bst: BST?, startIndex: Int, endIndex: Int): BST? {
//     if(startIndex > endIndex) return null;

//     val midIndex = ((startIndex + endIndex) / 2).toInt()

//     var rootBst = bst

//     if(rootBst == null) {
//         rootBst = BST(array[midIndex])
//     } else {
//         rootBst.insert(array[midIndex])
//     }

//     constructMinHeightBst(array, rootBst, startIndex, midIndex - 1)
//     constructMinHeightBst(array, rootBst, midIndex + 1, endIndex)

//     return rootBst;
// }

// O(N) Time | O(N) Space
// fun constructMinHeightBst(array: List<Int>, bst: BST?, startIndex: Int, endIndex: Int): BST? {
//     if(startIndex > endIndex) return null
    
//     val midIndex = round((startIndex + endIndex) / 2.0).toInt()

//     var rootBst = bst
//     if(rootBst == null) {
//         rootBst = BST(array[midIndex])
//     } else {
//         if(rootBst.value > array[midIndex]) {
//             rootBst.left = BST(array[midIndex])
//             rootBst = rootBst.left
//         } else {
//             rootBst.right = BST(array[midIndex])
//             rootBst = rootBst.right
//         }
//     }

//     constructMinHeightBst(array, rootBst, startIndex, midIndex - 1)
//     constructMinHeightBst(array, rootBst, midIndex + 1, endIndex)
    
//     return rootBst
// }

// O(N) Time | O(N) Space - Clean Code
fun constructMinHeightBst(array: List<Int>, startIndex: Int, endIndex: Int): BST? {
    if(startIndex > endIndex) return null
    
    val midIndex = round((startIndex + endIndex) / 2.0).toInt()

    var rootBst = BST(array[midIndex])

    rootBst.left = constructMinHeightBst(array, startIndex, midIndex - 1)
    rootBst.right = constructMinHeightBst(array, midIndex + 1, endIndex)
    
    return rootBst
}
