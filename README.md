# LeetCode Progress Log

Collection of solved LeetCode problems covering Binary Trees, Binary Search Trees, Dynamic Programming, Arrays, and Linked Lists.

---

## Solved Problems

| # | Problem Name | Difficulty | Solution Pattern / Core Idea | Time | Memory |
|:---:|:---|:---:|:---|:---:|:---:|
| 105 | [Construct Binary Tree from Preorder and Inorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/) | Medium | Recursion + Hash Map for index lookups | 27 ms (32.80%) | 95.9 MB (31.54%) |
| 106 | [Construct Binary Tree from Inorder and Postorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/) | Medium | Recursion (root from postorder end) + Hash Map | 92 ms (37.58%) | 51.5 MB (29.70%) |
| 107 | [Binary Tree Level Order Traversal II](https://leetcode.com/problems/binary-tree-level-order-traversal-ii/) | Medium | BFS (Queue) with reverse level collection | 0 ms (100.00%) | 12.8 MB (9.02%) |
| 108 | [Convert Sorted Array to Binary Search Tree](https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/) | Easy | Divide & Conquer (pick middle element as root) | 4 ms (14.00%) | 20.0 MB (99.18%) |
| 109 | [Convert Sorted List to Binary Search Tree](https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/) | Medium | Fast & Slow pointers (find mid) / In-order simulation | 0 ms (100.00%) | 47.2 MB (20.62%) |
| 111 | [Minimum Depth of Binary Tree](https://leetcode.com/problems/minimum-depth-of-binary-tree/) | Easy | BFS early exit / DFS handling skewed trees | 60 ms (86.73%) | 91.3 MB (89.51%) |
| 112 | [Path Sum](https://leetcode.com/problems/path-sum/) | Easy | DFS leaf check with remainder subtraction | 0 ms (100.00%) | 20.2 MB (59.29%) |
| 113 | [Path Sum II](https://leetcode.com/problems/path-sum-ii/) | Medium | Backtracking / DFS with current path state | 3 ms (36.19%) | 20.0 MB (98.86%) |
| 114 | [Flatten Binary Tree to Linked List](https://leetcode.com/problems/flatten-binary-tree-to-linked-list/) | Medium | Morris traversal / Reverse Post-order DFS | 0 ms (100.00%) | 44.0 MB (52.29%) |
| 115 | [Distinct Subsequences](https://leetcode.com/problems/distinct-subsequences/) | Hard | 2D Dynamic Programming (prefix matching) | 25 ms (13.05%) | 54.3 MB (58.56%) |
| 116 | [Populating Next Right Pointers in Each Node](https://leetcode.com/problems/populating-next-right-pointers-in-each-node/) | Medium | Level order using established `next` pointers | 0 ms (100.00%) | 46.7 MB (17.68%) |
| 117 | [Populating Next Right Pointers in Each Node II](https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/) | Medium | BFS with dummy head tracking next level | 2 ms (35.58%) | 46.5 MB (17.70%) |
| 118 | [Pascal's Triangle](https://leetcode.com/problems/pascals-triangle/) | Easy | Iterative generation via previous row sums | 2 ms (10.83%) | 43.5 MB (34.45%) |
| 119 | [Pascal's Triangle II](https://leetcode.com/problems/pascals-triangle-ii/) | Easy | 1D DP array updating backwards | 0 ms (100.00%) | 57.6 MB (100.00%) |
| 120 | [Triangle](https://leetcode.com/problems/triangle/) | Medium | Bottom-up DP (in-place row reduction) | 32 ms (100.00%) | 69.0 MB (100.00%) |
| 121 | [Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/) | Easy | One-pass tracking running minimum price | 2 ms (45.23%) | 94.6 MB (15.68%) |
| 122 | [Best Time to Buy and Sell Stock II](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/) | Medium | Greedy (accumulate every positive slope) | 0 ms (100.00%) | 46.2 MB (83.20%) |
| 123 | [Best Time to Buy and Sell Stock III](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/) | Hard | State Machine DP (4 states: buy1, sell1, buy2, sell2) | 1 ms (100.00%) | 75.8 MB (72.87%) |
| 206 | [Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/) | Easy | Iterative pointer reversal (prev, curr, next) | — | — |

---

## Category Breakdown

* **Binary Trees & BSTs:** 105, 106, 107, 108, 109, 111, 112, 113, 114, 116, 117
* **Dynamic Programming:** 115, 118, 119, 120, 123
* **Greedy / Array Scans:** 121, 122
* **Linked Lists:** 206
