#!/usr/bin/envkotlin kotlin
// https://leetcode.com/problems/generate-parentheses/solution/

// For a given number ‘N’, write a function to generate all combination of ‘N’ pairs of balanced parentheses.

class Solution {
    class BracketsCount(var opening: Int, var closing: Int, var value: String)
    
    fun generateParenthesis(n: Int): List<String> {
        var result = arrayListOf<String>()
        
        fun dfs(leftCount: Int, counter: BracketsCount) {
            if (counter.value.length == n * 2) {
                result.add(counter.value)
                return
            }
            
            if (counter.opening < n) {
                counter.opening += 1
                counter.value += "("
                dfs(leftCount + 1, counter)
                counter.opening -= 1
                counter.value = counter.value.dropLast(1)
            }
            if (counter.opening > counter.closing) {
                counter.closing += 1
                counter.value += ")"
                dfs(leftCount + 1, counter)
                counter.closing -= 1
                counter.value = counter.value.dropLast(1)
            }
    }
        
        dfs(n, BracketsCount(0, 0, ""))
        return result
    }
}

    println(Solution().generateParenthesis(3) == listOf("((()))", "(()())", "(())()", "()(())", "()()()"))
