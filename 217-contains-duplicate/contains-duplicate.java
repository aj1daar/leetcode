class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> mySet = new HashSet<Integer>();
        for (int i: nums) mySet.add(i);
        if (mySet.size() >= nums.length) return false;
        else return true;

    }
}