public abstract class Bridge {
    /* 持有Sourceable实例 */
    private Sourceable source;

    public void method(){
        source.method();
    }
    public Sourceable getSource() {
        return source;
    }
    public void setSource(Sourceable source) {
        this.source = source;
    }
}