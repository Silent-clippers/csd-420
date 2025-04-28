// Keanu Foltz module 8.2 4/27/25
// This runs three threads of alphabetical characters, numbers, and symbols
public class KeanuThreeThreads {
    public static void main(String[] args) {
        AlphaThread alphaThread = new AlphaThread();
        alphaThread.start();
        NumThread numThread = new NumThread();
        numThread.start();
        SymbolThread symbolThread = new SymbolThread();
        symbolThread.start();
    }
    public static class AlphaThread extends Thread{
        char[] alpha = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        int loops = 0;
        public void run(){
            while(loops < 10000){
                System.out.print(alpha[(int)(Math.random()*alpha.length)]);
                loops++;
            }
        }
    }

    public static class NumThread extends Thread{
        char[] nums = {'0','1','2','3','4','5','6','7','8','9'};
        int loops = 0;
        public void run(){
            while(loops < 10000){
                System.out.print(nums[(int)(Math.random()*nums.length)]);
                loops++;
            }
        }
    }

    public static class SymbolThread extends Thread{
        char[] symbols = {'!','#','$','&','@','%'};
        int loops = 0;
        public void run(){
            while(loops < 10000){
                System.out.print(symbols[(int)(Math.random()*symbols.length)]);
                loops++;
            }
        }
    }
}