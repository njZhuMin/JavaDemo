public class Context {
    private State state;

    public Context(State state) {
        this.state = state;
    }
    public State getState() {
        return state;
    }
    public void getState(State state) {
        this.state = state;
    }

    public void method() {
        if(state.getValue().equals("state1"))
            state.method1();
        else
            state.method2();
    }
}
