package homework4_5_7.model;

public class TV extends Electronics {
    private boolean isColorTV;
    private boolean isFullHD;

    @Override
    public String print() {
        return super.print() + "Color = '" + isColorTV() + '\'' + "\n" +
                "Full HD = " + isFullHD() + "\n";
    }

    public boolean isColorTV() {
        return isColorTV;
    }

    public void setColorTV(boolean colorTV) {
        isColorTV = colorTV;
    }

    public boolean isFullHD() {
        return isFullHD;
    }

    public void setFullHD(boolean fullHD) {
        isFullHD = fullHD;
    }
}

