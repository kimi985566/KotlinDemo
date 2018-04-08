package chapter4.tailrecursive

/**
 *
 * 尾递归优化
 *
 * 递归的一种特殊形式
 * 调用自身后无其他操作
 * tailrec关键字提示编译器尾递归优化
 * 尾递归与迭代的关系
 *
 * */


data class ListNode(val value: Int, var next: ListNode? = null)

tailrec fun findListNode(head: ListNode?, value: Int): ListNode? {
    head ?: return null
    if (head.value == value) return head
    return findListNode(head.next, value)
}

fun main(args: Array<String>) {
    val MAX = 1000000
    val head = ListNode(0)
    var p = head
    for (i in 1..MAX) {
        p.next = ListNode(i)
        p = p.next!!
    }

    println(findListNode(head, MAX - 1000)?.value)
}

data class TreeNode(val value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

}

fun findTreeNode(root: TreeNode?, value: Int): TreeNode? {
    root ?: return null
    if (root.value == value) return root
    return findTreeNode(root.left, value) ?: findTreeNode(root.right, value)

}