#!/usr/bin/envkotlin kotlin
// https://leetcode.com/problems/generate-parentheses/solution/
// For a given number ‘N’, write a function to generate all combination of ‘N’ pairs of balanced parentheses.

import java.util.*

class Solution {
    data class BracketsCount(val opening: Int, val closing: Int, val value: String)
    
    fun generateParenthesisBfs(n: Int): List<String> {
        val result = arrayListOf<String>()
        val queue = LinkedList<BracketsCount>()
        queue.add(BracketsCount(0, 0, ""))
        
        while (queue.isNotEmpty()) {
            val current = queue.poll()
            if (current.value.length == n * 2) {
                result.add(current.value)    
                continue
            }
            
            if (current.opening < n) {
                queue.add(BracketsCount(current.opening + 1, current.closing, current.value + "("))
            }
            
            if (current.opening > current.closing && current.closing < n) {
                queue.add(BracketsCount(current.opening, current.closing + 1, current.value + ")"))
            }
        }
        
        return result
    }
    
    fun generateParenthesisDfs(n: Int): List<String> {
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

println(Solution().generateParenthesisDfs(3) == listOf("((()))", "(()())", "(())()", "()(())", "()()()"))
println(Solution().generateParenthesisBfs(3) == listOf("((()))", "(()())", "(())()", "()(())", "()()()"))
