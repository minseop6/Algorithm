function twoSum(nums: number[], target: number): number[] {
    let result = [];
    
    for (let i = 0; i < nums.length - 1; i++) {
        for (let j = i + 1; j < nums.length; j++) {
            if (nums[i] + nums[j] === target) {
                result = [i, j];
            }
        }
    }
    
    if (result.length > 0) {
        return result;
    }
};

twoSum([2,7,11,15], 9);