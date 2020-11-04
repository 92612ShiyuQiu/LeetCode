#124. binary tree maximum path sum
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxPathSum(self, root: TreeNode) -> int:
        def maxGain(nd):
            nonlocal maxSum
            if not nd:
                return 0
            
            leftmg = max(maxGain(nd.left), 0)
            rightmg = max(maxGain(nd.right), 0)
            
            price_newpath = leftmg+rightmg+nd.val
            maxSum = max(maxSum, price_newpath)
            
            return nd.val + max(leftmg, rightmg)
        
        maxSum = float('-inf')
        maxGain(root)
        return maxSum