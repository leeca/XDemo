package demo.xdemo.tree;

import java.io.IOException;

import demo.xdemo.tree.builder.TreeModelBuilder;
import demo.xdemo.tree.builder.TreeModelLoader;

public class TreeModelFactory {

  public static TreeModel loadTreeModel(String treePath) throws IOException {
    TreeModelBuilder builder = new TreeModelBuilder();
    TreeModelLoader loader = new TreeModelLoader(builder);
    loader.processRoot(treePath);
    return builder.build();
  }
}
