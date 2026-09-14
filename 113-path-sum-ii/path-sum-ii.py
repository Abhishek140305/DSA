class Solution:

    def dfs(self, root, path, paths, target):
        if root is None:
            return

        path.append(root.val)

        if root.left is None and root.right is None:
            if sum(path) == target:
                paths.append(path.copy())

            path.pop()
            return

        self.dfs(root.left, path, paths, target)
        self.dfs(root.right, path, paths, target)

        path.pop()

    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        paths = []

        self.dfs(root, [], paths, targetSum)

        return paths