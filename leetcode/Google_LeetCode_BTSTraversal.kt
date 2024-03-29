open class BST(value: Int) {
    var value = value
    var left: BST? = null
    var right: BST? = null
}

fun inOrderTraverse(tree: BST?, array: MutableList<Int>): List<Int> {
    if(tree != null) {
        inOrderTraverse(tree.left, array)
        array.add(tree.value)
        inOrderTraverse(tree.right, array)   
    }
    return array
}

fun preOrderTraverse(tree: BST?, array: MutableList<Int>): List<Int> {
    if(tree != null) {
        array.add(tree.value)
        preOrderTraverse(tree.left, array)
        preOrderTraverse(tree.right, array)
    }

    return array
}

fun postOrderTraverse(tree: BST?, array: MutableList<Int>): List<Int> {
    if(tree != null) {
        postOrderTraverse(tree.left, array)
        postOrderTraverse(tree.right, array)
        array.add(tree.value)
    }
    return array
}