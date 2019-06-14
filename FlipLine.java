package lesson3;

public class FlipLine {
    private String line;

    public FlipLine(String line) {
        this.line = line;
    }

    public void flipCharacters() {
        HomeStack<Character> stack = new HomeStack<>();
        for (int i = 0; i < line.length(); i++) {
//            char ch = line.charAt(i);
            stack.push(line.charAt(i));
        }
        for (int i = 0; i < line.length(); i++) {
            System.out.print(stack.pop());
        }
        System.out.println();
    }
}
