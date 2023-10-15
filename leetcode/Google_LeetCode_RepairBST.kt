package com.algoexpert.program

import java.util.Stack

// This is an input class. Do not edit.
open class BST(value: Int) {
    var value = value
    var left: BST? = null
    var right: BST? = null
}

fun repairBst_recursive(tree: BST): BST {
    var nodeOne: BST? = null
    var nodeTwo: BST? = null
    var previousNode: BST? = null
    
    fun inOrderTraversal(currentNode: BST?) {
        if(currentNode == null) return
    
        inOrderTraversal(currentNode.left)
    
        if(previousNode != null && previousNode!!.value > currentNode.value) {
            if(nodeOne == null) {
                nodeOne = previousNode
            }
            nodeTwo = currentNode
        }
    
        previousNode = currentNode
        inOrderTraversal(currentNode.right)
    }

    inOrderTraversal(tree)
    
    val tempNodeOneValue = nodeOne?.value
    nodeOne?.value = nodeTwo?.value!!
    nodeTwo?.value = tempNodeOneValue!!
    
    return tree
}

fun repairBst_iterator(tree: BST): BST {
    var nodeOne: BST? = null
    var nodeTwo: BST? = null
    var previousNode: BST? = null
    var currentNode: BST? = tree

    val stack = Stack<BST>()
    while(currentNode != null || stack.isNotEmpty()) {
        while(currentNode != null) {
            stack.add(currentNode)
            currentNode = currentNode.left
        }
        currentNode = stack.pop()

        if(previousNode != null && previousNode.value > currentNode?.value!!) {
            if(nodeOne == null) {
                nodeOne = previousNode
            }
            nodeTwo = currentNode
        }
        previousNode = currentNode
        currentNode = currentNode.right
    }

    val tempNodeOneValue = nodeOne?.value
    nodeOne?.value = nodeTwo?.value!!
    nodeTwo.value = tempNodeOneValue!!
    
    return tree
}
