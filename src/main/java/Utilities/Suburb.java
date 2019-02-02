package Utilities;

public class Suburb {
    private String suburbName;

    private String serviceCenter;

    public String getSuburbName ()
    {
        return suburbName;
    }

    public void setSuburbName (String suburbName)
    {
        this.suburbName = suburbName;
    }

    public String getServiceCenter ()
    {
        return serviceCenter;
    }

    public void setServiceCenter (String serviceCenter)
    {
        this.serviceCenter = serviceCenter;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [suburbName = "+suburbName+", serviceCenter = "+serviceCenter+"]";
    }
}
