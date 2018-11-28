package com.reactlibrary;

import java.util.HashMap;
import java.util.Map;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

import android.widget.Toast;

//https://facebook.github.io/react-native/docs/native-modules-android

public class ReactLibraryModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;  
  private static final String DURATION_SHORT_KEY = "SHORT", DURATION_LONG_KEY = "LONG", E_LAYOUT_ERROR = "E_LAYOUT_ERROR";

  public ReactLibraryModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "ReactModule";
  }
  
  @Override
  public Map<String, Object> getConstants() {
    final Map<String, Object> constants = new HashMap<>();
    constants.put(DURATION_SHORT_KEY, Toast.LENGTH_SHORT);
    constants.put(DURATION_LONG_KEY, Toast.LENGTH_LONG);
    return constants;
  }
  
  @ReactMethod
  public void toast(String message, int duration) {
    Toast.makeText(getReactApplicationContext(), message, duration).show();
  }
  
  @ReactMethod
  public void toast(String message) {
	  this.toast(message, Toast.LENGTH_SHORT);
  }
  
  /*
  @ReactMethod
  public void measureLayout(int tag, int ancestorTag, Callback errorCallback, Callback successCallback) {
    try {
      measureLayout(tag, ancestorTag, mMeasureBuffer);
      float relativeX = PixelUtil.toDIPFromPixel(mMeasureBuffer[0]);
      float relativeY = PixelUtil.toDIPFromPixel(mMeasureBuffer[1]);
      float width = PixelUtil.toDIPFromPixel(mMeasureBuffer[2]);
      float height = PixelUtil.toDIPFromPixel(mMeasureBuffer[3]);
      successCallback.invoke(relativeX, relativeY, width, height);
    } catch (IllegalViewOperationException e) {
      errorCallback.invoke(e.getMessage());
    }
  }
  
  @ReactMethod
  public void measureLayout(int tag, int ancestorTag, Promise promise) {
    try {
      measureLayout(tag, ancestorTag, mMeasureBuffer);
      WritableMap map = Arguments.createMap();
      map.putDouble("relativeX", PixelUtil.toDIPFromPixel(mMeasureBuffer[0]));
      map.putDouble("relativeY", PixelUtil.toDIPFromPixel(mMeasureBuffer[1]));
      map.putDouble("width", PixelUtil.toDIPFromPixel(mMeasureBuffer[2]));
      map.putDouble("height", PixelUtil.toDIPFromPixel(mMeasureBuffer[3]));
      promise.resolve(map);
    } catch (IllegalViewOperationException e) {
      promise.reject(E_LAYOUT_ERROR, e);
    }
  }
  */
}