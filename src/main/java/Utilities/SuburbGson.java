package Utilities;

public class SuburbGson {
    private Suburb[] Suburb;

    public Suburb[] getSuburb ()
    {
        return Suburb;
    }

    public void setSuburb (Suburb[] Suburb)
    {
        this.Suburb = Suburb;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Suburb = "+Suburb+"]";
    }
}
