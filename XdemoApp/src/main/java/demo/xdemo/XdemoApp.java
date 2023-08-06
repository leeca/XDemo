package demo.xdemo;

import java.io.FileWriter;
import java.io.IOException;

import demo.xdemo.tree.TreeModel;
import demo.xdemo.tree.TreeModelFactory;
import demo.xdemo.tree.xstream.TreePersist;

public class XdemoApp {

  public static void main(String[] args) throws IOException {
    if (args.length == 2) {
      TreeModel treeModel = TreeModelFactory.loadTreeModel(args[1]);

      TreePersist treePersist = new TreePersist();

      try (FileWriter writer = new FileWriter(args[0])) {
        treePersist.save(writer, treeModel);
      }
      System.exit(0);
    }

    System.out.println("Usage: XdemoApp <dst-xml> <model-dir>");
    System.exit(1);
  }
}
