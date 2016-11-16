package tuhocandroid.thuchanhdanhbadienthoai.model;

/**
 * Created by HI on 11/9/2016.
 */
public class Contact {
    private boolean ismale;
    private String mName;
    private String mNumber;

    public Contact(boolean ismale, String mName, String mNumber) {
        this.ismale = ismale;
        this.mName = mName;
        this.mNumber = mNumber;
    }

    public boolean ismale() {
        return ismale;
    }

    public void setIsmale(boolean ismale) {
        this.ismale = ismale;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmNumber() {
        return mNumber;
    }

    public void setmNumber(String mNumber) {
        this.mNumber = mNumber;
    }
}
