package baekjoon;
class Example{
    int example = 0;
    void ex(){
        int example= 10;
        System.out.println(example);
        System.out.println(this.example);
    }
}
public class b10989 {
    public static void main(String[] args) {
        Example example = new Example();
        example.ex();
    }
}
