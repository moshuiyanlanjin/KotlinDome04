package JavaDemo.数据结构.栈和队列;

public class Solution {
    public boolean isValid(String s){
        ArrayStack<Character> tsck = new ArrayStack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{'){
                tsck.push(c);
            }else{
                if (tsck.isEmpty())
                    return false;
                else{
                    Character pop = tsck.pop();
                    if(pop == '(' && c != ')'){
                        return false;
                    }else if(pop =='{' && c != '}'){
                        return false;
                    }else if(pop == '[' && c != ']'){
                        return false;
                    }
                }
            }
        }
        return tsck.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println((new Solution()).isValid("(){}[]"));
    }
}
