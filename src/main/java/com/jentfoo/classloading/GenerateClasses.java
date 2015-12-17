package com.jentfoo.classloading;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class GenerateClasses {
  public static final int CLASS_COUNT = 20000;
  public static final String CLASS_PREFIX = "GeneratedClass";

  public static void main(String[] args) throws IOException {
    File outputFolder = new File(args[0]);
    if (! outputFolder.getAbsolutePath().endsWith("com/jentfoo/classloading/generated") ||
        (outputFolder.exists() && (outputFolder.isFile() || outputFolder.list().length > 0))) {
      throw new IllegalStateException("Invalid output folder: " + args[0]);
    }
    outputFolder.mkdirs();

    for (int i = 0; i < CLASS_COUNT; i++) {
      String className = CLASS_PREFIX + i;
      try (FileOutputStream fos = new FileOutputStream(new File(outputFolder, className + ".java"))) {
        fos.write(("package com.jentfoo.classloading.generated;\n\n" +
                   "import com.jentfoo.classloading.AbstractGenerated;\n\n" +
                   "public class " + className + " extends AbstractGenerated {\n" +
                   "  public int foo() {\n" +
                   // do something?
                   "    return (int)(Math.random() * 1000);\n" +
                   "  }\n}").getBytes());
      }
    }
  }
}
