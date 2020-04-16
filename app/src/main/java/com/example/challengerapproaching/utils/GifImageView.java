package com.example.challengerapproaching.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import java.io.IOException;
import java.io.InputStream;

public class GifImageView extends View {

  private InputStream inputStream;
  private Movie movie;
  private int width;
  private int height;
  private long start;

  public GifImageView(Context context, AttributeSet attrs) {
    super(context, attrs, 0);
  }

  private void init() {
    setFocusable(true);
    movie = Movie.decodeStream(inputStream);
    width = movie.width();
    height = movie.height();
    requestLayout();
  }

  @Override
  protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    setMeasuredDimension(width, height);
  }

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

  public void setGifImageUrl(String url) throws IOException {
    inputStream = new java.net.URL(url).openStream();
    init();
  }
}