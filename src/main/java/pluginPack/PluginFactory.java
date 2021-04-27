package pluginPack;

import java.io.File;
import java.io.FileFilter;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class PluginFactory {

public static Plugin getPlugin(String address) {
	  if(!address.endsWith(".jar")) {
		  return null;
	  }
    File pluginFile = new File(address);
    try {
        URL jarURL = pluginFile.toURI().toURL();
        URLClassLoader classLoader = new URLClassLoader(new URL[]{jarURL});
        JarFile jf = new JarFile(pluginFile);
        Enumeration<JarEntry> entries = jf.entries();
        while (entries.hasMoreElements()) {
          String e = entries.nextElement().getName();
          if (!e.endsWith(".class")) continue;
          e = e.replaceAll("/", ".");
          e = e.replaceAll(".class", "");
          Class<?> plugCan = classLoader.loadClass(e);
          Class<?>[] interfaces = plugCan.getInterfaces();
          for (Class<?> interf : interfaces) {
            if (interf.getName().endsWith(".Plugin")) {
              Class<?> c = classLoader.loadClass(plugCan.getName());
              Object inst = c.getDeclaredConstructor().newInstance();
              return (Plugin)inst;
            }
          }
        }
      } catch (Exception e) {
        e.printStackTrace(System.err);
      }
    return null;
  }
}