

import kotlin.collections.mutableListOf// This is an input class. Do not edit.
open class BST(value: Int) {
    var value = value
    var left: BST? = null
    var right: BST? = null
}

class TreeInfo(
    index: Int,
    lastValue: Int,
) {
    var index = index
    var lastValue = lastValue
}

//O(h + k) Time | O(h) Space
// fun findKthLargestValueInBst(tree: BST, k: Int): Int {
//     val treeInfo = TreeInfo(0, 0)
//     findKthLargestValueInBst(tree, treeInfo, k)
//     return treeInfo.lastValue
// }

fun findKthLargestValueInBst(tree: BST?, treeInfo: TreeInfo, k: Int) {
    if(tree == null || treeInfo.index >= k) return

    findKthLargestValueInBst(tree.right, treeInfo, k)
    if(treeInfo.index < k) {
        treeInfo.index = treeInfo.index + 1
        treeInfo.lastValue = tree.value
        findKthLargestValueInBst(tree.left, treeInfo, k)
    }
}

//O(n) Time | O(n) Space
fun findKthLargestValueInBst(tree: BST, k: Int): Int {
    val sortedIndexList: MutableList<Int> = mutableListOf()
    recursiveTreeValueList(tree, k, sortedIndexList)

    return sortedIndexList[k-1]
}

fun recursiveTreeValueList(tree: BST?, k: Int, arrayList: MutableList<Int>) {
    if(tree == null) return
    recursiveTreeValueList(tree.right, k, arrayList)
    arrayList.add(tree.value)
    recursiveTreeValueList(tree.left, k, arrayList)
}
