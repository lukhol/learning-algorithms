/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

type Queue[T any] struct {
	values []T
}

func (queue *Queue[T]) Push(v T) {
	queue.values = append(queue.values, v)
}

func (queue *Queue[T]) Pop() T {
	popped := queue.values[0]
	queue.values = queue.values[1:len(queue.values)]
	return popped
}

func (queue *Queue[T]) Peek() T {
	return queue.values[0]
}

func NewQueue[T any]() Queue[T] {
	value := Queue[T]{values: []T{}}
	return value
}

func (queue *Queue[T]) IsEmpty() bool {
	return len(queue.values) == 0
}

func (queue *Queue[T]) Size() int {
	return len(queue.values)
}

func levelOrder(root *TreeNode) [][]int {
	result := make([][]int, 0)
    if root == nil {
        return result
    }
	queue := NewQueue[*TreeNode]()
	queue.Push(root)

	for !queue.IsEmpty() {
		size := queue.Size()
		levelResult := make([]int, 0)
		for i := 0; size > i; i++ {
			current := queue.Pop()
			levelResult = append(levelResult, current.Val)
			if current.Left != nil {
                queue.Push(current.Left)
            }
			if current.Right != nil {
                queue.Push(current.Right)
            }
		}
		result = append(result, levelResult)
	}

	return result
}
