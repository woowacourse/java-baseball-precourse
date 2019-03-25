public class AnsChecker {
    // TODO
    public static void compareWith(String target){
        while(true){
            String input = InputResolver.getInput();
            int tcnt = Counter.countIncludedNum(input,target);
            int scnt = Counter.countMatchedNum(input,target);
            if(HintGiver.giveHint(tcnt,scnt)) break;
        }
    }
}
