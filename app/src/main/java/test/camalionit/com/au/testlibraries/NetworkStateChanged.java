package test.camalionit.com.au.testlibraries;

/**
 * Created by fredyrincon on 14/12/2014.
 */
public class NetworkStateChanged     {

    private boolean  mIsInternetConnected;

    public NetworkStateChanged(boolean isInternetConnected) {
        this.mIsInternetConnected = isInternetConnected;
    }

    public boolean isInternetConnected() {
        return this.mIsInternetConnected;
    }
}
