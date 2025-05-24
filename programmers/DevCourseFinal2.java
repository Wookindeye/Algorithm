package programmers;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DevCourseFinal2 {
    public int solution(String s) {
        int answer = 0;
        for(int i = 0; i < s.length(); i++){
            StringBuffer sb = new StringBuffer(s);
            sb.append(s.substring(0,i));
            sb.delete(0,i);
            Stack<Character> st = new Stack<>();
            for(int j = 0; j < s.length(); j++){
                char c = s.charAt(j);
                if(c == '[' || c == '{' || c == '(')
                    st.push(c);
                else if(!st.isEmpty() && c == ']' && st.peek()=='[')
                    st.pop();
                else if(!st.isEmpty() && c == '}' && st.peek()=='{')
                    st.pop();
                else if(!st.isEmpty() && c == ')' && st.peek()=='(')
                    st.pop();
            }
            if(st.isEmpty()) answer++;
            System.out.println(s + " : " + st.isEmpty());
        }
        return answer;
    }

}
