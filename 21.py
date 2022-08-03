



def helper(nums, currentLevel, output):
    if currentLevel == len(nums):
        copyList = nums[:]
        output.append(copyList)
    for i in range(currentLevel, len(nums)):
        nums[i], nums[currentLevel] = nums[currentLevel], nums[i]
        helper(nums, currentLevel + 1, output)
        nums[currentLevel], nums[i] = nums[i], nums[currentLevel]

nums = [1, 2, 3]
level = 0
output = []
helper(nums,level, output)
print(output)
