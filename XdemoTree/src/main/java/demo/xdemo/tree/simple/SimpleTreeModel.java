package demo.xdemo.tree.simple;

import java.util.List;
import java.util.stream.Collectors;

import demo.xdemo.tree.TreeModel;

public class SimpleTreeModel implements TreeModel {

  private final List<String> containers;

  private final List<String> documents;

  public SimpleTreeModel(List<String> containers, List<String> documents) {
    this.containers = containers;
    this.documents = documents;
  }

  public List<String> getContainers() {
    // Make a preventative copy.
    return containers.stream().collect(Collectors.toList());
  }

  public List<String> getDocuments() {
    // Make a preventative copy.
    return documents.stream().collect(Collectors.toList());
  }
}
