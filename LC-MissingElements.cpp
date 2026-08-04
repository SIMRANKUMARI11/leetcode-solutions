class Solution {
public:
    vector<int> findMissingElements(vector<int>& nums) {
        int mn=nums[0],mx=nums[0];
        for(int x:nums){
            mn=min(mn,x);
            mx=max(mx,x);
        }
        unordered_set<int> st(nums.begin(), nums.end());
        vector<int> ans;
        for(int i=mn+1;i<mx;i++){
            if(st.count(i)==0){
                ans.push_back(i);
            }
        }
        return ans;
    }
};
