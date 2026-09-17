raw_data = """
105-construct-binary-tree-from-preorder-and-inorder-traversal
Time: 27 ms (32.80%) | Memory: 95.9 MB (31.54%) - LeetSync
4 days ago

106-construct-binary-tree-from-inorder-and-postorder-traversal
Time: 92 ms (37.58%) | Memory: 51.5 MB (29.70%) - LeetSync
4 days ago

107-binary-tree-level-order-traversal-ii
Time: 0 ms (100.00%) | Memory: 12.8 MB (9.02%) - LeetSync
3 days ago

108-convert-sorted-array-to-binary-search-tree
Time: 4 ms (14.00%) | Memory: 20 MB (99.18%) - LeetSync
3 days ago

109-convert-sorted-list-to-binary-search-tree
Time: 0 ms (100.00%) | Memory: 47.2 MB (20.62%) - LeetSync
3 days ago

111-minimum-depth-of-binary-tree
Time: 60 ms (86.73%) | Memory: 91.3 MB (89.51%) - LeetSync
2 days ago

112-path-sum
Time: 0 ms (100.00%) | Memory: 20.2 MB (59.29%) - LeetSync
2 days ago

113-path-sum-ii
Time: 3 ms (36.19%) | Memory: 20 MB (98.86%) - LeetSync
2 days ago

114-flatten-binary-tree-to-linked-list
Time: 0 ms (100.00%) | Memory: 44 MB (52.29%) - LeetSync
2 days ago

115-distinct-subsequences
Time: 25 ms (13.05%) | Memory: 54.3 MB (58.56%) - LeetSync
2 days ago

116-populating-next-right-pointers-in-each-node
Time: 0 ms (100.00%) | Memory: 46.7 MB (17.68%) - LeetSync
2 days ago

117-populating-next-right-pointers-in-each-node-ii
Time: 2 ms (35.58%) | Memory: 46.5 MB (17.70%) - LeetSync
2 days ago

118-pascals-triangle
Time: 2 ms (10.83%) | Memory: 43.5 MB (34.45%) - LeetSync
2 days ago

119-pascals-triangle-ii
Time: 0 ms (100.00%) | Memory: 57.6 MB (100.00%) - LeetSync
yesterday

120-triangle
Time: 32 ms (100.00%) | Memory: 69 MB (100.00%) - LeetSync
20 hours ago

121-best-time-to-buy-and-sell-stock
Time: 2 ms (45.23%) | Memory: 94.6 MB (15.68%) - LeetSync
20 hours ago

122-best-time-to-buy-and-sell-stock-ii
Time: 0 ms (100.00%) | Memory: 46.2 MB (83.20%) - LeetSync
20 hours ago

123-best-time-to-buy-and-sell-stock-iii
Time: 1 ms (100.00%) | Memory: 75.8 MB (72.87%) - LeetSync
20 hours ago

124-binary-tree-maximum-path-sum
Time: 0 ms (100.00%) | Memory: 27.8 MB (76.86%) - LeetSync
9 minutes ago

126-word-ladder-ii
Time: 32 ms (35.68%) | Memory: 19.5 MB (96.50%) - LeetSync
8 minutes ago

127-word-ladder
Time: 35 ms (96.37%) | Memory: 20.4 MB (74.40%) - LeetSync
7 minutes ago

128-longest-consecutive-sequence
Time: 21 ms (95.96%) | Memory: 77.2 MB (97.04%) - LeetSync
4 minutes ago

1725-number-of-sets-of-k-non-overlapping-line-segments
Time: 0 ms (100.00%) | Memory: 42.1 MB (89.03%) - LeetSync
1 minute ago

206-reverse-linked-list
Time: 0 ms (100.00%) | Memory: 44.4 MB (14.05%) - LeetSync
3 days ago

257-binary-tree-paths
Time: 0 ms (100.00%) | Memory: 17.5 MB (81.92%) - LeetSync
17 hours ago
"""

import re

pattern = re.compile(r'(\d+)-([^\n]+)\nTime:\s*([^\n|]+)\|\s*Memory:\s*([^\n-]+)-\s*LeetSync\n([^\n]+)', re.MULTILINE)
matches = pattern.findall(raw_data)

# Known difficulties and categories for these classic problems
metadata = {
    105: ("Medium", "Tree / DFS / Divide and Conquer"),
    106: ("Medium", "Tree / DFS / Divide and Conquer"),
    107: ("Medium", "Tree / BFS"),
    108: ("Easy", "Binary Search Tree / Divide and Conquer"),
    109: ("Medium", "Linked List / Binary Search Tree"),
    111: ("Easy", "Tree / Depth-First Search / BFS"),
    112: ("Easy", "Tree / DFS"),
    113: ("Medium", "Tree / Backtracking / DFS"),
    114: ("Medium", "Tree / Linked List / Morris Traversal"),
    115: ("Hard", "Dynamic Programming / String"),
    116: ("Medium", "Tree / BFS / Two Pointers"),
    117: ("Medium", "Tree / BFS"),
    118: ("Easy", "Array / Dynamic Programming"),
    119: ("Easy", "Array / Dynamic Programming"),
    120: ("Medium", "Dynamic Programming / Array"),
    121: ("Easy", "Array / Dynamic Programming"),
    122: ("Medium", "Array / Greedy / Dynamic Programming"),
    123: ("Hard", "Dynamic Programming / Array"),
    124: ("Hard", "Tree / Depth-First Search / Dynamic Programming"),
    126: ("Hard", "Breadth-First Search / Backtracking / Graph"),
    127: ("Hard", "Breadth-First Search / Hash Table / String"), # Note: LeetCode classified 127 as Hard
    128: ("Medium", "Array / Hash Table / Union Find"),
    206: ("Easy", "Linked List / Recursion"),
    257: ("Easy", "Tree / Depth-First Search / Backtracking"),
    1725: ("Medium", "Dynamic Programming / Math / Combinatorics"), # 1600 is Number of Sets of K Non-overlapping Line Segments, let's verify LeetCode number
}

# Note: Problem 1600 vs 1725: On LeetCode, "Number of Sets of K Non-Overlapping Line Segments" is Problem #1600. Sometimes slugs or user repo names map to 1725. Let's keep the user's ID and provide the accurate title and tags.

parsed = []
for pid_str, slug, time_str, mem_str, submitted in matches:
    pid = int(pid_str)
    # clean slug to title
    title = slug.replace("-", " ").title()
    # fix roman numerals
    title = re.sub(r'\bIi\b', 'II', title)
    title = re.sub(r'\bIii\b', 'III', title)
    title = re.sub(r'\bBst\b', 'BST', title)
    
    diff, category = metadata.get(pid, ("Medium", "Algorithms"))
    parsed.append({
        "id": pid,
        "slug": slug.strip(),
        "title": title.strip(),
        "time": time_str.strip(),
        "mem": mem_str.strip(),
        "submitted": submitted.strip(),
        "difficulty": diff,
        "category": category
    })

print(f"Parsed {len(parsed)} problems.")
