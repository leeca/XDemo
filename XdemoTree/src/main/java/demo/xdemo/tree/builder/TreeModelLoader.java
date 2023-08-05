package demo.xdemo.tree.builder;

import java.io.File;
import java.io.IOException;

public class TreeModelLoader {
  
  private final TreeModelBuilder treeBuilder;

  public TreeModelLoader(TreeModelBuilder treeBuilder) {
    this.treeBuilder = treeBuilder;
  }

  public void processRoot(String treePath) throws IOException {
    File treeFile = new File(treePath);

    // If it is just a file, it's pretty uninteresting - one node
    if (treeFile.isFile()) {
      treeBuilder.addDocument(treeFile.getName());
      return;
    }

    // If it's a directory, traverse the full tree
    if (treeFile.isDirectory()) {
      treeBuilder.addContainer(treeFile.getName());
      // prolly descend directory ..
      return;
    }

    // Hmmm .. something unexpected
    treeBuilder.addUnexpected(treeFile.getName());
  }
}
