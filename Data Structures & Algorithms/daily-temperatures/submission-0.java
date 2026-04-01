class temperature{
    int temp;
    int index;
    public temperature(int temp, int index){
        this.temp = temp;
        this.index = index;
    }
}
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<temperature> stack = new Stack<>();
        int[] res = new int[temperatures.length];

        for(int i  = 0; i < temperatures.length; i++){
            while(!stack.isEmpty() && (temperatures[i] > stack.peek().temp)){
                temperature temp = stack.pop();
                res[temp.index] = (i-temp.index);
            }
            stack.push(new temperature(temperatures[i],i));
        }
        return res;
    }
}
