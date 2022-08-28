#!/usr/bin/env kotlin
@file:Repository("https://repo.maven.apache.org/maven2")
@file:DependsOn("junit:junit:4.13")
@file:DependsOn("org.assertj:assertj-core:3.11.1")

import ReverseSubList_main.Script.Companion.reverseLinkedListInPositions
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.JUnitCore

// Given the head of LinkedList and two positions `p` and `q`, reverse the LinkedList from position `p` to `q`

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
        // I: 1 -> 2 -> 3 -> 4 -> 5, p = 1, q = 3
        // O: 3 -> 2 -> 1 -> 4 -> 5
        fun reverseLinkedListInPositions(head: LinkedList?, p: Int, q: Int): LinkedList? {
            if (p == q) return head

            var currentPos = 1
            var middleListHead = head
            var prev: LinkedList? = null

            while (currentPos++ != p) {
                prev = middleListHead
                middleListHead = middleListHead?.next
                if (middleListHead == null) return head
            }

            var middleListTail = middleListHead
            for (i in 1..(q - p)) {
                middleListTail = middleListTail?.next
            }

            // Detach inner list
            val endListHead = middleListTail?.next
            prev?.next = null
            middleListTail?.next = null

            val middleHeadAfterReverse = reverseLinkedList(middleListHead!!)
            if (prev == null) {
                head?.next = endListHead
                return middleHeadAfterReverse
            }

            prev.next = middleHeadAfterReverse
            middleListHead.next = endListHead

            return head
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
        fun inTheMiddle() {
            // Given
            val head = buildLinkedList()

            // When
            val result = reverseLinkedListInPositions(head, 2, 4)

            // Then
            assertThat(result).isEqualTo(buildLinkedList(1, 4, 3, 2, 5))
        }

        @Test
        fun fromTheBeginning() {
            // Given
            val head = buildLinkedList()

            // When
            val result = reverseLinkedListInPositions(head, 1, 4)

            // Then
            assertThat(result).isEqualTo(buildLinkedList(4, 3, 2, 1, 5))
        }

        @Test
        fun qIsBiggerThanListSize() {
            // Given
            val head = buildLinkedList()

            // When
            val result = reverseLinkedListInPositions(head, 1, 10)

            // Then
            assertThat(result).isEqualTo(buildLinkedList(5, 4, 3, 2, 1))
        }

        @Test
        fun pAndQAreBiggerThanList() {
            // Given
            val head = buildLinkedList()

            // When
            val result = reverseLinkedListInPositions(head, 10, 11)

            // Then
            assertThat(result).isEqualTo(buildLinkedList(1, 2, 3, 4, 5))
        }

        private fun buildLinkedList(vararg values: Int = intArrayOf(1, 2, 3, 4, 5)): LinkedList? {
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
