package com.example.challengerapproaching.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import java.io.IOException;
import java.io.InputStream;

/********************************************************************
 * Class that creates the GifImageViews in our Character pages.
 * This class was trimmed from a blog post listed in our resources.
 * Edited, trimmed, and commented by Tristan Kingsley
 *******************************************************************/

public class GifImageView extends View {

  //Input stream of the source
  private InputStream inputStream;

  //Movie object decoded from input stream
  private Movie movie;

  //Movie object's width
  private int width;

  //Movie object's height
  private int height;

  //Keeps track of time to keep movie playing
  private long start;

  /********************************************************************
   * This constructor calls the view class constructor.
   * @param context the context it's being set in
   * @param attrs the attribute set applied to the object
   *******************************************************************/
  public GifImageView(Context context, AttributeSet attrs) {
    super(context, attrs, 0);
  }

  private void init() {
    setFocusable(true);
    movie = Movie.decodeStream(inputStream);
    width = movie.width();
    height = movie.height();
    start = 0;
    requestLayout();
  }

  /********************************************************************
   * This method is called when new measurements are needed for a gif.
   * @param widthMeasureSpec the new width of the gif
   * @param heightMeasureSpec the new height of the gif
   *******************************************************************/
  @Override
  protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    setMeasuredDimension(width, height);
  }

  /********************************************************************
   * This method is called when the app generates a content view with
   * this object. This sets the movie to update in sync with our time.
   * @param canvas Canvas object the gif will be displayed on
   *******************************************************************/
  @Override
  protected void onDraw(Canvas canvas) {
    long now = SystemClock.uptimeMillis();

    if (start == 0) {
      start = now;
    }

    if (movie != null) {

      int duration = movie.duration();
      if (duration == 0) {
        duration = 1000;
      }

      int relTime = (int) ((now - start) % duration);

      movie.setTime(relTime);

      movie.draw(canvas, 0, 0);
      invalidate();
    }
  }

  /********************************************************************
   * This sets the view's input stream as the stream from the url given
   * It then re-initializes the movie, resetting the size, and starting
   * the gif from the beginning.
   * @param url string of the url of the gif to be displayed
   *******************************************************************/
  public void setGifImageUrl(String url) throws IOException {
    inputStream = new java.net.URL(url).openStream();
    init();
  }
}