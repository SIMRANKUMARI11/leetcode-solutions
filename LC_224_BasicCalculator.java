class Solution {
    public int calculate(String s) {
        int ans=0;
        int num=0;
        int sign=1;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch>='0' && ch<='9'){
                num=num*10+(ch-'0');
            }
            else if(ch == '+'){
                ans=ans+sign*num;
                num=0;
                sign=1;
            }
            else if(ch == '-'){
                ans=ans+sign*num;
                num=0;
                sign=-1;
            }
            else if(ch == '('){
                st.push(ans);
                st.push(sign);
                ans=0;
                sign=1;
            }
            else if(ch == ')'){
                ans=ans+sign*num;
                num=0;
                int oldSign=st.pop();
                int oldAns=st.pop();
                ans=oldAns+oldSign*ans;
            }
              
           
        }
        ans=ans+sign*num;
        return ans;
    }
}
