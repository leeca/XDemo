package demo.xdemo.tree.xstream;

import java.io.IOException;
import java.io.OutputStreamWriter;

import com.thoughtworks.xstream.XStream;

public class SimplePersist<T> {

  public void save(OutputStreamWriter dst, T item) throws IOException {
    new XStream().toXML(item, dst);
  }
}
