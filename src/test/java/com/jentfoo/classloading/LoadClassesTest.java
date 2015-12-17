package com.jentfoo.classloading;

import org.junit.Test;
import org.threadly.util.Clock;

public class LoadClassesTest {
  @Test
  public void loadClasses() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
    long start = Clock.accurateForwardProgressingMillis();
    for (int i = 0; i < GenerateClasses.CLASS_COUNT; i++) {
      ClassLoader.getSystemClassLoader().loadClass(this.getClass().getPackage().getName() +
                                                     ".generated." + GenerateClasses.CLASS_PREFIX + i);
    }
    System.out.println("---> run time: " + (Clock.accurateForwardProgressingMillis() - start));
  }
}
