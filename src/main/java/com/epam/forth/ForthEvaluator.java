package com.epam.forth;


import java.util.List;

class ForthEvaluator {
    private final ForthEngine forthEngine = new ForthEngine();

    public List<Integer> evaluateProgram(List<String> commands) {
        commands.forEach(forthEngine);
        return forthEngine.get();
    }
}
