#!/usr/bin/envkotlin kotlin

// https://leetcode.com/problems/letter-case-permutation/submissions/
// Given a string, find all of its permutations preserving the character sequence but changing case.

class Solution {
    fun letterCasePermutation(s: String): List<String> {
        val result = mutableListOf<String>()
        result.add(s)
        for (i in 0 .. s.lastIndex) {
            val char = s[i]
            if (char.isLetter()) {
                result.addAll(result.map {
                    val asCharArray = it.toCharArray()
                    asCharArray[i] = if (asCharArray[i].isLowerCase()) {
                        asCharArray[i].toUpperCase()
                    } else {
                        asCharArray[i].toLowerCase()
                    }
                    asCharArray.joinToString("")
                })
            }
        }

        return result
    }
    
    fun letterCasePermutation2(s: String): List<String> {
        var result = mutableListOf<String>()
        for (i in 0 .. s.lastIndex) {
            val char = s[i]
            if (result.isEmpty()) {
                if (char.isDigit()) {
                    result.add(char.toString())
                } else {
                    result.add(char.toLowerCase().toString())
                    result.add(char.toUpperCase().toString())
                }
            } else {
                result = if (char.isDigit()) {
                    result.map { it + char }.toMutableList()
                } else {
                    val withLower = result.map { it + char.toLowerCase() }.toMutableList()
                    val withUpper = result.map { it + char.toUpperCase() }.toMutableList()
                    (withLower + withUpper).toMutableList()
                }
            }
        }

        return result
    }
}

println(Solution().letterCasePermutation("ad52") == listOf("ad52", "Ad52", "aD52", "AD52"))
println(Solution().letterCasePermutation("ab7c") == listOf("ab7c", "Ab7c", "aB7c", "AB7c", "ab7C", "Ab7C", "aB7C", "AB7C"))
