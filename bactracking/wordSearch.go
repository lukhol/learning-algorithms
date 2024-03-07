package main

import (
	"fmt"
)

type void struct{}

type Index struct {
	y int
	x int
}

func exist(board [][]byte, word string) bool {
	visited := make(map[Index]void)

	var traverse func(int, int, int) bool
	traverse = func(y, x int, idx int) bool {
		// Found end of word - we can break the recursion
		if idx == len(word) {
			return true
		}

		// Return early on out of bounds
		if 0 > x || 0 > y || len(board)-1 < y || len(board[y])-1 < x {
			return false
		}

		// Return early if already visited
		_, ok := visited[Index{y, x}]
		if ok {
			return false
		}

		// Next letter is incorrect, we can return
		if word[idx] != board[y][x] {
			return false
		}

		// Mark as visited
		visited[Index{y, x}] = void{}

		left := traverse(y, x-1, idx+1)
		right := traverse(y, x+1, idx+1)
		top := traverse(y-1, x, idx+1)
		bottom := traverse(y+1, x, idx+1)

		// Unmark as visited
		delete(visited, Index{y, x})

		return left || right || top || bottom
	}

	for y := range board {
		for x := range board[y] {
			if traverse(y, x, 0) {
				return true
			}
		}
	}

	return false
}

func main() {
	result := exist([][]byte{
		{'A', 'B', 'C', 'E'},
		{'S', 'F', 'C', 'S'},
		{'A', 'D', 'E', 'E'},
	}, "ABCCED")
	fmt.Println(result)
}
