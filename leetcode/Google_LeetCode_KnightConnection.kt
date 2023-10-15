package com.algoexpert.program

import kotlin.math.abs
import kotlin.math.min
import kotlin.math.ceil

// data class Knight(
//         val x: Int,
//         val y: Int,
//         val numOfMoves: Int,
// )

// fun knightConnection(knightA: MutableList<Int>, knightB: MutableList<Int>): Int {
//     var minimumMovements = Int.MAX_VALUE

//     val directions =
//             listOf(
//                     listOf(-2, 1),
//                     listOf(-1, 2),
//                     listOf(1, 2),
//                     listOf(2, 1),
//                     listOf(2, -1),
//                     listOf(1, -2),
//                     listOf(-1, -2),
//                     listOf(-2, -1)
//             )

//     val movementQueue = ArrayDeque<Knight>()
//     movementQueue.add(Knight(knightA[0], knightA[1], 0))

//     while (movementQueue.isNotEmpty()) {
//         val knightAPosition = movementQueue.removeFirst()

//         if (knightAPosition.x == knightB[0] && knightAPosition.y == knightB[1]) {
//             minimumMovements = min(knightAPosition.numOfMoves / 2, minimumMovements)
//         }

//         directions.forEach {
//             val newKnightAX = knightAPosition.x + it[0]
//             val newKnightAY = knightAPosition.y + it[1]

//             if (newKnightAX < 0 || newKnightAY < 0) continue

//             val currentXDiff = abs(knightAPosition.x - knightB[0])
//             val currentYDiff = abs(knightAPosition.y - knightB[1])
//             val nextXDiff = abs(newKnightAX - knightB[0])
//             val newYDiff = abs(newKnightAY - knightB[1])

//             if (nextXDiff + newYDiff >= currentXDiff + currentYDiff) continue

//             movementQueue.add(Knight(newKnightAX, newKnightAY, knightAPosition.numOfMoves + 1))
//         }
//     }

//     return minimumMovements
// }

fun knightConnection(knightA: MutableList<Int>, knightB: MutableList<Int>): Int {
    val directions =
            listOf(
                    listOf(-2, 1),
                    listOf(-1, 2),
                    listOf(1, 2),
                    listOf(2, 1),
                    listOf(2, -1),
                    listOf(1, -2),
                    listOf(-1, -2),
                    listOf(-2, -1)
            )

    val queue = mutableListOf(listOf(knightA[0], knightA[1], 0))
    val visited = mutableSetOf(positionToString(knightA))

    while (true) {
        val currentPosition = queue.removeAt(0)

        if(currentPosition[0] == knightB[0] && currentPosition[1] == knightB[1]) {
            return ceil(currentPosition[2] / 2.0).toInt()
        }

        directions.forEach { 
            val newPosition = mutableListOf(currentPosition[0] + it[0], currentPosition[1] + it[1])
            val newPositionJoinToString = positionToString(newPosition)
            if((newPositionJoinToString in visited) == false) {
                newPosition.add(currentPosition[2] + 1)
                queue.add(newPosition)
                visited.add(newPositionJoinToString)
            }


         }
    }
}

fun positionToString(position: List<Int>): String = position.joinToString(",")
