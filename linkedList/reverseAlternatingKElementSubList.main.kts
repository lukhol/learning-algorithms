#!/usr/bin/env kotlin
@file:Repository("https://repo.maven.apache.org/maven2")
@file:DependsOn("junit:junit:4.13")
@file:DependsOn("org.assertj:assertj-core:3.11.1")

import ReverseAlternatingKElementSubList_main.Script.Companion.reverseAlternatingKElementSubList
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.JUnitCore

// Given the head of a LinkedList and a number `k`, reverse every
// alternating `k` sized sub-list starting from the head.
//
// If, in the end, you are left with a sub-list with less than
// `k` elements, reverse it too.

data class LinkedList(val value: Int, var next: LinkedList? = null) {
    override fun toString(): String {
        var current: LinkedList? = this
        var str = ""
        while (current != null) {
            str += "${current.value} -> "
            current = current.next
        }

        return str
    }
}

class Script {
    companion object {
        fun reverseAlternatingKElementSubList(head: LinkedList?, k: Int): LinkedList? {
            if (head?.next == null || k <= 1) return head
            var finalHead: LinkedList? = null
            var currentHead: LinkedList? = head
            var currentTail: LinkedList? = head
            var prev: LinkedList? = null

            var idx = 0

            var prevReversed = false
            while (currentHead != null) {
                if (++idx % k == 0) {
                    if (prevReversed) {
                        prev = currentTail
                        currentHead = currentTail?.next
                        currentTail = currentHead
                        prevReversed = false
                        continue
                    }

                    // Store new next for later (will be detached in next instr)
                    val rightListHead = currentTail?.next

                    // Detach
                    prev?.next = null
                    currentTail?.next = null

                    // Reverse
                    val middleListHeadAfterReversed = reverseLinkedList(currentHead)
                    val middleListTailAfterReversed = currentHead

                    if (finalHead == null) {
                        finalHead = middleListHeadAfterReversed
                    }

                    // Connect prev to middle
                    prev?.next = middleListHeadAfterReversed

                    // Connect middle to next
                    middleListTailAfterReversed.next = rightListHead

                    prev = middleListTailAfterReversed
                    currentTail = middleListTailAfterReversed.next
                    currentHead = currentTail

                    prevReversed = true
                } else {
                    currentTail = currentTail?.next
                }
            }

            return finalHead
        }

        private fun reverseLinkedList(head: LinkedList): LinkedList {
            var current: LinkedList? = head
            var prev: LinkedList? = null

            while(current != null) {
                val next = current?.next
                current?.next = prev
                prev = current
                current = next
            }

            return prev!!
        }
    }
}

class ScriptTests {
    class ReverseSubListTest {

        @Test
        fun test1() {
            // Given
            val head = buildLinkedList(1, 2, 3, 4, 5, 6, 7, 8)

            // When
            val result = reverseAlternatingKElementSubList(head, 2)

            // Then
            assertThat(result).isEqualTo(buildLinkedList(2, 1, 3, 4, 6, 5, 7, 8))
        }

        @Test
        fun test2() {
            // Given
            val head = buildLinkedList(1, 2, 3, 4, 5, 6, 7, 8)

            // When
            val result = reverseAlternatingKElementSubList(head, 3)

            // Then
            assertThat(result).isEqualTo(buildLinkedList(3, 2, 1, 4, 5, 6, 8, 7))
        }

        @Test
        fun test3() {
            // Given
            val head = buildLinkedList(1, 2, 3)

            // When
            val result = reverseAlternatingKElementSubList(head, 4)

            // Then
            assertThat(result).isEqualTo(buildLinkedList(3, 2, 1))
        }

        @Test
        fun test4() {
            // Given
            val head = buildLinkedList(1, 2, 3, 4, 5, 6, 7, 8)

            // When
            val result = reverseAlternatingKElementSubList(head, 3)

            // Then
            assertThat(result).isEqualTo(buildLinkedList(3, 2, 1, 4, 5, 6, 8, 7))
        }

        private fun buildLinkedList(vararg values: Int = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8)): LinkedList? {
            val first = LinkedList(values.first())
            var prev: LinkedList? = first
            for (i in 1 .. values.lastIndex) {
                prev?.next = LinkedList(values[i])
                prev = prev?.next
            }
            return first
        }
    }
}

fun runTests() {
    JUnitCore.runClasses(ScriptTests.ReverseSubListTest::class.java).run {
        val stats = "in ${runTime}ms: ran $runCount (ignored ${ignoreCount}), failed $failureCount"
        if (wasSuccessful()) {
            println("Self test complete $stats")
        } else {
            println("Self test failed $stats")
            failures.forEach(::println)
        }
    }
}

runTests()
