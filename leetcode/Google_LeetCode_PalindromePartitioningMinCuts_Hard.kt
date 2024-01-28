package com.algoexpert.program

// O(N^3) Time | O(N^2) Space
// fun palindromePartitioningMinCuts(str: String): Int {
//     var palindromes = Array(str.length) { BooleanArray(str.length) { false } }

//     for (i in str.indices) {
//         for (j in i until str.length) {
//             palindromes[i][j] = isPalindrome(str, i, j)
//         }
//     }

//     var cuts = IntArray(str.length) { Int.MAX_VALUE }

//     for (i in str.indices) {
//         if (palindromes[0][i]) {
//             cuts[i] = 0
//         } else {
//             cuts[i] = cuts[i - 1] + 1
//             for (j in 1 until i) {
//                 if(palindromes[j][i] && cuts[j - 1] + 1 < cuts[i]) {
//                     cuts[i] = cuts[j - 1] + 1
//                 }
//             }
//         }
//     }

//     return cuts[str.length - 1]
// }

// fun isPalindrome(
//     str: String,
//     start: Int,
//     end: Int,
// ): Boolean {
//     var left = start
//     var right = end

//     while (left < right) {
//         if (str[left] != str[right]) {
//             return false
//         }
//         left++
//         right--
//     }

//     return true
// }

// O(N^2) Time | O(N^2) Space
fun palindromePartitioningMinCuts(str: String): Int {
    var palindromes = Array(str.length) { BooleanArray(str.length) { false } }

    palindromes.flatMapIndexed { i, colume ->
        colume.mapIndexed { j, _ ->
            if (i == j) {
                colume[j] = true
            }
        }
    }

    for (length in 2 until str.length + 1) {
        for (i in 0 until str.length - length + 1) {
            var j = i + length - 1

            if (length == 2) {
                palindromes[i][j] = str[i] == str[j]
            } else {
                palindromes[i][j] = (str[i] == str[j] && palindromes[i + 1][j - 1])
            }
        }
    }

    var cuts = IntArray(str.length) { Int.MAX_VALUE }

    for (i in str.indices) {
        if (palindromes[0][i]) {
            cuts[i] = 0
        } else {
            cuts[i] = cuts[i - 1] + 1
            for (j in 1 until i) {
                if (palindromes[j][i] && cuts[j - 1] + 1 < cuts[i]) {
                    cuts[i] = cuts[j - 1] + 1
                }
            }
        }
    }

    return cuts[str.length - 1]
}
