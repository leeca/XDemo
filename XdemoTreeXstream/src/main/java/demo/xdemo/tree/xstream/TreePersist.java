package demo.xdemo.tree.xstream;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import com.thoughtworks.xstream.XStream;

import demo.xdemo.tree.TreeModel;

public class TreePersist {

  private final XStream xstream;

  public TreePersist() {
    xstream = configXStream();
  }

  public TreeModel load(InputStreamReader src) throws IOException {
    return (TreeModel) xstream.fromXML(src);
  }

  public void save(OutputStreamWriter dst, TreeModel item) throws IOException {
    xstream.toXML(item, dst);
  }

  private static XStream configXStream() {
    XStream result = new XStream();
    return result;
  }
}
