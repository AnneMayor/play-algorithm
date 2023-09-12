package com.algoexpert.program

fun moveElementToEnd(array: MutableList<Int>, toMove: Int): List<Int> {
    var startIdx = 0
    var endIdx = array.size - 1

    while(startIdx < endIdx) {

        if(array[startIdx] == toMove && array[endIdx] != toMove) {
            val temp = array[startIdx]
            array[startIdx] = array[endIdx]
            array[endIdx] = temp
        }

        if(array[startIdx] != toMove) startIdx++;
        if(array[endIdx] == toMove) endIdx--;
    }

    return array
}
