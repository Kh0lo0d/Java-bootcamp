public class Cut implements Animals{
    private String name;
    private String Noise;
    private int o;


public Cut(String n,String no,int ol)
{
    name=n;
    Noise=no;
    o=ol;
}
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getNoise() {
        return Noise;
    }

    @Override
    public int getOld() {
        return o;
    }
}
