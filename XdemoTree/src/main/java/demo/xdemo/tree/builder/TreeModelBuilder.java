package demo.xdemo.tree.builder;

import java.util.ArrayList;
import java.util.List;

import demo.xdemo.tree.TreeModel;
import demo.xdemo.tree.simple.SimpleTreeModel;

public class TreeModelBuilder {

  private final List<String> containers;

  private final List<String> documents;

  private final List<String> unexpected;

  public TreeModelBuilder() {
    this.containers = new ArrayList<>();
    this.documents = new ArrayList<>();
    this.unexpected = new ArrayList<>();
  }

  public void addDocument(String name) {
    documents.add(name);
  }

  public void addContainer(String name) {
    containers.add(name);
  }

  public void addUnexpected(String name) {
    unexpected.add(name);
  }

  public TreeModel build() {
    return new SimpleTreeModel(containers, documents);
  }
}
