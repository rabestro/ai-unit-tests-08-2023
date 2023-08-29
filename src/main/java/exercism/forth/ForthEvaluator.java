package exercism.forth;


import java.util.List;

class ForthEvaluator {
    private final ForthEngine forthEngine = new ForthEngine();

    public List<Integer> evaluateProgram(Iterable<String> commands) {
        commands.forEach(forthEngine);
        return forthEngine.get();
    }
}
