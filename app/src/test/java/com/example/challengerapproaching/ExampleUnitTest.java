package com.example.challengerapproaching;

import com.example.challengerapproaching.characters.DonkeyKong;
import com.example.challengerapproaching.utils.GifImageView;

import org.junit.Test;

import java.io.IOException;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    DonkeyKong donkeyKong = new DonkeyKong();
    GifImageView gifImageView = donkeyKong.findViewById(R.id.GifImageView);

    @Test(expected = IOException.class)
    public void gifViewSource() throws IOException {
        gifImageView.setGifImageUrl("fries");
    }

    @Test
    public void gifViewGoodSource() throws IOException {
        DonkeyKong donkeyKong = new DonkeyKong();
        GifImageView gifImageView = donkeyKong.findViewById(R.id.GifImageView);
        gifImageView.setGifImageUrl("https://ultimateframedata.com/hitboxes/luigi/LuigiFTiltDown.gif");
    }


}