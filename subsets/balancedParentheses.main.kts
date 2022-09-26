#!/usr/bin/envkotlin kotlin
// https://leetcode.com/problems/generate-parentheses/solution/

// For a given number ‘N’, write a function to generate all combination of ‘N’ pairs of balanced parentheses.

class Solution {
    class BracketsCount(var opening: Int, var closing: Int, var value: String)
    
    fun generateParenthesis(n: Int): List<String> {
        var result = arrayListOf<String>()
        
        fun dfs(used: Int, opening: Int, closing: Int, sb: StringBuilder) {
            if (sb.length == n * 2) {
                result.add(sb.toString())
                return
            }
            
            if (opening < n) {
                sb.append('(')
                dfs(used + 1, opening + 1, closing, sb)
                sb.deleteCharAt(sb.length - 1)
            }
            if (opening > closing) {
                sb.append(')')
                dfs(used + 1, opening, closing + 1, sb)
                sb.deleteCharAt(sb.length - 1)
            }
    }
        
        dfs(n, 0, 0, StringBuilder())
        return result
    }
}

println(Solution().generateParenthesis(3) == listOf("((()))", "(()())", "(())()", "()(())", "()()()"))
