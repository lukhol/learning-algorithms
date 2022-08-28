#!/usr/bin/env kotlin
@file:Repository("https://repo.maven.apache.org/maven2")
@file:DependsOn("junit:junit:4.13")
@file:DependsOn("org.assertj:assertj-core:3.11.1")

import ReverseEveryKElementSubList_main.Script.Companion.reverseEveryKElementSubList
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.JUnitCore

// Given the head of a LinkedList and a number ‘k’, reverse every ‘k’
// sized sub-list starting from the head.
//
// If, in the end, you are left with a sub-list with
// less than ‘k’ elements, reverse it too.

// T: O(n)
// S: O(1)
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
        // I: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8, k = 3
        // O:
        fun reverseEveryKElementSubList(head: LinkedList?, k: Int): LinkedList? {
            if (k == 0 || k == 1) return head
            var finalHead: LinkedList? = null
            var prevTail: LinkedList? = null

            var currentHead: LinkedList? = head
            var currentTail: LinkedList? = head

            var counter = 0
            while (currentHead != null) {
                if (++counter % k == 0) {
                    val nextHead = currentTail?.next

                    // Detach current sublist
                    prevTail?.next = null
                    currentTail?.next = null

                    val headAfterReversed = reverseLinkedList(currentHead)
                    val tailAfterReversed = currentHead

                    // Store finalHead that should be returned
                    if (finalHead == null) {
                        finalHead = headAfterReversed
                    }

                    // Connect previous list to current
                    prevTail?.next = headAfterReversed
                    prevTail = tailAfterReversed

                    // Connect current to next
                    tailAfterReversed.next = nextHead

                    currentHead = nextHead
                    currentTail = currentHead
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
        fun lastIsNotFull() {
            // Given
            val head = buildLinkedList()

            // When
            val result = reverseEveryKElementSubList(head, 3)

            // Then
            assertThat(result).isEqualTo(buildLinkedList(3, 2, 1, 6, 5, 4, 8, 7))
        }

        @Test
        fun allAreFull() {
            // Given
            val head = buildLinkedList(1, 2, 3, 4, 5, 6, 7, 8, 9)

            // When
            val result = reverseEveryKElementSubList(head, 3)

            // Then
            assertThat(result).isEqualTo(buildLinkedList(3, 2, 1, 6, 5, 4, 9, 8, 7))
        }

        @Test
        fun kIsEqualToListSize() {
            // Given
            val head = buildLinkedList(1, 2, 3, 4)

            // When
            val result = reverseEveryKElementSubList(head, 4)

            // Then
            assertThat(result).isEqualTo(buildLinkedList(4, 3, 2, 1))
        }

        @Test
        fun kIsBiggerThanList() {
            // Given
            val head = buildLinkedList(1, 2, 3)

            // When
            val result = reverseEveryKElementSubList(head, 4)

            // Then
            assertThat(result).isEqualTo(buildLinkedList(3, 2, 1))
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
